package com.retexspa.xr.ms.main.query.filterRequest;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.LinkedHashMap;

public class GerarchiaFilter {

    private String id;
    private String code;
    private String name;
    private Long version;

    public GerarchiaFilter() {
    }

    public GerarchiaFilter(
            @JsonProperty("id") String id,
            @JsonProperty("code") String code,
            @JsonProperty("name") String name,
            @JsonProperty("version")Long version) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.version = version;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
            filter.setCode((String) map.get("code"));
            filter.setName((String) map.get("name"));
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
