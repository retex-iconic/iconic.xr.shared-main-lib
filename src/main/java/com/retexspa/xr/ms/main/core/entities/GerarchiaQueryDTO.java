package com.retexspa.xr.ms.main.core.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.util.Set;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(Include.NON_NULL)
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public class GerarchiaQueryDTO {
  private String id;
  private String nome;
  private String codice;
  private Boolean nodoNegozio;
  private String negozioId;
  private String padreId;
  private Set<GerarchiaQueryDTO> figli;
  private Long version;
  
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }
  public String getNome() {
    return nome;
  }
  public void setNome(String nome) {
    this.nome = nome;
  }
  public String getCodice() {
    return codice;
  }
  public void setCodice(String codice) {
    this.codice = codice;
  }
  public Boolean getNodoNegozio() {
    return nodoNegozio;
  }
  public void setNodoNegozio(Boolean nodoNegozio) {
    this.nodoNegozio = nodoNegozio;
  }
  public String getNegozioId() {
    return negozioId;
  }
  public void setNegozioId(String negozioId) {
    this.negozioId = negozioId;
  }
  public String getPadreId() {
    return padreId;
  }
  public void setPadreId(String padreId) {
    this.padreId = padreId;
  }
  public Set<GerarchiaQueryDTO> getFigli() {
    return figli;
  }
  public void setFigli(Set<GerarchiaQueryDTO> figli) {
    this.figli = figli;
  }
  public Long getVersion() {
    return version;
  }
  public void setVersion(Long version) {
    this.version = version;
  }
  
}


