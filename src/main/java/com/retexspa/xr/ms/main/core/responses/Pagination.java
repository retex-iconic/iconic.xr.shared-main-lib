package com.retexspa.xr.ms.main.core.responses;

import org.springframework.data.domain.Page;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Pagination {

  private final Long count;
  private final Integer total;
  private final Integer current;
  private final Integer previous;
  private final Integer next;
  private final Integer limit;

  public Pagination(
      @JsonProperty("count") Long count,
      @JsonProperty("total") Integer total,
      @JsonProperty("current") Integer current,
      @JsonProperty("previous") Integer previous,
      @JsonProperty("next") Integer next,
      @JsonProperty("limit") Integer limit) {
    this.count = count;
    this.total = total;
    this.current = current;
    this.previous = previous;
    this.next = next;
    this.limit = limit;
  }

  public static Pagination buildPaginationManual(Long count, int limit, int page) {
    Integer total = 0; 
    if(limit != 0){
     total = (int) (count / limit);
     if (count % limit != 0) {
       total++;
     }
    }
    Integer current = page;
    Integer previous = page > 0 ? (page - 1) : null;
    Integer next = (page + 1) * limit < count ? (page + 1) : null;
    return new Pagination(count, total, current, previous, next, limit);
  }

  public static Pagination buildPagination(Page<?> page) {

    Long count = page.getTotalElements();
    Integer total = page.getTotalPages();
    Integer current = page.getNumber();
    Integer previous = page.hasPrevious() ? page.previousPageable().getPageNumber() : null;
    Integer next = page.hasNext() ? page.nextPageable().getPageNumber() : null;
    Integer limit = page.getSize();

    return new Pagination(count, total, current, previous, next, limit);
  }

  public Long getCount() {
    return count;
  }

  public Integer getTotal() {
    return total;
  }

  public Integer getCurrent() {
    return current;
  }

  public Integer getPrevious() {
    return previous;
  }

  public Integer getNext() {
    return next;
  }

  public Integer getLimit() {
    return limit;
  }
}
