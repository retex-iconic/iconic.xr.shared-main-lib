package com.retexspa.xr.ms.main.core.responses;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.retexspa.xr.ms.main.core.entities.NegozioQueryDTO;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class NegoziResponse extends BasePaginationResponse<NegozioQueryDTO> {

  public NegoziResponse() {
    super();
  }
}
