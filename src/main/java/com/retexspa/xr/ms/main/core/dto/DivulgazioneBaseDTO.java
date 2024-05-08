package com.retexspa.xr.ms.main.core.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DivulgazioneBaseDTO {
  private String tabella;
  private String aggregatoId;
  private String gerarchiaId;
  private String negozioId;
  private String eventTypeCrud;   

  public DivulgazioneBaseDTO() {
  }

  public DivulgazioneBaseDTO(String tabella, String aggregatoId, String gerarchiaId, String negozioId,
      String eventTypeCrud) {
    this.tabella = tabella;
    this.aggregatoId = aggregatoId;
    this.gerarchiaId = gerarchiaId;
    this.negozioId = negozioId;
    this.eventTypeCrud = eventTypeCrud;
  }

  // Constructor with String argument
  public DivulgazioneBaseDTO(String jsonString) {
    // Deserialize JSON string to DivulgazioneBaseDTO
    ObjectMapper mapper = new ObjectMapper();
    try {
      DivulgazioneBaseDTO dto = mapper.readValue(jsonString, DivulgazioneBaseDTO.class);
      this.tabella = dto.getTabella();
      this.aggregatoId = dto.getAggregatoId();
      this.gerarchiaId = dto.getGerarchiaId();
      this.negozioId = dto.getNegozioId();
      this.eventTypeCrud = dto.getEventTypeCrud();
      // Set other fields as needed
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
  }

  public String getTabella() {
    return tabella;
  }

  public void setTabella(String tabella) {
    this.tabella = tabella;
  }

  public String getAggregatoId() {
    return aggregatoId;
  }

  public void setAggregatoId(String aggregatoId) {
    this.aggregatoId = aggregatoId;
  }

  public String getGerarchiaId() {
    return gerarchiaId;
  }

  public void setGerarchiaId(String gerarchiaId) {
    this.gerarchiaId = gerarchiaId;
  }

  public String getNegozioId() {
    return negozioId;
  }

  public void setNegozioId(String negozioId) {
    this.negozioId = negozioId;
  }

  public String getEventTypeCrud() {
    return eventTypeCrud;
  }

  public void setEventTypeCrud(String eventTypeCrud) {
    this.eventTypeCrud = eventTypeCrud;
  }

}
