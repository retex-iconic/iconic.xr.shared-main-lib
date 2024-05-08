package com.retexspa.xr.ms.main.core.queries;

import lombok.NoArgsConstructor;

import java.util.List;



@NoArgsConstructor
public class BaseSortPagination extends BasePagination {

  private List<BaseSort> sort;

  public BaseSortPagination(Integer page, Integer limit, List<BaseSort> sort) {
    super(page, limit);
    this.sort = sort;
  }

  public List<BaseSort> getSort() {
    return sort;
  }

  public void setSort(List<BaseSort> sort) {
    this.sort = sort;
  }
}
