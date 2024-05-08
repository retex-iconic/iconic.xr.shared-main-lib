package com.retexspa.xr.ms.main.core.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.retexspa.xr.ms.main.core.helpers.EnumValidator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@JsonInclude(Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class BaseDTO {

  public BaseDTO() {
  }

  @EnumValidator(enumClazz = Enums.CheckSN.class, message = "FlgCancellato not valid")
  private String flgCancellato;

  @NotNull(message = "codice is mandatory")
  @NotEmpty(message = "codice is mandatory")
  @NotBlank(message = "codice is mandatory")
  private String codice;

  @NotNull(message = "nome is mandatory")
  private String nome;

  @NotNull(message = "descrizione is mandatory")
  private String descrizione;

  private String padreId;

  @NotNull(message = "gerarchiaId is mandatory")
  @NotEmpty(message = "gerarchiaId is mandatory")
  @NotBlank(message = "gerarchiaId is mandatory")
  private String gerarchiaId;

  public String getCodice() {
    return this.codice;
  }

  public void setCodice(String codice) {
    if (this.codice == null) {
      this.codice = codice;
    }
  }

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

  public String getPadreId() {
    return this.padreId;
  }

  public void setPadreId(String padreId) {
    this.padreId = padreId;
  }

  public String getGerarchiaId() {
    return this.gerarchiaId;
  }

  public void setGerarchiaId(String gerarchiaId) {
    if (gerarchiaId != null && !gerarchiaId.isEmpty()) {
      this.gerarchiaId = gerarchiaId;
    }
  }

  public String getFlgCancellato() {
    return flgCancellato;
  }

  public void setFlgCancellato(String flgCancellato) {
    this.flgCancellato = (flgCancellato == null ? "N" : flgCancellato);
  }

    @Override
    public String toString() {
        // add JSON processing exception handling, dropped for readability
        try {
          return new ObjectMapper().writeValueAsString(this);
        } catch (JsonProcessingException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
        return this.toString();
    }

    
}
