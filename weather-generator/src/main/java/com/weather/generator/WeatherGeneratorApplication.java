package com.weather.generator;

import com.weather.generator.service.WeatherGeneratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author mohammad Alsharif
 */
@SpringBootApplication
@RequiredArgsConstructor
public class WeatherGeneratorApplication {

    private final WeatherGeneratorService weatherGeneratorService;

    public static void main(String[] args) {
        SpringApplication.run(WeatherGeneratorApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> weatherGeneratorService.generateWeatherData();
    }


}
