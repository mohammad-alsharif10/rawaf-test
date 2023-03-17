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
public class CityModel {

    private String locationName;
    private Integer longitude;
    private Integer latitude;
}
