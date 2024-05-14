package com.retexspa.xr.ms.main.query.services;

import org.springframework.data.domain.Page;

import com.retexspa.xr.ms.main.core.queries.GenericSearchRequest;
import com.retexspa.xr.ms.main.core.queries.GerarchiaListQuery;
import com.retexspa.xr.ms.main.core.responses.GerarchieResponse;
import com.retexspa.xr.ms.main.query.entities.GerarchiaQueryEntity;
import com.retexspa.xr.ms.main.query.filterRequest.GerarchiaFilter;

public interface GerarchiaQueryService  {
    Page<GerarchiaQueryEntity> searchQueryGerarchia(GenericSearchRequest<GerarchiaFilter> query);
    GerarchieResponse searchGerarchia(GenericSearchRequest<GerarchiaFilter> query);
    GerarchieResponse listGerarchia(GerarchiaListQuery query);

}
