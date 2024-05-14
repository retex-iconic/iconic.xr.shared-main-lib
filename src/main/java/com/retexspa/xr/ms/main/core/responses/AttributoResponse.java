package com.retexspa.xr.ms.main.core.responses;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.retexspa.xr.ms.main.core.entities.AttributoQueryDTO;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AttributoResponse extends BasePaginationResponse<AttributoQueryDTO> {

  public AttributoResponse() {
    super();
  }
}
