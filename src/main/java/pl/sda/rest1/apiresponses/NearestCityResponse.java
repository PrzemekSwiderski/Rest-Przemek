package pl.sda.rest1.apiresponses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class NearestCityResponse {

    @JsonProperty("data")
    private NearestCityData nearestCityData;

    @Data
    public static class NearestCityData {

        private String city;
        private String state;
        private String country;
        private LocationResponse location;

        @Data
        public static class LocationResponse {

            private List<Double> coordinates;
        }
    }
}


/*
* {
  "status": "success",
  "data": {
    "city": "Port Harcourt",
    "state": "Rivers",
    "country": "Nigeria",
    "location": {
      "type": "Point",
      "coordinates": [
        7.048623,
        4.854166
      ]
    },
*
*
* */