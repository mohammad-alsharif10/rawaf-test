package com.weather.generator.service;

import com.weather.generator.model.WeatherEventModel;
import com.weather.generator.util.Constants;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import rx.Observable;
import rx.schedulers.Schedulers;

import java.time.Instant;
import java.util.Date;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author mohammad
 */
@Service
@RequiredArgsConstructor
public class WeatherGeneratorService {

    private final Logger logger = LoggerFactory.getLogger(WeatherGeneratorService.class);
    private final Random random = new Random();
    private final RestTemplate restTemplate;

    @Value("${local.host.value}")
    private String localHostValue;

    public void generateWeatherData() {
        Observable.interval(10, TimeUnit.SECONDS, Schedulers.io())
                .observeOn(Schedulers.io())
                .map(event -> {
                    Constants.CITY_MODELS.forEach(cityModel -> {
                        WeatherEventModel weatherEventModel = WeatherEventModel.builder()
                                .weatherEventUuId(UUID.randomUUID().toString())
                                .weatherEventTime(Date.from(Instant.now()))
                                .degree(random.nextInt(50 - (-50)) + (-50))
                                .latitude(cityModel.getLatitude()).longitude(cityModel.getLongitude())
                                .locationName(cityModel.getLocationName())
                                .build();
                        HttpEntity<WeatherEventModel> weatherEventModelHttpEntity = new HttpEntity<>(weatherEventModel);
                        ResponseEntity<String> exchange = restTemplate.exchange("http://"+localHostValue + ":8081/ingestion/ingestWeatherEvent", HttpMethod.POST, weatherEventModelHttpEntity, String.class);
                        logger.info(String.format("event fired ->{ %s } with response -> { %s }", weatherEventModel, exchange.getBody()));
                    });
                    return "DONE";
                })
                .doOnError(this::handleCommunicationFailure)
                .retry()
                .subscribe(response -> logger.info("weather data sent successfully"));
    }

    private void handleCommunicationFailure(Throwable throwable) {
        logger.error("error connecting to the ingestion service", throwable);
    }

    public void internalSystemLogin() {
        // TODO document why this method is empty
    }
}
