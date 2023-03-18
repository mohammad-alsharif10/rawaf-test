package com.ingestion.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ingestion.model.WeatherEventModel;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * @author mohammad
 */
@Service
@RequiredArgsConstructor
public class IngestionService {

    private final Logger logger = LoggerFactory.getLogger(IngestionService.class);
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    @SneakyThrows
    public void sendEventToKafka(WeatherEventModel weatherEventModel) {
        kafkaTemplate.send(weatherEventModel.getLocationName(), objectMapper.writeValueAsString(weatherEventModel))
                .handleAsync((result, throwable) -> {
                    if (throwable != null) {
                        logger.error("error sending to kafka with better error handling to be in placed", throwable);
                    } else {
                        logger.info("sent result {}", result);
                    }
                    return null;
                });
    }
}
