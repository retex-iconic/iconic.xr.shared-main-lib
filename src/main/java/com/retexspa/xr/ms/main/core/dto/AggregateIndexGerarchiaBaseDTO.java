package com.retexspa.xr.ms.main.core.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.UUID;

@JsonInclude(Include.NON_NULL)
public class AggregateIndexGerarchiaBaseDTO extends AggregateIndexUkBaseDTO {

  private String gerarchiaId;

  public AggregateIndexGerarchiaBaseDTO() {
  }

  public AggregateIndexGerarchiaBaseDTO(String gerarchiaId) {
    super();
    this.gerarchiaId = gerarchiaId;
  }

  public static String getIdFromGerarchia(String gerarchiaId, String aggregate) {
    return UUID.nameUUIDFromBytes(("/" + aggregate + "/" + gerarchiaId).getBytes()).toString();
  }

  public static String getAggregateId(String gerarchiaId, String aggregate) {
    return UUID.nameUUIDFromBytes(("/" + aggregate + "/" + gerarchiaId).getBytes()).toString();
  }

  public String getGerarchiaId() {
    return this.gerarchiaId;
  }

  public void setGerarchiaId(String gerarchiaId) {
    this.gerarchiaId = gerarchiaId;
  }

}
