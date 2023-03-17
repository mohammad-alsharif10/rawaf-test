package com.weather.generator.service;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import rx.Observable;
import rx.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

/**
 * @author mohammad Alsharid
 */
@Service
@RequiredArgsConstructor
public class WeatherGeneratorService {

    private final Logger logger = LoggerFactory.getLogger(WeatherGeneratorService.class);

    public void generateWeatherData() {
        Observable.interval(10, TimeUnit.SECONDS, Schedulers.io())
                .observeOn(Schedulers.io())
                .map(event -> {

                    return "";
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
