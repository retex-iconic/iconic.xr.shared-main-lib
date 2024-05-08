package com.retexspa.xr.ms.main.core.queries;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GerarchiaAggregateGetByIdQuery {
    private String gerarchiaId;

    public GerarchiaAggregateGetByIdQuery(@JsonProperty("gerarchiaId") String gerarchiaId) {
        this.gerarchiaId = gerarchiaId;
    }

    public String getGerarchiaId() {
        return gerarchiaId;
    }

    public void setGerarchiaId(String gerarchiaId) {
        this.gerarchiaId = gerarchiaId;
    }
}