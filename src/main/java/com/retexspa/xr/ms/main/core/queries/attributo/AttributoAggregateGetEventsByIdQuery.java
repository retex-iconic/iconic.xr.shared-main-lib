package com.retexspa.xr.ms.main.core.queries.attributo;

public class AttributoAggregateGetEventsByIdQuery {
  private String attributoId;

  public AttributoAggregateGetEventsByIdQuery(String attributoId) {
    this.attributoId = attributoId;
  }

  public String getAttributoId() {
    return this.attributoId;
  }

  public void setAttributoId(String attributoId) {
    this.attributoId = attributoId;
  }
}
