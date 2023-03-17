package com.weather.generator.util;

import com.weather.generator.model.CityModel;

import java.util.List;

/**
 * @author mohammad
 */
public class Constants {

    private Constants() {
    }

    public static final List<CityModel> CITY_MODELS = List.of(
            CityModel.builder().locationName("city1").longitude(1).latitude(11).build(),
            CityModel.builder().locationName("city2").longitude(2).latitude(12).build(),
            CityModel.builder().locationName("city3").longitude(3).latitude(13).build(),
            CityModel.builder().locationName("city4").longitude(4).latitude(14).build(),
            CityModel.builder().locationName("city5").longitude(5).latitude(15).build(),
            CityModel.builder().locationName("city6").longitude(6).latitude(16).build(),
            CityModel.builder().locationName("city7").longitude(7).latitude(17).build(),
            CityModel.builder().locationName("city8").longitude(8).latitude(18).build(),
            CityModel.builder().locationName("city9").longitude(9).latitude(19).build(),
            CityModel.builder().locationName("city10").longitude(10).latitude(20).build());
}
