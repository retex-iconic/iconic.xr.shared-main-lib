package com.retexspa.xr.ms.main.core.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class AggregateIndexMasterDetailDTO {

  private String aggregateMasterId;
  private String detaiId;
  private String detailName;
  private String event;

  public AggregateIndexMasterDetailDTO() {

  }

 public AggregateIndexMasterDetailDTO(String aggregateMasterId, String detaiId, String event) {
    this.aggregateMasterId = aggregateMasterId;
    this.detaiId = detaiId;
    this.event = event;
  }


  public AggregateIndexMasterDetailDTO(String aggregateMasterId, String detaiId,String detailName, String event) {
    this.aggregateMasterId = aggregateMasterId;
    this.detaiId = detaiId;
    this.detailName = detailName;
    this.event = event;
  }

  public String getAggregateMasterId() {
    return aggregateMasterId;
  }

  public void setAggregateMasterId(String aggregateMasterId) {
    this.aggregateMasterId = aggregateMasterId;
  }

  public String getDetaiId() {
    return detaiId;
  }

  public void setDetaiId(String detaiId) {
    this.detaiId = detaiId;
  }

  public String getEvent() {
    return event;
  }

  public void setEvent(String event) {
    this.event = event;
  }

  public String getDetailName() {
    return detailName;
  }

  public void setDetailName(String detailName) {
    this.detailName = detailName;
  }
}
