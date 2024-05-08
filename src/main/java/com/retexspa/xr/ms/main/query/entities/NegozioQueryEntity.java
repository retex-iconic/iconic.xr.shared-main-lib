package com.retexspa.xr.ms.main.query.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.IOException;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.retexspa.xr.ms.main.core.dto.negozio.NegozioBaseDTO;
import org.springframework.lang.NonNull;

@Entity
@Table(name = "negozi", indexes = {
    @Index(name = "index_negozio_nome", columnList = "nome"),
    @Index(name = "index_negozio_codice", columnList = "codice"),
    @Index(name = "index_negozio_descrizione", columnList = "descrizione"),
    @Index(name = "index_negozio_codicefiscale", columnList = "codicefiscale")
    
})
public class NegozioQueryEntity {

  @Id
  @NonNull
  private String id;

  @Column(name = "nome")
  private String nome;

  @Column(name = "codice")
  private String codice;

  @Column(name = "descrizione")
  private String descrizione;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "gerarchia_id", referencedColumnName = "id")
  @JsonBackReference
  private GerarchiaQueryEntity gerarchia;

  @Column(name = "ragionesociale")
  private String ragioneSociale;

  @Column(name = "codicefiscale")
  private String codiceFiscale;

  @Column(name = "regimefiscale")
  private String regimeFiscale;

  @Column(name = "magazzino")
  private String magazzino;

  @Column(name = "differenzialePartitaIVA")
  private String differenzialePartitaIVA;

  @Column(name = "nazionePartitaIVA")
  private String nazionePartitaIVA;

  @Column(name = "partitaIVA")
  private String partitaIVA;

  @Column(name = "reaUfficio")
  private String reaUfficio;

  @Column(name = "reaNumero")
  private String reaNumero;

  @Column(name = "reaCapitaleSociale")
  private BigDecimal reaCapitaleSociale;

  @Column(name = "reaSocioUnico")
  private String reaSocioUnico;

  @Column(name = "reaLiquidazione")
  private String reaLiquidazione;

  @Column(name = "codiceDestinatarioSDI")
  private String codiceDestinatarioSDI;

  @Column(name = "sedeLegaleIndirizzo")
  private String sedeLegaleIndirizzo;

  @Column(name = "sedeLegaleNumeroCivico")
  private String sedeLegaleNumeroCivico;

  @Column(name = "sedeLegaleCAP")
  private String sedeLegaleCAP;

  @Column(name = "sedeLegaleComune")
  private String sedeLegaleComune;

  @Column(name = "sedeLegaleProvincia")
  private String sedeLegaleProvincia;

  @Column(name = "sedeLegaleNazione")
  private String sedeLegaleNazione;

  @Column(name = "sedeOperativaNome")
  private String sedeOperativaNome;

  @Column(name = "sedeOperativaIndirizzo")
  private String sedeOperativaIndirizzo;

  @Column(name = "sedeOperativaNumeroCivico")
  private String sedeOperativaNumeroCivico;

  @Column(name = "sedeOperativaCAP")
  private String sedeOperativaCAP;

  @Column(name = "sedeOperativaComune")
  private String sedeOperativaComune;

  @Column(name = "sedeOperativaProvincia")
  private String sedeOperativaProvincia;

  @Column(name = "sedeOperativaNazione")
  private String sedeOperativaNazione;

  @Column(name = "telefono")
  private String telefono;

  @Column(name = "cellulare")
  private String cellulare;

  @Column(name = "fax")
  private String fax;

  @Column(name = "email")
  private String email;

  @Column(name = "pec")
  private String pec;

  @Column(name = "web")
  private String web;

  @Column(name = "iban")
  private String iban;

  @Column(name = "nazioneTrasmittente")
  private String nazioneTrasmittente;

  @Column(name = "partitaIvaTrasmittente")
  private String partitaIvaTrasmittente;

  @Column(name = "codiceAteco")
  private String codiceAteco;

  @Column(name = "canale")
  private String canale;

  @Column(name = "insegna")
  private String insegna;

  @Column(name = "ivaVentilata")
  private Boolean ivaVentilata;
  @Column(name = "version")
  private Long version;

  public NegozioQueryEntity() {
  }

  public NegozioQueryEntity(String negozioId, NegozioBaseDTO negozioDTO, Long version) throws IOException {
    this.id = negozioId;
    this.codice = negozioDTO.getCodice();
    this.nome = negozioDTO.getNome();
    this.ragioneSociale = negozioDTO.getRagioneSociale();
    this.codiceFiscale = negozioDTO.getCodiceFiscale();
    this.regimeFiscale = negozioDTO.getRegimeFiscale();
    this.magazzino = negozioDTO.getMagazzino();
    this.differenzialePartitaIVA = negozioDTO.getDifferenzialePartitaIVA();
    this.nazionePartitaIVA = negozioDTO.getNazionePartitaIVA();
    this.partitaIVA = negozioDTO.getPartitaIVA();
    this.reaUfficio = negozioDTO.getReaUfficio();
    this.reaNumero = negozioDTO.getReaNumero();
    this.reaCapitaleSociale = negozioDTO.getReaCapitaleSociale();
    this.reaSocioUnico = negozioDTO.getReaSocioUnico();
    this.reaLiquidazione = negozioDTO.getReaLiquidazione();
    this.codiceDestinatarioSDI = negozioDTO.getCodiceDestinatarioSDI();
    this.sedeLegaleIndirizzo = negozioDTO.getSedeLegaleIndirizzo();
    this.sedeLegaleNumeroCivico = negozioDTO.getSedeLegaleNumeroCivico();
    this.sedeLegaleCAP = negozioDTO.getSedeLegaleCAP();
    this.sedeLegaleComune = negozioDTO.getSedeLegaleComune();
    this.sedeLegaleProvincia = negozioDTO.getSedeLegaleProvincia();
    this.sedeLegaleNazione = negozioDTO.getSedeLegaleNazione();
    this.sedeOperativaNome = negozioDTO.getSedeOperativaNome();
    this.sedeOperativaIndirizzo = negozioDTO.getSedeOperativaIndirizzo();
    this.sedeOperativaNumeroCivico = negozioDTO.getSedeOperativaNumeroCivico();
    this.sedeOperativaCAP = negozioDTO.getSedeOperativaCAP();
    this.sedeOperativaComune = negozioDTO.getSedeOperativaComune();
    this.sedeOperativaProvincia = negozioDTO.getSedeOperativaProvincia();
    this.sedeOperativaNazione = negozioDTO.getSedeOperativaNazione();
    this.telefono = negozioDTO.getTelefono();
    this.cellulare = negozioDTO.getCellulare();
    this.fax = negozioDTO.getFax();
    this.email = negozioDTO.getEmail();
    this.pec = negozioDTO.getPec();
    this.web = negozioDTO.getWeb();
    this.iban = negozioDTO.getIban();
    this.nazioneTrasmittente = negozioDTO.getNazioneTrasmittente();
    this.partitaIvaTrasmittente = negozioDTO.getPartitaIvaTrasmittente();
    this.canale = negozioDTO.getCanale();
    this.insegna = negozioDTO.getInsegna();
    this.ivaVentilata = negozioDTO.getIvaVentilata();
    this.version = version;
  }

  // public void addArticolo(ArticoloQueryEntity articoloQueryEntity) {
  // this.articoli.add(articoloQueryEntity);
  // articoloQueryEntity.getNegozi().add(this);
  // }

  // public void delArticolo(String articoloId) {
  // ArticoloQueryEntity articoloQueryEntity =
  // this.articoli.stream().filter(a -> a.getId() ==
  // articoloId).findFirst().orElse(null);
  // if (articoloQueryEntity != null) {
  // this.articoli.remove(articoloQueryEntity);
  // articoloQueryEntity.getNegozi().remove(this);
  // }
  // }

  // public void addFornitore(FornitoreQueryEntity fornitoreQueryEntity) {
  // this.fornitori.add(fornitoreQueryEntity);
  // fornitoreQueryEntity.getNegozi().add(this);
  // }

  // public void delFornitore(String fornitoreId) {
  // FornitoreQueryEntity fornitoreQueryEntity =
  // this.fornitori.stream().filter(a -> a.getId() ==
  // fornitoreId).findFirst().orElse(null);
  // if (fornitoreQueryEntity != null) {
  // this.fornitori.remove(fornitoreQueryEntity);
  // fornitoreQueryEntity.getNegozi().remove(this);
  // }
  // }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getDescrizione() {
    return this.descrizione;
  }

  public void setDescrizione(String descrizione) {
    this.descrizione = descrizione;
  }

  public Boolean isIvaVentilata() {
    return this.ivaVentilata;
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

  public GerarchiaQueryEntity getGerarchia() {
    return this.gerarchia;
  }

  public void setGerarchia(GerarchiaQueryEntity gerarchia) {
    this.gerarchia = gerarchia;
  }

  public String getRagioneSociale() {
    return this.ragioneSociale;
  }

  public void setRagioneSociale(String ragioneSociale) {
    this.ragioneSociale = ragioneSociale;
  }

  public String getCodiceFiscale() {
    return this.codiceFiscale;
  }

  public void setCodiceFiscale(String codiceFiscale) {
    this.codiceFiscale = codiceFiscale;
  }

  public String getRegimeFiscale() {
    return this.regimeFiscale;
  }

  public void setRegimeFiscale(String regimeFiscale) {
    this.regimeFiscale = regimeFiscale;
  }

  public String getMagazzino() {
    return magazzino;
  }

  public void setMagazzino(String magazzino) {
    this.magazzino = magazzino;
  }

  public String getDifferenzialePartitaIVA() {
    return differenzialePartitaIVA;
  }

  public void setDifferenzialePartitaIVA(String differenzialePartitaIVA) {
    this.differenzialePartitaIVA = differenzialePartitaIVA;
  }

  public String getNazionePartitaIVA() {
    return nazionePartitaIVA;
  }

  public void setNazionePartitaIVA(String nazionePartitaIVA) {
    this.nazionePartitaIVA = nazionePartitaIVA;
  }

  public String getPartitaIVA() {
    return partitaIVA;
  }

  public void setPartitaIVA(String partitaIVA) {
    this.partitaIVA = partitaIVA;
  }

  public String getReaUfficio() {
    return reaUfficio;
  }

  public void setReaUfficio(String reaUfficio) {
    this.reaUfficio = reaUfficio;
  }

  public String getReaNumero() {
    return reaNumero;
  }

  public void setReaNumero(String reaNumero) {
    this.reaNumero = reaNumero;
  }

  public BigDecimal getReaCapitaleSociale() {
    return reaCapitaleSociale;
  }

  public void setReaCapitaleSociale(BigDecimal reaCapitaleSociale) {
    this.reaCapitaleSociale = reaCapitaleSociale;
  }

  public String getReaSocioUnico() {
    return reaSocioUnico;
  }

  public void setReaSocioUnico(String reaSocioUnico) {
    this.reaSocioUnico = reaSocioUnico;
  }

  public String getReaLiquidazione() {
    return reaLiquidazione;
  }

  public void setReaLiquidazione(String reaLiquidazione) {
    this.reaLiquidazione = reaLiquidazione;
  }

  public String getCodiceDestinatarioSDI() {
    return codiceDestinatarioSDI;
  }

  public void setCodiceDestinatarioSDI(String codiceDestinatarioSDI) {
    this.codiceDestinatarioSDI = codiceDestinatarioSDI;
  }

  public String getSedeLegaleIndirizzo() {
    return sedeLegaleIndirizzo;
  }

  public void setSedeLegaleIndirizzo(String sedeLegaleIndirizzo) {
    this.sedeLegaleIndirizzo = sedeLegaleIndirizzo;
  }

  public String getSedeLegaleNumeroCivico() {
    return sedeLegaleNumeroCivico;
  }

  public void setSedeLegaleNumeroCivico(String sedeLegaleNumeroCivico) {
    this.sedeLegaleNumeroCivico = sedeLegaleNumeroCivico;
  }

  public String getSedeLegaleCAP() {
    return sedeLegaleCAP;
  }

  public void setSedeLegaleCAP(String sedeLegaleCAP) {
    this.sedeLegaleCAP = sedeLegaleCAP;
  }

  public String getSedeLegaleComune() {
    return sedeLegaleComune;
  }

  public void setSedeLegaleComune(String sedeLegaleComune) {
    this.sedeLegaleComune = sedeLegaleComune;
  }

  public String getSedeLegaleProvincia() {
    return sedeLegaleProvincia;
  }

  public void setSedeLegaleProvincia(String sedeLegaleProvincia) {
    this.sedeLegaleProvincia = sedeLegaleProvincia;
  }

  public String getSedeLegaleNazione() {
    return sedeLegaleNazione;
  }

  public void setSedeLegaleNazione(String sedeLegaleNazione) {
    this.sedeLegaleNazione = sedeLegaleNazione;
  }

  public String getSedeOperativaNome() {
    return sedeOperativaNome;
  }

  public void setSedeOperativaNome(String sedeOperativaNome) {
    this.sedeOperativaNome = sedeOperativaNome;
  }

  public String getSedeOperativaIndirizzo() {
    return sedeOperativaIndirizzo;
  }

  public void setSedeOperativaIndirizzo(String sedeOperativaIndirizzo) {
    this.sedeOperativaIndirizzo = sedeOperativaIndirizzo;
  }

  public String getSedeOperativaNumeroCivico() {
    return sedeOperativaNumeroCivico;
  }

  public void setSedeOperativaNumeroCivico(String sedeOperativaNumeroCivico) {
    this.sedeOperativaNumeroCivico = sedeOperativaNumeroCivico;
  }

  public String getSedeOperativaCAP() {
    return sedeOperativaCAP;
  }

  public void setSedeOperativaCAP(String sedeOperativaCAP) {
    this.sedeOperativaCAP = sedeOperativaCAP;
  }

  public String getSedeOperativaComune() {
    return sedeOperativaComune;
  }

  public void setSedeOperativaComune(String sedeOperativaComune) {
    this.sedeOperativaComune = sedeOperativaComune;
  }

  public String getSedeOperativaProvincia() {
    return sedeOperativaProvincia;
  }

  public void setSedeOperativaProvincia(String sedeOperativaProvincia) {
    this.sedeOperativaProvincia = sedeOperativaProvincia;
  }

  public String getSedeOperativaNazione() {
    return sedeOperativaNazione;
  }

  public void setSedeOperativaNazione(String sedeOperativaNazione) {
    this.sedeOperativaNazione = sedeOperativaNazione;
  }

  public String getTelefono() {
    return telefono;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  public String getCellulare() {
    return cellulare;
  }

  public void setCellulare(String cellulare) {
    this.cellulare = cellulare;
  }

  public String getFax() {
    return fax;
  }

  public void setFax(String fax) {
    this.fax = fax;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPec() {
    return pec;
  }

  public void setPec(String pec) {
    this.pec = pec;
  }

  public String getWeb() {
    return web;
  }

  public void setWeb(String web) {
    this.web = web;
  }

  public String getIban() {
    return iban;
  }

  public void setIban(String iban) {
    this.iban = iban;
  }

  public String getNazioneTrasmittente() {
    return nazioneTrasmittente;
  }

  public void setNazioneTrasmittente(String nazioneTrasmittente) {
    this.nazioneTrasmittente = nazioneTrasmittente;
  }

  public String getPartitaIvaTrasmittente() {
    return partitaIvaTrasmittente;
  }

  public void setPartitaIvaTrasmittente(String partitaIvaTrasmittente) {
    this.partitaIvaTrasmittente = partitaIvaTrasmittente;
  }

  public String getCodiceAteco() {
    return codiceAteco;
  }

  public void setCodiceAteco(String codiceAteco) {
    this.codiceAteco = codiceAteco;
  }

  public String getCanale() {
    return canale;
  }

  public void setCanale(String canale) {
    this.canale = canale;
  }

  public String getInsegna() {
    return insegna;
  }

  public void setInsegna(String insegna) {
    this.insegna = insegna;
  }

  public Boolean getIvaVentilata() {
    return ivaVentilata;
  }

  public void setIvaVentilata(Boolean ivaVentilata) {
    this.ivaVentilata = ivaVentilata;
  }

  public Long getVersion() {
    return version;
  }

  public void setVersion(Long version) {
    this.version = version;
  }

}
