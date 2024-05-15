package com.retexspa.xr.ms.main.core.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(Include.NON_NULL)
@Mapper(unmappedTargetPolicy = ReportingPolicy.WARN)
public class AttributoQueryDTO {
  private String id;
  private String chiave;
  private String descrizione;
  private String aggregato;
  private String checkValue;
  private Long version;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getChiave() {
    return chiave;
  }

  public void setChiave(String chiave) {
    this.chiave = chiave;
  }

  public String getDescrizione() {
    return descrizione;
  }

  public void setDescrizione(String descrizione) {
    this.descrizione = descrizione;
  }

  public String getAggregato() {
    return aggregato;
  }

  public void setAggregato(String aggregato) {
    this.aggregato = aggregato;
  }

  public String getCheckValue() {
    return checkValue;
  }

  public void setCheckValue(String checkValue) {
    this.checkValue = checkValue;
  }

  public Long getVersion() {
    return version;
  }

  public void setVersion(Long version) {
    this.version = version;
  }
}
