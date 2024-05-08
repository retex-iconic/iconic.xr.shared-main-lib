package com.retexspa.xr.ms.main.query.services;

import com.retexspa.xr.ms.main.core.entities.GerarchiaQueryDTO;
import com.retexspa.xr.ms.main.core.queries.BaseSort;
import com.retexspa.xr.ms.main.core.queries.GerarchiaListQuery;
import com.retexspa.xr.ms.main.core.responses.GerarchieResponse;
import com.retexspa.xr.ms.main.core.responses.Pagination;
import com.retexspa.xr.ms.main.core.searchRequest.GerarchiaSearchRequest;
import com.retexspa.xr.ms.main.query.entities.GerarchiaQueryEntity;
import com.retexspa.xr.ms.main.query.mappers.GerarchiaQueryMapper;
import com.retexspa.xr.ms.main.query.repositories.GerarchiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class GerarchiaQueryServiceImpl implements GerarchiaQueryService {

    @Autowired
    private GerarchiaRepository gerarchiaRepository;

    @Autowired
    private GerarchiaQueryMapper gerarchiaQueryMapper;

    @Override
    public Page<GerarchiaQueryEntity> searchQueryGerarchia(GerarchiaSearchRequest query) {
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

        if (query.getId() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("id"), query.getId()));
        }

        if (query.getCode() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("codice"), query.getCode()));
        }

        if (query.getDescription() != null) {
            specifications.add(
                    (r, q, c) -> c.like(
                            c.upper(r.get("descrizione")), "%" + query.getDescription().toUpperCase() + "%"));
        }

        if (query.getVersion() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("version"), query.getVersion()));
          }

        Specification<GerarchiaQueryEntity> specification = specifications.stream().reduce(Specification::and).orElse(null);

        Page<GerarchiaQueryEntity> page = this.gerarchiaRepository.findAll(specification, pageable);
        return page;
    }

    @Override
    public GerarchieResponse searchGerarchia(GerarchiaSearchRequest query) {

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
