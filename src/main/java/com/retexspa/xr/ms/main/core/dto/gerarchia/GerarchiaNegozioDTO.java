package com.retexspa.xr.ms.main.core.dto.gerarchia;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(Include.NON_NULL)
public class GerarchiaNegozioDTO {
  private String gearchiaId;
  private String negozioId;

  public GerarchiaNegozioDTO() {}

  public GerarchiaNegozioDTO(String gearchiaId, String negozioId) {
    this.gearchiaId = gearchiaId;
    this.negozioId = negozioId;
  }

  public String getGerarchiaId() {
    return this.gearchiaId;
  }

  public void setGerarchiaId(String gearchiaId) {
    this.gearchiaId = gearchiaId;
  }

  public String getNegozioId() {
    return this.negozioId;
  }

  public void setNegozioId(String negozioId) {
    this.negozioId = negozioId;
  }
}
