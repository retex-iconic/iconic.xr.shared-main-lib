package com.retexspa.xr.ms.main.core.dto.negozio;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.UUID;


@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(Include.NON_NULL)
public class NegozioIndexDTO {

  private String negozioId;
 
  public NegozioIndexDTO() {}

  public NegozioIndexDTO(String negozioId) {
    this.negozioId = negozioId;
  }

  
  public static String getIdFromNegozio(String negozioId) {
    return UUID.nameUUIDFromBytes(("/NegozioIndex/" + negozioId).getBytes()).toString();
  }

    public String getNegozioId() {
    return this.negozioId;
  }

  public void setNegozioId(String negozioId) {
    this.negozioId = negozioId;
  }

}
