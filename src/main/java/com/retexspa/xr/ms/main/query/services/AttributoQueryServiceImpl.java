package com.retexspa.xr.ms.main.query.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.retexspa.xr.ms.main.core.entities.AttributoQueryDTO;
import com.retexspa.xr.ms.main.core.filterRequest.AttributoFilter;
import com.retexspa.xr.ms.main.core.helpers.NativeQueryHelper;
import com.retexspa.xr.ms.main.core.queries.BaseSort;
import com.retexspa.xr.ms.main.core.queries.GenericSearchRequest;
import com.retexspa.xr.ms.main.core.responses.AttributoResponse;
import com.retexspa.xr.ms.main.core.responses.Pagination;
import com.retexspa.xr.ms.main.query.entities.AttributoQueryEntity;
import com.retexspa.xr.ms.main.query.mappers.AttributoQueryMapper;
import com.retexspa.xr.ms.main.query.repositories.AttributoRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class AttributoQueryServiceImpl implements AttributoQueryService {

  AttributoRepository attributoRepository;

  @Autowired
  AttributoQueryMapper attributoQueryMapper;

  @PersistenceContext
  private EntityManager entityManager;

  AttributoQueryServiceImpl(AttributoRepository attributoRepository) {
    this.attributoRepository = attributoRepository;
  }

  @Override
  public Page<AttributoQueryEntity> searchQueryAttributo(GenericSearchRequest<AttributoFilter> query)
      throws JsonProcessingException {
    List<Sort.Order> sorts = new ArrayList<>();

    if (query.getSort() != null && query.getSort().size() != 0) {
      for (BaseSort baseSort : query.getSort()) {

        switch (baseSort.getOrderBy()) {
          case "id":
            break;

          case "chiave":
            break;

          case "descrizione":
            break;

          case "aggregato":
            break;

          case "checkvalue":
            break;

          case "version":
            break;
          default:
            throw new IllegalArgumentException("Order by is not correct");
        }

        sorts.add(
            new Sort.Order(
                baseSort.getOrderType() != null
                    ? baseSort.getOrderType().equalsIgnoreCase("ASC")
                        ? Sort.Direction.ASC
                        : Sort.Direction.DESC
                    : Sort.Direction.ASC,
                baseSort.getOrderBy() != null ? baseSort.getOrderBy() : "chiave"));
      }
    }

    if (sorts.size() == 0) {
      sorts.add(new Sort.Order(Sort.Direction.ASC, "chiave"));
    }

    Pageable pageable = PageRequest.of(query.getPage() == null ? 0 : query.getPage(),
        query.getLimit() == null ? Integer.MAX_VALUE : query.getLimit(), Sort.by(sorts));

    List<Specification<AttributoQueryEntity>> specifications = new ArrayList<>();

    AttributoFilter filter = AttributoFilter.createFilterFromMap(query.getFilter());

    if (filter.getId() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("id"), filter.getId()));
    }

    if (filter.getChiave() != null) {
      specifications.add(
          (r, q, c) -> c.like(c.upper(r.get("chiave")), "%" + filter.getChiave().toUpperCase() + "%"));
    }

    if (filter.getDescrizione() != null) {
      specifications.add(
          (r, q, c) -> c.like(
              c.upper(r.get("descrizione")), "%" + filter.getDescrizione().toUpperCase() + "%"));
    }

    if (filter.getAggregato() != null) {
      specifications.add(
          (r, q, c) -> c.like(c.upper(r.get("aggregato")), "%" + filter.getAggregato().toUpperCase() + "%"));
    }
    if (filter.getVersion() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("version"), filter.getVersion()));
    }

    NativeQueryHelper NativeQueryHelper = new NativeQueryHelper();

    Specification<AttributoQueryEntity> specification = specifications.stream().reduce(Specification::and).orElse(null);

    Page<AttributoQueryEntity> page = this.attributoRepository.findAll(specification, pageable);
    return page;
  }

  @Override
  public AttributoResponse searchAttributo(GenericSearchRequest<AttributoFilter> query) throws JsonProcessingException {

    AttributoResponse attributoResponse = new AttributoResponse();
    Page<AttributoQueryEntity> page = searchQueryAttributo(query);
    attributoResponse.setPagination(Pagination.buildPagination(page));
    List<AttributoQueryDTO> list = page.getContent().stream()
        .map(entity -> attributoQueryMapper.toDTO(entity))
        .collect(Collectors.toList());
    attributoResponse.setRecords(list);
    return attributoResponse;
  }
}
