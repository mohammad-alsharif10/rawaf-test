package com.ingestion.controller;

import com.ingestion.model.WeatherEventModel;
import com.ingestion.service.IngestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mohammad
 */
@RestController
@RequestMapping("/ingestion")
@RequiredArgsConstructor
public class IngestionController {

    private final IngestionService ingestionService;
    @PostMapping("/ingestWeatherEvent")
    public String ingestWeatherEvent(@RequestBody WeatherEventModel weatherEventModel) {
        ingestionService.sendEventToKafka(weatherEventModel);
        return "DONE";
    }
}
