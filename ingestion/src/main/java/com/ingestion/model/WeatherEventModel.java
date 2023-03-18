package com.ingestion.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author mohammad
 */

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class WeatherEventModel {
    private Long id;
    private String weatherEventUuId;
    private String locationName;
    private Integer longitude;
    private Integer latitude;
    private Integer degree;
    private Date weatherEventTime;
}
