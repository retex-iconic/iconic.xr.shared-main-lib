package com.retexspa.xr.ms.main.query.services;

import com.retexspa.xr.ms.main.core.queries.GerarchiaListQuery;
import com.retexspa.xr.ms.main.core.responses.GerarchieResponse;
import com.retexspa.xr.ms.main.core.searchRequest.GerarchiaSearchRequest;
import com.retexspa.xr.ms.main.query.entities.GerarchiaQueryEntity;
import org.springframework.data.domain.Page;

public interface GerarchiaQueryService  {
    Page<GerarchiaQueryEntity> searchQueryGerarchia(GerarchiaSearchRequest query);
    GerarchieResponse searchGerarchia(GerarchiaSearchRequest query);
    GerarchieResponse listGerarchia(GerarchiaListQuery query);

}
