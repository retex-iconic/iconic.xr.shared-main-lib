package com.retexspa.xr.ms.main.core.dto.attributo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.util.UUID;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(Include.NON_NULL)
public class AttributoIndexDTO {

  private String attributoId;

  public AttributoIndexDTO() {}

  public AttributoIndexDTO(String attributoId) {
    this.attributoId = attributoId;
  }

  public static String getIdFromAttributo(String attributoId) {
    return UUID.nameUUIDFromBytes(("/AttributoIndex/" + attributoId).getBytes()).toString();
  }

  public String getAttributoId() {
    return this.attributoId;
  }

  public void setAttributoId(String attributoId) {
    this.attributoId = attributoId;
  }

}
