package com.retexspa.xr.ms.main.query.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.retexspa.xr.ms.main.core.filterRequest.AttributoFilter;
import com.retexspa.xr.ms.main.core.queries.GenericSearchRequest;
import com.retexspa.xr.ms.main.core.responses.AttributoResponse;
import com.retexspa.xr.ms.main.query.entities.AttributoQueryEntity;

import org.springframework.data.domain.Page;

public interface AttributoQueryService {

  Page<AttributoQueryEntity> searchQueryAttributo(GenericSearchRequest<AttributoFilter> query) throws JsonProcessingException;

  AttributoResponse searchAttributo(GenericSearchRequest<AttributoFilter> query) throws JsonProcessingException;
}
