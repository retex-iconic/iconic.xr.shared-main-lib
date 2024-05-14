package com.retexspa.xr.ms.main.query.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.retexspa.xr.ms.main.core.entities.GerarchiaQueryDTO;
import com.retexspa.xr.ms.main.core.queries.BaseSort;
import com.retexspa.xr.ms.main.core.queries.GenericSearchRequest;
import com.retexspa.xr.ms.main.core.queries.GerarchiaListQuery;
import com.retexspa.xr.ms.main.core.responses.GerarchieResponse;
import com.retexspa.xr.ms.main.core.responses.Pagination;
import com.retexspa.xr.ms.main.query.entities.GerarchiaQueryEntity;
import com.retexspa.xr.ms.main.query.filterRequest.GerarchiaFilter;
import com.retexspa.xr.ms.main.query.mappers.GerarchiaQueryMapper;
import com.retexspa.xr.ms.main.query.repositories.GerarchiaRepository;
@Service
public class GerarchiaQueryServiceImpl implements GerarchiaQueryService {

    @Autowired
    private GerarchiaRepository gerarchiaRepository;

    @Autowired
    private GerarchiaQueryMapper gerarchiaQueryMapper;

    @Override
    public Page<GerarchiaQueryEntity> searchQueryGerarchia(GenericSearchRequest<GerarchiaFilter> query) {
        try {
            GerarchiaFilter filter = GerarchiaFilter.createFilterFromMap(query.getFilter());


        List<Sort.Order> sorts = new ArrayList<>();

        if (query.getSort() != null && query.getSort().size() != 0) {
            for (BaseSort baseSort : query.getSort()) {

                Sort.Order sort = new Sort.Order(
                        (baseSort.getOrderType() != null ?
                                (baseSort.getOrderType().equalsIgnoreCase("ASC") ? Sort.Direction.ASC : Sort.Direction.DESC) :
                                Sort.Direction.ASC),
                        (baseSort.getOrderBy() != null ? baseSort.getOrderBy() : "codice")
                );

                sorts.add(sort);
            }
        }
        if (sorts.size() == 0) {
            sorts.add(new Sort.Order(Sort.Direction.ASC, "codice"));
        }

        Pageable pageable = PageRequest.of(query.getPage(), query.getLimit(), Sort.by(sorts));

        List<Specification<GerarchiaQueryEntity>> specifications = new ArrayList<>();

        if (filter.getId() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("id"), filter.getId()));
        }

        if (filter.getCode() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("codice"), filter.getCode()));
        }

        /*if (filter.getDescription() != null) {
            specifications.add(
                    (r, q, c) -> c.like(
                            c.upper(r.get("descrizione")), "%" + filter.getDescription().toUpperCase() + "%"));
        }*/

        if (filter.getVersion() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("version"), filter.getVersion()));
          }

        Specification<GerarchiaQueryEntity> specification = specifications.stream().reduce(Specification::and).orElse(null);

        Page<GerarchiaQueryEntity> page = this.gerarchiaRepository.findAll(specification, pageable);
        return page;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public GerarchieResponse searchGerarchia(GenericSearchRequest<GerarchiaFilter> query) {

        GerarchieResponse GerarchieResponse = new GerarchieResponse();
        Page<GerarchiaQueryEntity> page = searchQueryGerarchia(query);
        List<GerarchiaQueryDTO> list = page.getContent().stream()
                // .map(entity -> modelMapper.map(entity, GerarchiaQueryDTO.class))
                .map(entity -> gerarchiaQueryMapper.toDTO(entity))
                .collect(Collectors.toList());
        GerarchieResponse.setRecords(list);

        GerarchieResponse.setPagination(Pagination.buildPagination(page));

        return GerarchieResponse;
    }

    @Override
    public GerarchieResponse listGerarchia(GerarchiaListQuery query) {
      GerarchieResponse gerarchieResponse = new GerarchieResponse();
      Page<GerarchiaQueryEntity> page = this.gerarchiaRepository
          .findAll(PageRequest.of(query.getPage(), query.getLimit()));
      List<GerarchiaQueryDTO> list = page.getContent().stream()
          // .map(entity -> modelMapper.map(entity, GerarchiaQueryDTO.class))
          .map(entity -> gerarchiaQueryMapper.toDTO(entity))
          .collect(Collectors.toList());
      gerarchieResponse.setRecords(list);
      gerarchieResponse.setPagination(Pagination.buildPagination(page));
      return gerarchieResponse;
    }
  
   
}
