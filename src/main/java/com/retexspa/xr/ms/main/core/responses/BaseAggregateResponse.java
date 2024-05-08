package com.retexspa.xr.ms.main.core.responses;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class BaseAggregateResponse<T> {
  public final String id;
  public final Long version;
  public final T data;

  public BaseAggregateResponse(String id, Long version, T data) {
    this.id = id;
    this.version = version;
    this.data = data;
  }

  public String getId() {
    return this.id;
  }

  public Long getVersion() {
    return this.version;
  }

  public T getData() {
    return this.data;
  }
}
