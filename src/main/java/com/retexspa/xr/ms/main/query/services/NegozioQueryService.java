package com.retexspa.xr.ms.main.query.services;

import com.retexspa.xr.ms.main.core.queries.GenericSearchRequest;
import com.retexspa.xr.ms.main.core.queries.NegozioListQuery;
import com.retexspa.xr.ms.main.core.responses.NegoziResponse;
import com.retexspa.xr.ms.main.core.searchRequest.NegozioSearchRequest;
import com.retexspa.xr.ms.main.query.entities.NegozioQueryEntity;
import com.retexspa.xr.ms.main.query.filterRequest.NegozioFilter;
import org.springframework.data.domain.Page;

public interface NegozioQueryService {

    Page<NegozioQueryEntity> searchQueryNegozio(GenericSearchRequest<NegozioFilter> query);
    NegoziResponse searchNegozio(GenericSearchRequest<NegozioFilter> query);
    NegoziResponse listNegozio(NegozioListQuery query);
}
