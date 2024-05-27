package com.retexspa.xr.ms.main.query.filterRequest;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.LinkedHashMap;

public class GerarchiaFilter {

    private String id;
    private String codice;
    private String nome;
    private Long version;

    public GerarchiaFilter() {
    }

    public GerarchiaFilter(
            @JsonProperty("id") String id,
            @JsonProperty("codice") String codice,
            @JsonProperty("nome") String nome,
            @JsonProperty("version")Long version) {
        this.id = id;
        this.codice = codice;
        this.nome = nome;
        this.version = version;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public static GerarchiaFilter createFilterFromMap(Object obj) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();

        // Convert GerarchiaFilter object to JSON string
        String json = mapper.writeValueAsString(obj);
        LinkedHashMap<String, Object> map = mapper.readValue(json, LinkedHashMap.class);

        //LinkedHashMap<String, Object> map = (LinkedHashMap<String, Object>) obj;
        GerarchiaFilter filter = new GerarchiaFilter();
        if(map != null){
            filter.setId((String) map.get("id"));
            filter.setCodice((String) map.get("codice"));
            filter.setNome((String) map.get("nome"));
            Object version = map.get("version");
            if(version != null){
                if(version instanceof Integer){
                    filter.setVersion(Long.valueOf((Integer) version));
                } else if (version instanceof Long){
                    filter.setVersion((Long) version);
                }
            }
        }
        return filter;
    }


}
