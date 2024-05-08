package com.retexspa.xr.ms.main.core.helpers;

import org.axonframework.eventhandling.GenericDomainEventMessage;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component
public class EventDataConverterHelper {
    public Map<String, Object> extractEventData(GenericDomainEventMessage eventMessage) {
        Map<String, Object> eventData = new HashMap<>();
        eventData.put("identifier", eventMessage.getIdentifier());
        eventData.put("version", eventMessage.getSequenceNumber());
        eventData.put("timestamp", eventMessage.getTimestamp().toString());
        eventData.put("payload", eventMessage.getPayload());
        eventData.put("type", eventMessage.getType());
        eventData.put("metaData", eventMessage.getMetaData());
        eventData.put("aggregateIdentifier", eventMessage.getAggregateIdentifier().toString());
        eventData.put("sequenceNumber", eventMessage.getSequenceNumber());
        eventData.put("payloadType", eventMessage.getPayloadType().getName());
        return eventData;
    }
}
