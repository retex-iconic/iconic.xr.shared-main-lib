package com.retexspa.xr.ms.main.core.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.retexspa.xr.ms.main.core.queries.BaseSort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToBaseSortConverter implements Converter<String, BaseSort> {

    private final ObjectMapper objectMapper;

    @Autowired
    public StringToBaseSortConverter(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public BaseSort convert(String source) {
        try {
            return objectMapper.readValue(source, BaseSort.class);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid format for BaseSort: " + source, e);
        }
    }
}