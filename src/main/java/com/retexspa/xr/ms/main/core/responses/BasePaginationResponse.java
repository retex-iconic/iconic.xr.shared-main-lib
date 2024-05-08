package com.retexspa.xr.ms.main.core.responses;

import java.util.List;

public class BasePaginationResponse<T> {

  private List<T> records;
  private Pagination pagination;

  public BasePaginationResponse() {}

  public BasePaginationResponse(List<T> records, Pagination pagination) {
    this.records = records;
    this.pagination = pagination;
  }

  public List<T> getRecords() {
    return records;
  }

  public void setRecords(List<T> records) {
    this.records = records;
  }

  public Pagination getPagination() {
    return pagination;
  }

  public void setPagination(Pagination pagination) {
    this.pagination = pagination;
  }
}
