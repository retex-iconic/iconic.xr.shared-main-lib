package com.retexspa.xr.ms.main.core.queries;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class BasePagination {

  private Integer page = 0;
  private Integer limit = 50;


  public BasePagination(Integer page, Integer limit) {
    this.page = page;
    this.limit = limit;
  }

  public Integer getPage() {
    return page;
  }

  public Integer getLimit() {
    return limit;
  }
}
