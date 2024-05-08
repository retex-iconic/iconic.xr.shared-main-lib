package com.retexspa.xr.ms.main.core.responses;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class BaseCommandResponse {
  public String id;
  public Long version;
  public String message;

  public BaseCommandResponse() {}

  public BaseCommandResponse(String id) {
    this.id = id;
  }

  public BaseCommandResponse(String id, Long version) {
    this.id = id;
    this.version = version;
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Long getVersion() {
    return this.version;
  }

  public void setVersion(Long version) {
    this.version = version;
  }

  public String getMessage() {
    return this.message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
