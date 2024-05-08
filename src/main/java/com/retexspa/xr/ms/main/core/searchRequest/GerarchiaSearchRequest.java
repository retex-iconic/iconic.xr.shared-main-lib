package com.retexspa.xr.ms.main.core.searchRequest;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.retexspa.xr.ms.main.core.queries.BaseSort;
import com.retexspa.xr.ms.main.core.queries.BaseSortPagination;

import java.util.List;

public class GerarchiaSearchRequest extends BaseSortPagination {

    private String id;
    private String code;
    private String description;
    private Long version;

    
    public GerarchiaSearchRequest(
            @JsonProperty("page") Integer page,
            @JsonProperty("limit") Integer limit,
            @JsonProperty("sort") List<BaseSort> sort,
            @JsonProperty("id") String id,
            @JsonProperty("code") String code,
            @JsonProperty("description") String description, 
            @JsonProperty("version")Long version) {
        super(page, limit, sort);
        this.id = id;
        this.code = code;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
