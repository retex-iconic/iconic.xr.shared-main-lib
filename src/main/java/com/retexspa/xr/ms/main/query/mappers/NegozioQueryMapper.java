package com.retexspa.xr.ms.main.query.mappers;

import com.retexspa.xr.ms.main.core.entities.GerarchiaQueryDTO;
import com.retexspa.xr.ms.main.core.entities.NegozioQueryDTO;
import com.retexspa.xr.ms.main.query.entities.GerarchiaQueryEntity;
import com.retexspa.xr.ms.main.query.entities.NegozioQueryEntity;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface NegozioQueryMapper {

  NegozioQueryMapper INSTANCE = Mappers.getMapper(NegozioQueryMapper.class);

  @Mapping(target = "id", source = "id")
  @Mapping(target = "codice", source = "codice")
  @Mapping(target = "nome", source = "nome")
  @Mapping(target = "ragioneSociale", source = "ragioneSociale")
  @Mapping(target = "codiceFiscale", source = "codiceFiscale")
  @Mapping(target = "regimeFiscale", source = "regimeFiscale")
  @Mapping(target = "magazzino", source = "magazzino")
  @Mapping(target = "differenzialePartitaIVA", source = "differenzialePartitaIVA")
  @Mapping(target = "nazionePartitaIVA", source = "nazionePartitaIVA")
  @Mapping(target = "partitaIVA", source = "partitaIVA")
  @Mapping(target = "reaUfficio", source = "reaUfficio")
  @Mapping(target = "reaNumero", source = "reaNumero")
  @Mapping(target = "reaCapitaleSociale", source = "reaCapitaleSociale")
  @Mapping(target = "reaSocioUnico", source = "reaSocioUnico")
  @Mapping(target = "reaLiquidazione", source = "reaLiquidazione")
  @Mapping(target = "codiceDestinatarioSDI", source = "codiceDestinatarioSDI")
  @Mapping(target = "sedeLegaleIndirizzo", source = "sedeLegaleIndirizzo")
  @Mapping(target = "sedeLegaleNumeroCivico", source = "sedeLegaleNumeroCivico")
  @Mapping(target = "sedeLegaleCAP", source = "sedeLegaleCAP")
  @Mapping(target = "sedeLegaleComune", source = "sedeLegaleComune")
  @Mapping(target = "sedeLegaleProvincia", source = "sedeLegaleProvincia")
  @Mapping(target = "sedeLegaleNazione", source = "sedeLegaleNazione")
  @Mapping(target = "sedeOperativaNome", source = "sedeOperativaNome")
  @Mapping(target = "sedeOperativaIndirizzo", source = "sedeOperativaIndirizzo")
  @Mapping(target = "sedeOperativaNumeroCivico", source = "sedeOperativaNumeroCivico")
  @Mapping(target = "sedeOperativaCAP", source = "sedeOperativaCAP")
  @Mapping(target = "sedeOperativaComune", source = "sedeOperativaComune")
  @Mapping(target = "sedeOperativaProvincia", source = "sedeOperativaProvincia")
  @Mapping(target = "sedeOperativaNazione", source = "sedeOperativaNazione")
  @Mapping(target = "telefono", source = "telefono")
  @Mapping(target = "cellulare", source = "cellulare")
  @Mapping(target = "fax", source = "fax")
  @Mapping(target = "email", source = "email")
  @Mapping(target = "pec", source = "pec")
  @Mapping(target = "web", source = "web")
  @Mapping(target = "iban", source = "iban")
  @Mapping(target = "nazioneTrasmittente", source = "nazioneTrasmittente")
  @Mapping(target = "partitaIvaTrasmittente", source = "partitaIvaTrasmittente")
  @Mapping(target = "codiceAteco", source = "codiceAteco")
  @Mapping(target = "canale", source = "canale")
  @Mapping(target = "insegna", source = "insegna")
  @Mapping(target = "ivaVentilata", source = "ivaVentilata")
  @Mapping(target = "gerarchia", qualifiedByName = "gerarchiaMapper")
  @Mapping(target = "version", source = "version")
  NegozioQueryDTO toDTO(NegozioQueryEntity negozioQueryEntity);

  @Mapping(target = "id", source = "id", ignore = true)
  @Named("gerarchiaMapper")
  GerarchiaQueryDTO gerarchiaMapper(GerarchiaQueryEntity gerarchiaQueryEntity);
}
