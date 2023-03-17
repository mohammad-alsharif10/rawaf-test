package com.weather.generator.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author mohammad
 */

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class WeatherEventModel {
    private Long weatherEventId;
    private String locationName;
    private Long longitude;
    private Long latitude;
    private Long degree;
    private Long weatherEventTime;
}
