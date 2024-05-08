package com.retexspa.xr.ms.main.core.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.retexspa.xr.ms.main.core.dto.negozio.NegozioBaseDTO;


import java.util.Map;

public class NegozioAggregateResponse extends BaseAggregateResponse<NegozioBaseDTO> {

  private Map<String, Object> lastEvent;

  public NegozioAggregateResponse(
          @JsonProperty("id") String id,  @JsonProperty("version") Long version, @JsonProperty("data") NegozioBaseDTO data,
      @JsonProperty("lastEvent") Map<String, Object> lastEvent) {
    super(id, version, data);
    this.lastEvent = lastEvent;
  }

  public Map<String, Object> getLastEvent() {
    return lastEvent;
  }

  public void setLastEvent(Map<String, Object> lastEvent) {
    this.lastEvent = lastEvent;
  }
}
