package com.weather.monitor.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.weather.monitor.entity.WeatherEvent;
import com.weather.monitor.repository.WeatherEventRepository;
import com.weather.monitor.util.Constants;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author mohammad
 */
@Service
@RequiredArgsConstructor
public class WeatherMonitorService {

    private final Logger logger = LoggerFactory.getLogger(WeatherMonitorService.class);
    private final ObjectMapper objectMapper;

    private final WeatherEventRepository weatherEventRepository;


    @KafkaListener(topicPattern = "\\bcity.*\\b", id = Constants.NO_GROUP)
    public void consumeWeatherData(String weatherDataEvent, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) throws JsonProcessingException {
        logger.info("consumed data from kafka {} from topic {}", weatherDataEvent, topic);
        WeatherEvent weatherEvent = objectMapper.readValue(weatherDataEvent, WeatherEvent.class);
        weatherEventRepository.save(weatherEvent);
    }

    public List<WeatherEvent> getAllWeatherEvents() {
        return weatherEventRepository.findAll();
    }
}
