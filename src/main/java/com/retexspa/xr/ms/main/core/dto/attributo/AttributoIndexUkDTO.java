package com.retexspa.xr.ms.main.core.dto.attributo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.retexspa.xr.ms.main.core.dto.AggregateIndexUkBaseDTO;

@JsonInclude(Include.NON_NULL)
public class AttributoIndexUkDTO extends AggregateIndexUkBaseDTO {

  public AttributoIndexUkDTO() {}

  public static String getUk(AttributoBaseDTO attributo) {
    String uk =
        attributo.getChiave()
            + getUkSeparator()
            + attributo.getAggregato();
    return uk;
  }

  public static String getIndexName(){
    return "AttributoIndexUk";
  }

  public static String getIndexAggregateName(){
    return "AttributoIndexUkAggregate";
  }
}
