package com.retexspa.xr.ms.main.query.helpers;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.JsonProcessingException;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

// import com.retexspa.xr.ms.masterdata.main.query.repositories.IvaAffiliazioneRepository;
import com.retexspa.xr.ms.main.core.entities.GerarchiaQueryDTO;
import com.retexspa.xr.ms.main.query.mappers.GerarchiaQueryMapper;
import io.dapr.client.DaprClient;
import io.dapr.client.domain.State;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import com.retexspa.xr.ms.main.query.Aggregato;

import com.retexspa.xr.ms.main.query.repositories.GerarchiaRepository;

import reactor.core.publisher.Mono;

// Ogni aggregato ha un codice ed una gerarchia associata.
// Questa tupla è univoca. Per ogni tupla corrsponde un aggregato id
// Per ogni evento su un aggrgato id dobbiamo ricavare il codice dell'aggregato
// e la gerarchia associata.
// Dobbiamo interrogare il db della proiezione dell'aggregato con un "where codice={codice}"" e ricavare
// l'elenco di aggregato id , codice e gararchia id  ( esempio in response.json)
// Dobbiamo sempre tenere in memoria la gerarchia completa ( esempio in gerarchie.json)
// Lo scopo è ottenere l'elenco di negozio id associati ad un aggregato id.

@Service
public class AffiliazioniHelper {

  @Autowired
  private GerarchiaRepository gerarchiaRepository;

  @Autowired
  private GerarchiaQueryMapper gerarchiaQueryMapper;

  @Autowired
  private DaprClient daprClient;

  private final String gerarchiaStateKey = "gerarchie";
  private String stateStoreName = "iconic-xrmsmasterdata-statestore";
  private final String SEPARATOR = "#SEP#";
  // public AffiliazioniHelper(GerarchiaRepository gerarchiaRepository) {
  // this.gerarchiaRepository = gerarchiaRepository;
  // }

  public void setStateStoreName(String stateStoreName) {
    this.stateStoreName = stateStoreName;
  }

  public HashMap<String, Integer> GerarchiaToLevelMap(GerarchiaQueryDTO gerarchia, Integer level,
                                                      HashMap<String, Integer> map) {

    map.put(gerarchia.getId(), level);
    if (gerarchia.getFigli() != null) {
      for (GerarchiaQueryDTO figlio : gerarchia.getFigli()) {
        GerarchiaToLevelMap(figlio, level + 1, map);
      }
    }
    return map;
  }

  public HashMap<String, ArrayList<String>> AggregatoToStoreMap(Aggregato[] aggregati, GerarchiaQueryDTO gerarchia,
      HashMap<String, ArrayList<String>> map) {
    ArrayList<String> negozioIds;
    for (Aggregato aggregato : aggregati) {
      GerarchiaQueryDTO gerarchiaById = getGerarchiaById(gerarchia, aggregato.getGerarchia_id());
      if (gerarchiaById != null) {
        negozioIds = new ArrayList<>();
        negozioIds = GerarchiaToNegozioIds(gerarchiaById, negozioIds);
        map.put(aggregato.getGerarchia_id(), negozioIds);
      }
    }
    return map;
  }

  public ArrayList<String> GerarchiaToNegozioIds(GerarchiaQueryDTO gerarchia, ArrayList<String> negozioIds) {
    if (gerarchia.getNegozioId() != null) {
      negozioIds.add(gerarchia.getNegozioId());
    }

    if (gerarchia.getFigli() != null) {
      for (GerarchiaQueryDTO figlio : gerarchia.getFigli()) {
        GerarchiaToNegozioIds(figlio, negozioIds);
      }
    }
    return negozioIds;
  }

  public GerarchiaQueryDTO getGerarchiaById(GerarchiaQueryDTO gerarchia, String id) {
    if (gerarchia.getId().equals(id)) {
      return gerarchia;
    }
    if (gerarchia.getFigli() != null) {
      for (GerarchiaQueryDTO figlio : gerarchia.getFigli()) {
        GerarchiaQueryDTO gerarchiaById = getGerarchiaById(figlio, id);
        if (gerarchiaById != null) {
          return gerarchiaById;
        }
      }
    }
    return null;
  }

