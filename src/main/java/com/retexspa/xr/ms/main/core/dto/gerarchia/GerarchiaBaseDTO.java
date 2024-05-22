package com.retexspa.xr.ms.main.core.dto.gerarchia;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.util.UUID;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@JsonInclude(Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class GerarchiaBaseDTO {

  @NotEmpty(message = "nome gerarchia is mandatory")
  @NotEmpty(message = "nome gerarchia is mandatory")
  @NotBlank(message = "nome gerarchia is mandatory")
  private String nome;

  @NotNull(message = "codice is mandatory")
  @NotEmpty(message = "codice is mandatory")
  @NotBlank(message = "codice is mandatory")
  private String codice;

  private String padreId;

  private Boolean nodoNegozio;

  private Integer level;

  private String negozioId;

  public String getNome() {
    return this.nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCodice() {
    return this.codice;
  }

  public void setCodice(String codice) {
      this.codice = codice;
  }

  public String getPadreId() {
    return this.padreId;
  }

  public void setPadreId(String padreId) {
    if (padreId != null && !padreId.isEmpty()) {
      this.padreId = padreId;
    }
  }

  public Boolean isNodoNegozio() {
    return this.nodoNegozio;
  }

  public Boolean getNodoNegozio() {
    return this.nodoNegozio;
  }

  public void setNodoNegozio(Boolean nodoNegozio) {
    if (this.nodoNegozio == null || this.nodoNegozio == false) {
      this.nodoNegozio = nodoNegozio;
    }
  }

  @JsonIgnore
  public String getAggregateId() {
    return UUID.nameUUIDFromBytes(("/Gerarchia/" + this.getCodice()).getBytes()).toString();
  }

  public Integer getLevel() {
    return level;
  }

  public void setLevel(Integer level) {
    this.level = level;
  }

  public String getNegozioId() {
    return negozioId;
  }

  public void setNegozioId(String negozioId) {
    this.negozioId = negozioId;
  }

  public static String getDetailNameGerarchia() {
    return "Gerarchia";
  }

  public static String getDetailNameGerarchiaAggregate() {
    return "GerarchiaAggregate";
  }
}
