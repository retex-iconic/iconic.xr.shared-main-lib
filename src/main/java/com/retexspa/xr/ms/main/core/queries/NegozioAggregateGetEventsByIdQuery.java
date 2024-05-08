package com.retexspa.xr.ms.main.core.queries;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class NegozioAggregateGetEventsByIdQuery {
  private String negozioId;

  public String getNegozioId() {
    return negozioId;
  }

  public void setNegozioId(String negozioId) {
    this.negozioId = negozioId;
  }
}
