package com.weather.monitor.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;

/**
 * @author mohammad
 */

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class WeatherEvent {
    @Id
    private Long id;
    private String weatherEventUuId;
    private String locationName;
    private Integer longitude;
    private Integer latitude;
    private Integer degree;
    private Date weatherEventTime;
}
