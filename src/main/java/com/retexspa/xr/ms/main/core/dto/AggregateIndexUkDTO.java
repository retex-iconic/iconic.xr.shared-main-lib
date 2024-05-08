package com.retexspa.xr.ms.main.core.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class AggregateIndexUkDTO {
  
  private String aggregateId;
  private String uk;
  private String event; // ADD/REMOVE

  public AggregateIndexUkDTO() {
  }

  public AggregateIndexUkDTO( String aggregateId, String uk) {
    this.aggregateId = aggregateId;
    this.uk = uk;
    this.event = "ADD"; // defualt
  }

  public AggregateIndexUkDTO(String aggregateId, String uk, String event) {
    this.aggregateId = aggregateId;
    this.uk = uk;
    this.event = event;
  }

  public String getAggregateId() {
    return this.aggregateId;
  }

  public void setAggregateId(String aggregateId) {
    this.aggregateId = aggregateId;
  }

  public void setUk(String codice) {
    this.uk = codice;
  }

  public String getUk() {
    return uk;
  }

  public String getEvent() {
    return event;
  }

  public void setEvent(String event) {
    this.event = event;
  }

  
}
