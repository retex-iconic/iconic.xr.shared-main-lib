package com.retexspa.xr.ms.main.query.services;

import com.retexspa.xr.ms.main.core.queries.GenericSearchRequest;
import com.retexspa.xr.ms.main.core.queries.GerarchiaListQuery;
import com.retexspa.xr.ms.main.core.responses.GerarchieResponse;
import com.retexspa.xr.ms.main.core.searchRequest.GerarchiaSearchRequest;
import com.retexspa.xr.ms.main.query.entities.GerarchiaQueryEntity;
import com.retexspa.xr.ms.main.query.filterRequest.GerarchiaFilter;
import org.springframework.data.domain.Page;

public interface GerarchiaQueryService  {
    Page<GerarchiaQueryEntity> searchQueryGerarchia(GenericSearchRequest<GerarchiaFilter> query);
    GerarchieResponse searchGerarchia(GenericSearchRequest<GerarchiaFilter> query);
    GerarchieResponse listGerarchia(GerarchiaListQuery query);

}
