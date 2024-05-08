package com.retexspa.xr.ms.main.query.services;

import com.retexspa.xr.ms.main.core.queries.NegozioListQuery;
import com.retexspa.xr.ms.main.core.responses.NegoziResponse;
import com.retexspa.xr.ms.main.core.searchRequest.NegozioSearchRequest;
import com.retexspa.xr.ms.main.query.entities.NegozioQueryEntity;
import org.springframework.data.domain.Page;

public interface NegozioQueryService {

    Page<NegozioQueryEntity> searchQueryNegozio(NegozioSearchRequest query);
    NegoziResponse searchNegozio(NegozioSearchRequest query);

    NegoziResponse listNegozio(NegozioListQuery query);
}
