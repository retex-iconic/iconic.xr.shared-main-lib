package com.retexspa.xr.ms.main.core.dto.subscribeData;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonInclude(Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class SubscribeDataDTO {
  @NotEmpty(message = "nome tabella is mandatory")
  @NotEmpty(message = "nome tabella is mandatory")
  @NotBlank(message = "nome tabella is mandatory")
  @JsonProperty("tabella")
  private String tabella;

  @NotEmpty(message = "aggregatoId is mandatory")
  @NotEmpty(message = "aggregatoId is mandatory")
  @NotBlank(message = "aggregatoId is mandatory")
  @JsonProperty("aggregatoId")
  private String aggregatoId;

  @NotEmpty(message = "eventTypeCrud is mandatory")
  @NotEmpty(message = "eventTypeCrud is mandatory")
  @NotBlank(message = "eventTypeCrud is mandatory")
  @JsonProperty("eventTypeCrud")
  private String eventTypeCrud;

  @JsonProperty("gerarchiaId")
  private String gerarchiaId;

  @JsonProperty("negozioId")
  private String negozioId;

  public SubscribeDataDTO(
      String tabella,
      String aggregatoId,
      String gerarchiaId,
      String negozioId,
      String eventTypeCrud) {
    this.tabella = tabella;
    this.aggregatoId = aggregatoId;
    this.gerarchiaId = gerarchiaId;
    this.negozioId = negozioId;
    this.eventTypeCrud = eventTypeCrud;
  }

  public SubscribeDataDTO() {
  }

  public String getTabella() {
    return this.tabella;
  }

  public void setTabella(String tabella) {
    this.tabella = tabella;
  }

  public String getAggregatoId() {
    return this.aggregatoId;
  }

  public void setAggregatoId(String aggregatoId) {
    this.aggregatoId = aggregatoId;
  }

  public String getGerarchiaId() {
    return this.gerarchiaId;
  }

  public void setGerarchiaId(String gerarchiaId) {
    this.gerarchiaId = gerarchiaId;
  }

  public String getNegozioId() {
    return this.negozioId;
  }

  public void setNegozioId(String negozioId) {
    this.negozioId = negozioId;
  }

  public String getEventTypeCrud() {
    return this.eventTypeCrud;
  }

  public void setEventTypeCrud(String eventTypeCrud) {
    this.eventTypeCrud = eventTypeCrud;
  }
}
