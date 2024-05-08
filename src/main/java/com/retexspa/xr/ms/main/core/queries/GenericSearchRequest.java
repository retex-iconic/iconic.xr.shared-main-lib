package com.retexspa.xr.ms.main.core.queries;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GenericSearchRequest<T> extends BaseSortPagination {

    private T filter;

    public GenericSearchRequest(
            @JsonProperty("page") Integer page,
            @JsonProperty("limit") Integer limit,
            @JsonProperty("sort") List<BaseSort> sort,
            @JsonProperty("filter") T filter) {
        super(page, limit, sort);
        this.filter = filter;
    }

    public T getFilter() {
        return filter;
    }

    public void setFilter(T filter) {
        this.filter = filter;
    }

}
