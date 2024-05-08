package com.retexspa.xr.ms.main.core.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@JsonInclude(Include.NON_NULL)
public class AggregateIndexUkBaseDTO {

  private List<String> ids;
  // concatenation of the fields that are part of the unique key separated by
  // "/#/"
  private List<String> uks;


  public AggregateIndexUkBaseDTO() {
     this.ids = new ArrayList<String>();
     this.uks = new ArrayList<String>();
  }

  public void initList() {
    this.ids = new ArrayList<String>();
    this.uks = new ArrayList<String>();
  }

  public static String getUkSeparator() {
    return "/#/";
  }

  public static String getAggregateId(String aggregate) {
    return UUID.nameUUIDFromBytes(("/" + aggregate ).getBytes()).toString();
  }

  public List<String> getIds() {
    return this.ids;
  }

  public void setIds(List<String> ids) {
    this.ids = ids;
  }

  public List<String> getUks() {
    return uks;
  }

  public void setUks(List<String> codes) {
    this.uks = codes;
  }

}
