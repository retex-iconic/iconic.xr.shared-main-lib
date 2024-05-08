package com.retexspa.xr.ms.main.core.dto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.util.UUID;


@JsonInclude(Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class GenericBaseDTO extends BaseDTO{

   @JsonIgnore
   public String getAggregateId() {
      return UUID.nameUUIDFromBytes(("/Generic/" + this.getCodice()).getBytes()).toString();
   }
}

