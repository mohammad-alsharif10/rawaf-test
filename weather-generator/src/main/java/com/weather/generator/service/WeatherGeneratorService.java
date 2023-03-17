package com.weather.generator.service;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author mohammad Alsharid
 */
@Service
@RequiredArgsConstructor
public class WeatherGeneratorService {

    private final Logger logger= LoggerFactory.getLogger(WeatherGeneratorService.class);
}
