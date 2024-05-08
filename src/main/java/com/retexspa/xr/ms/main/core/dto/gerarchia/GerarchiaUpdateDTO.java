package com.retexspa.xr.ms.main.core.dto.gerarchia;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonInclude(Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class GerarchiaUpdateDTO {

  private String nome;

  private Boolean nodoNegozio;

  public String getNome() {
    return this.nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
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


}
