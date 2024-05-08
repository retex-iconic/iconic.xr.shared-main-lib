package com.retexspa.xr.ms.main.query.mappers;

import com.retexspa.xr.ms.main.core.entities.GerarchiaQueryDTO;
import com.retexspa.xr.ms.main.query.entities.GerarchiaQueryEntity;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.factory.Mappers;

/*

Create all the target properties in ArticoloDTO and ArticoloQueryEntity

 only fields with block comment as prefix  are required

 */

@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
public interface GerarchiaQueryMapper {

  GerarchiaQueryMapper INSTANCE = Mappers.getMapper(GerarchiaQueryMapper.class);

  @Mapping(target = "id", source = "id")
  @Mapping(target = "nome", source = "nome")
  @Mapping(target = "codice", source = "codice")
  @Mapping(target = "nodoNegozio", source = "nodoNegozio")
  @Mapping(target = "padreId", source = "padre.id")
  @Mapping(target = "negozioId", source = "negozio.id")
  @Mapping(target = "figli", qualifiedByName = "padreMapper")
  @Mapping(target = "version", source = "version")
  GerarchiaQueryDTO toDTO(GerarchiaQueryEntity gerarchiaQueryEntity);

  @Mapping(target = "padreId", source = "padre.id")
  @Mapping(target = "negozioId", source = "negozio.id")
  @Mapping(target = "figli", source = "figli", ignore = false)
  @Named("padreMapper")
  GerarchiaQueryDTO padreMapper(GerarchiaQueryEntity gerarchiaQueryEntity);
}
