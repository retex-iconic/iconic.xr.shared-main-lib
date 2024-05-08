package com.retexspa.xr.ms.main.query.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Optional;
import java.util.Random;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.retexspa.xr.ms.main.core.dto.gerarchia.GerarchiaBaseDTO;
import org.springframework.lang.NonNull;

@Entity
@Table(name = "gerarchie")
public class GerarchiaQueryEntity {

  @Id
  @NonNull
  private String id;

  @Column(name = "nome")
  private String nome;

  @Column(name = "codice")
  private String codice;

  @Column(name = "nodoNegozio")
  private Boolean nodoNegozio;

  @Column(name = "version")
  private Long version;

  @ManyToOne(fetch = FetchType.LAZY)
  private GerarchiaQueryEntity padre;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "padre")
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private Set<GerarchiaQueryEntity> figli;

  @OneToOne(mappedBy = "gerarchia", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  // @JoinColumn(name = "negozioId", referencedColumnName = "id")
  @JsonManagedReference
  private NegozioQueryEntity negozio;

  private Integer level;

  public GerarchiaQueryEntity() {
  }

  public GerarchiaQueryEntity(
      String gerarchiaId,
      GerarchiaBaseDTO gerarchiaDTO,
      Optional<GerarchiaQueryEntity> padreEntity,
      Optional<NegozioQueryEntity> negozioEntity,
      Integer level,
      Long version)
      throws IOException {

    this.id = gerarchiaId;
    this.nome = gerarchiaDTO.getNome();
    this.version = version;

    if (gerarchiaDTO.getCodice() == null) {
      byte[] array = new byte[7]; // length is bounded by 7
      new Random().nextBytes(array);
      String codiceRandom = new String(array, Charset.forName("UTF-8"));
      this.codice = codiceRandom;
    } else {
      this.codice = gerarchiaDTO.getCodice();
    }

    if (padreEntity.isPresent()) {
      this.padre = padreEntity.get();
    }

    if (gerarchiaDTO.isNodoNegozio() == null) {
      this.nodoNegozio = false;
    } else {
      this.nodoNegozio = gerarchiaDTO.isNodoNegozio();
    }

    if (negozioEntity.isPresent()) {
      this.negozio = negozioEntity.get();
    }
    this.level = level;
    this.version=version;
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

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

  public GerarchiaQueryEntity getPadre() {
    return this.padre;
  }

  public void setPadre(GerarchiaQueryEntity padre) {
    this.padre = padre;
  }

  @JsonIgnore
  public Set<GerarchiaQueryEntity> getFigli() {
    return this.figli;
  }

  public void setFigli(Set<GerarchiaQueryEntity> figli) {
    this.figli = figli;
  }

  public Boolean isNodoNegozio() {
    return this.nodoNegozio;
  }

  public Boolean getNodoNegozio() {
    return this.nodoNegozio;
  }

  public void setNodoNegozio(Boolean nodoNegozio) {
    this.nodoNegozio = nodoNegozio;
  }

  public NegozioQueryEntity getNegozio() {
    return this.negozio;
  }

  public void setNegozio(NegozioQueryEntity negozio) {
    this.negozio = negozio;
  }

  public Integer getLevel() {
    return level;
  }

  public void setLevel(Integer level) {
    this.level = level;
  }

  public Long getVersion() {
    return version;
  }

  public void setVersion(Long version) {
    this.version = version;
  }

}
