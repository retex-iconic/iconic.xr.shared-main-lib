package com.retexspa.xr.ms.main.core.searchRequest;

import com.retexspa.xr.ms.main.core.queries.BaseSort;
import com.retexspa.xr.ms.main.core.queries.BaseSortPagination;


import java.math.BigDecimal;
import java.util.List;


public class NegozioSearchRequest extends BaseSortPagination {
    private String id;
    private String nome;
    private String codice;
    private String descrizione;
    private String gerarchiaId;
    private String ragioneSociale;
    private String codiceFiscale;
    private String regimeFiscale;
    private String magazzino;
    private String differenzialePartitaIVA;
    private String nazionePartitaIVA;
    private String partitaIVA;
    private String reaUfficio;
    private String reaNumero;
    private BigDecimal reaCapitaleSociale;
    private String reaSocioUnico;
    private String reaLiquidazione;
    private String codiceDestinatarioSDI;
    private String sedeLegaleIndirizzo;
    private String sedeLegaleNumeroCivico;
    private String sedeLegaleCAP;
    private String sedeLegaleComune;
    private String sedeLegaleProvincia;
    private String sedeLegaleNazione;
    private String sedeOperativaNome;
    private String sedeOperativaIndirizzo;
    private String sedeOperativaNumeroCivico;
    private String sedeOperativaCAP;
    private String sedeOperativaComune;
    private String sedeOperativaProvincia;
    private String sedeOperativaNazione;
    private String telefono;
    private String cellulare;
    private String fax;
    private String email;
    private String pec;
    private String web;
    private String iban;
    private String nazioneTrasmittente;
    private String partitaIvaTrasmittente;
    private String codiceAteco;
    private String canale;
    private String insegna;
    private Long version;

    public NegozioSearchRequest(Integer page, Integer limit, List<BaseSort> sort, String id, String nome, String codice, String descrizione, String gerarchiaId, String ragioneSociale, String codiceFiscale, String regimeFiscale, String magazzino, String differenzialePartitaIVA, String nazionePartitaIVA, String partitaIVA, String reaUfficio, String reaNumero, BigDecimal reaCapitaleSociale, String reaSocioUnico, String reaLiquidazione, String codiceDestinatarioSDI, String sedeLegaleIndirizzo, String sedeLegaleNumeroCivico, String sedeLegaleCAP, String sedeLegaleComune, String sedeLegaleProvincia, String sedeLegaleNazione, String sedeOperativaNome, String sedeOperativaIndirizzo, String sedeOperativaNumeroCivico, String sedeOperativaCAP, String sedeOperativaComune, String sedeOperativaProvincia, String sedeOperativaNazione, String telefono, String cellulare, String fax, String email, String pec, String web, String iban, String nazioneTrasmittente, String partitaIvaTrasmittente, String codiceAteco, String canale, String insegna, Long version) {
       super(page, limit, sort);
        this.id = id;
        this.nome = nome;
        this.codice = codice;
        this.descrizione = descrizione;
        this.gerarchiaId = gerarchiaId;
        this.ragioneSociale = ragioneSociale;
        this.codiceFiscale = codiceFiscale;
        this.regimeFiscale = regimeFiscale;
        this.magazzino = magazzino;
        this.differenzialePartitaIVA = differenzialePartitaIVA;
        this.nazionePartitaIVA = nazionePartitaIVA;
        this.partitaIVA = partitaIVA;
        this.reaUfficio = reaUfficio;
        this.reaNumero = reaNumero;
        this.reaCapitaleSociale = reaCapitaleSociale;
        this.reaSocioUnico = reaSocioUnico;
        this.reaLiquidazione = reaLiquidazione;
        this.codiceDestinatarioSDI = codiceDestinatarioSDI;
        this.sedeLegaleIndirizzo = sedeLegaleIndirizzo;
        this.sedeLegaleNumeroCivico = sedeLegaleNumeroCivico;
        this.sedeLegaleCAP = sedeLegaleCAP;
        this.sedeLegaleComune = sedeLegaleComune;
        this.sedeLegaleProvincia = sedeLegaleProvincia;
        this.sedeLegaleNazione = sedeLegaleNazione;
        this.sedeOperativaNome = sedeOperativaNome;
        this.sedeOperativaIndirizzo = sedeOperativaIndirizzo;
        this.sedeOperativaNumeroCivico = sedeOperativaNumeroCivico;
        this.sedeOperativaCAP = sedeOperativaCAP;
        this.sedeOperativaComune = sedeOperativaComune;
        this.sedeOperativaProvincia = sedeOperativaProvincia;
        this.sedeOperativaNazione = sedeOperativaNazione;
        this.telefono = telefono;
        this.cellulare = cellulare;
        this.fax = fax;
        this.email = email;
        this.pec = pec;
        this.web = web;
        this.iban = iban;
        this.nazioneTrasmittente = nazioneTrasmittente;
        this.partitaIvaTrasmittente = partitaIvaTrasmittente;
        this.codiceAteco = codiceAteco;
        this.canale = canale;
        this.insegna = insegna;
        this.version = version;
    }

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

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getGerarchiaId() {
        return gerarchiaId;
    }

    public void setGerarchiaId(String gerarchiaId) {
        this.gerarchiaId = gerarchiaId;
    }

    public String getRagioneSociale() {
        return ragioneSociale;
    }

    public void setRagioneSociale(String ragioneSociale) {
        this.ragioneSociale = ragioneSociale;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public String getRegimeFiscale() {
        return regimeFiscale;
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

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
