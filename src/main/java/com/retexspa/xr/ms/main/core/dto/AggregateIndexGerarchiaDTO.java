package com.retexspa.xr.ms.main.core.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class AggregateIndexGerarchiaDTO extends AggregateIndexUkDTO{

  private String gerarchiaId;
 
  public AggregateIndexGerarchiaDTO() {
  }

  public AggregateIndexGerarchiaDTO(String gerarchiaId, String aggregateId, String uk) {
    super(aggregateId, uk);
    this.gerarchiaId = gerarchiaId;
  }

  public AggregateIndexGerarchiaDTO(String gerarchiaId, String aggregateId, String uk, String event) {
    super(aggregateId, uk, event);
    this.gerarchiaId = gerarchiaId;
  }

  public String getGerarchiaId() {
    return this.gerarchiaId;
  }

  public void setGerarchiaId(String gerarchiaId) {
    this.gerarchiaId = gerarchiaId;
  }
  
}