  public List<String> getListGerarchia(String gerarchiaId) {
    List<String> result = new ArrayList<>();
    GerarchiaQueryDTO[] gerarchie = loadGerarchie();
    GerarchiaQueryDTO gerarchia = findGerarchiaById(gerarchiaId, gerarchie);
    if (gerarchia != null) {
      collectAncestorGerarchiaIds(gerarchia.getPadreId(), result, gerarchie);
    }
    return result;
  }

  public Integer getGerarchiaLevel(String padreId, Integer level) {
    GerarchiaQueryDTO[] gerarchie = loadGerarchie();
    GerarchiaQueryDTO gerarchia = findGerarchiaById(padreId, gerarchie);
    if (gerarchia != null && gerarchia.getPadreId() != null) {
      level += level;
      getGerarchiaLevel(gerarchia.getPadreId(), level);
    }
    return level;
  }

  private void collectAncestorGerarchiaIds(String padreId, List<String> result, GerarchiaQueryDTO[] gerarchie) {
    result.add(padreId);
    GerarchiaQueryDTO gerarchia = findGerarchiaById(padreId, gerarchie);

    if (gerarchia != null && gerarchia.getPadreId() != null) {
      collectAncestorGerarchiaIds(gerarchia.getPadreId(), result, gerarchie);
    }
  }

  private GerarchiaQueryDTO[] loadGerarchie() {
    return daprClient.getState(stateStoreName, gerarchiaStateKey, GerarchiaQueryDTO[].class)
        .block().getValue();
  }

  private GerarchiaQueryDTO findGerarchiaById(String gerarchiaId, GerarchiaQueryDTO[] gerarchie) {
    GerarchiaQueryDTO gerarchia = new GerarchiaQueryDTO();
    for (GerarchiaQueryDTO g : gerarchie) {
      if (g.getId().equals(gerarchiaId)) {
        gerarchia = g;
        return gerarchia;
      }
    }
    return gerarchia;
  }

  public ArrayList<String> getNegozioIdsByGerarchiaId(String gerarchiaId, HashMap<String, Integer> levelMap,
      HashMap<String, ArrayList<String>> storeMap) {

    Integer level = levelMap.get(gerarchiaId);
    ArrayList<String> negozioIds = storeMap.get(gerarchiaId);
    HashSet<String> setA = new HashSet<>(negozioIds);
    for (Map.Entry<String, ArrayList<String>> entry : storeMap.entrySet()) {
      if (!entry.getKey().equals(gerarchiaId) && levelMap.get(entry.getKey()) > level) {
        HashSet<String> setB = new HashSet<>(entry.getValue());
        setA.removeAll(setB);
      }
    }
    return new ArrayList<>(setA);

  }

  public Mono<State<GerarchiaQueryDTO[]>> updateStateGerarchia() {
    List<GerarchiaQueryDTO> gerarchie = gerarchiaRepository.findAll()
        .stream()
        .map(entity -> gerarchiaQueryMapper.toDTO(entity))
        .collect(Collectors.toList());
    daprClient.saveState(stateStoreName, gerarchiaStateKey, gerarchie).block();
    return daprClient.getState(stateStoreName, gerarchiaStateKey, GerarchiaQueryDTO[].class);
  }

  public static Aggregato[] convertToAggregati(List<?> entities) throws JsonProcessingException {
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    objectMapper.registerModule(new JavaTimeModule());
    String json = "";
    try {
      json = objectMapper.writeValueAsString(entities);

    } catch (Exception e) {
      e.printStackTrace();
    }
    Aggregato[] list = objectMapper.readValue(json, Aggregato[].class);
    return list;
  }


  public ArrayList<String> getAffiliazione(String gerarchiaId, List<?> entities)
      throws IOException {
    GerarchiaQueryDTO[] gerarchie = loadGerarchie();
    GerarchiaQueryDTO gerarchia = findGerarchiaById(gerarchiaId, gerarchie);

    HashMap<String, Integer> levelMap = GerarchiaToLevelMap(gerarchia, 0, new HashMap<String, Integer>());
    Aggregato[] aggregati = convertToAggregati(entities);
    HashMap<String, ArrayList<String>> storeMap = AggregatoToStoreMap(aggregati, gerarchia,
        new HashMap<String, ArrayList<String>>());
    ArrayList<String> negozioIds = getNegozioIdsByGerarchiaId(gerarchiaId, levelMap, storeMap);
    return negozioIds;
  }

  public String getSEPARATOR() {
    return SEPARATOR;
  }

}
