package com.retexspa.xr.ms.main.core.dto.gerarchia;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(Include.NON_NULL)
public class GerarchiaIndexDTO {

  private String gerarchiaId;
  private Integer levelCounter;
  private Integer level;
  private List<String> nodoIds;

  public GerarchiaIndexDTO() {}

  public GerarchiaIndexDTO(String gerarchiaId) {
    this.gerarchiaId = gerarchiaId;
    this.nodoIds = new ArrayList<String>();
    this.levelCounter = 0;
    this.level = 0;
  }

  public static String getIdFromGerarchia(String gerarchiaId) {
    return UUID.nameUUIDFromBytes(("/GerarchiaIndex/" + gerarchiaId).getBytes()).toString();
  }

  public String getGerarchiaId() {
    return this.gerarchiaId;
  }

  public void setGerarchiaId(String gerarchiaId) {
    this.gerarchiaId = gerarchiaId;
  }

  public Integer getLevelCounter() {
    return this.levelCounter;
  }

  public void setLevelCounter(Integer levelCounter) {
    this.levelCounter = levelCounter;
  }

  public Integer getLevel() {
    return this.level;
  }

  public void setLevel(Integer level) {
    this.level = level;
  }

  public List<String> getNodoIds() {
    return this.nodoIds;
  }

  public void setNodoIds(List<String> nodoIds) {
    this.nodoIds = nodoIds;
  }

  public static String getDetailNameNodo() {
    return "nodoIds";
  }


}
