package com.retexspa.xr.ms.main.core.dto.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.retexspa.xr.ms.main.core.dto.Enums;
import com.retexspa.xr.ms.main.core.helpers.EnumValidator;

@JsonInclude(Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ConfigUpdateDTO {
  private String nome;
  private String descrizione;

  @EnumValidator(enumClazz = Enums.CheckSN.class, message = "FlgAttivo not valid")
  private String flgAttivo;

  public String getNome() {
    return this.nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getDescrizione() {
    return this.descrizione;
  }

  public void setDescrizione(String descrizione) {
    this.descrizione = descrizione;
  }

  public String getFlgAttivo() {
    return this.flgAttivo;
  }

  public void setFlgAttivo(String flgAttivo) {
    this.flgAttivo = flgAttivo;
  }
}
