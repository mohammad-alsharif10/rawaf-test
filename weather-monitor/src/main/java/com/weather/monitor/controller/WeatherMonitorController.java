package com.weather.monitor.controller;

import com.weather.monitor.entity.WeatherEvent;
import com.weather.monitor.service.WeatherMonitorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author mohammad
 */
@RestController
@RequestMapping("/weather-monitor")
@RequiredArgsConstructor
public class WeatherMonitorController {

    private final WeatherMonitorService weatherMonitorService;

    @RequestMapping("/findAll")
    public List<WeatherEvent> getAllWeatherEvents() {
       return weatherMonitorService.getAllWeatherEvents();
    }


}
