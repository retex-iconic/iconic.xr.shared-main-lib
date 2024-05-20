package com.retexspa.xr.ms.main.core.filterRequest;

import java.util.LinkedHashMap;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AttributoFilter {
    private String id;
    private String chiave;
    private String descrizione;
    private String aggregato;
    private String checkValue;
    private Long version;   
  
    public AttributoFilter() {
    }

    public AttributoFilter(       
        @JsonProperty("id") String id,
        @JsonProperty("chiave") String chiave,
        @JsonProperty("descrizione") String descrizione,
        @JsonProperty("aggregato") String aggregato,
        @JsonProperty("checkValue") String checkValue,
        @JsonProperty("version") Long version) {
      this.id = id;
      this.chiave = chiave;
      this.descrizione = descrizione;
      this.aggregato = aggregato;
      this.checkValue = checkValue;
      this.version = version;
    }
  
    public String getId() {
      return this.id;
    }
  
    public void setId(String id) {
      this.id = id;
    }
  
    public String getChiave() {
      return this.chiave;
    }
  
    public void setChiave(String chiave) {
      this.chiave = chiave;
    }
  
    public String getDescrizione() {
      return this.descrizione;
    }
  
    public void setDescrizione(String descrizione) {
      this.descrizione = descrizione;
    }
  
    public String getAggregato() {
      return this.aggregato;
    }
  
    public void setAggregato(String aggregato) {
      this.aggregato = aggregato;
    }
  
    public Long getVersion() {
      return this.version;
    }
  
    public void setVersion(Long version) {
      this.version = version;
    }

    public String getCheckValue() {
        return checkValue;
    }

    public void setCheckValue(String checkValue) {
        this.checkValue = checkValue;
    }

    public static AttributoFilter createFilterFromMap(Object obj) throws JsonProcessingException  {

        ObjectMapper mapper = new ObjectMapper();

        // Convert GerarchiaFilter object to JSON string
        String json = mapper.writeValueAsString(obj);
        LinkedHashMap<String, Object> map = mapper.readValue(json, LinkedHashMap.class);

        //LinkedHashMap<String, Object> map = (LinkedHashMap<String, Object>) obj;
        AttributoFilter filter = new AttributoFilter();
        if(map != null){
            filter.setId((String) map.get("id"));
            filter.setChiave((String) map.get("chiave"));
            filter.setDescrizione((String) map.get("descrizione"));
            filter.setAggregato((String) map.get("aggregato"));
            filter.setCheckValue((String) map.get("checkValue"));
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
