package pl.sda.rest1.providers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.sda.rest1.apiresponses.NearestCityResponse;
import pl.sda.rest1.config.AppConfig;
import pl.sda.rest1.apiresponses.CountriesResponse;

@Service
@AllArgsConstructor
public class AirVisualProvider {

    private final AppConfig appConfig;
    private final RestTemplate restTemplate;



    public CountriesResponse fetchCountriesList(){
        String url = String.format("%s/countries?key=%s", appConfig.getBaseUrl(), appConfig.getApiKey());
        ResponseEntity<CountriesResponse> response = restTemplate.getForEntity(url, CountriesResponse.class);
        return response.getBody();
    }

    public NearestCityResponse getNearestCity(){
        String url = String.format("%s/nearest_city?key=%s", appConfig.getBaseUrl(), appConfig.getApiKey());

        ResponseEntity<NearestCityResponse> response = restTemplate.getForEntity(url, NearestCityResponse.class);
        return response.getBody();
    }

}
