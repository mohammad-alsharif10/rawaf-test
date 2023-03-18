package com.weather.monitor.repository;

import com.weather.monitor.entity.WeatherEvent;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author mohammad
 */
public interface WeatherEventRepository extends JpaRepository<WeatherEvent, Long> {
}