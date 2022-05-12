package pl.sda.rest1.init;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import pl.sda.rest1.apiresponses.CountriesResponse;
import pl.sda.rest1.apiresponses.NearestCityResponse;
import pl.sda.rest1.exceptions.ResourceNotFoundException;
import pl.sda.rest1.mappers.NearestCityMapper;
import pl.sda.rest1.model.Country;
import pl.sda.rest1.model.NearestCity;
import pl.sda.rest1.providers.AirVisualProvider;
import pl.sda.rest1.repos.CountriesRepository;
import pl.sda.rest1.repos.LocationRepository;
import pl.sda.rest1.repos.NearestCityRepository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public class DBInitializer implements ApplicationListener<ContextRefreshedEvent> {

    private final AirVisualProvider airVisualProvider;
    private final CountriesRepository countriesRepository;
    private final NearestCityMapper nearestCityMapper;
    private final NearestCityRepository nearestCityRepository;
    private final LocationRepository locationRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.info("Init DB");

        initCountries();
        initNearestCityData();

        log.info("Init DB finished");


    }

    private void initCountries() {
        CountriesResponse countriesResponse = airVisualProvider.fetchCountriesList();
        List<CountriesResponse.CountryNameResponse> list = countriesResponse.getCountryNameResponseList();

        if (list.isEmpty()) {
            throw new ResourceNotFoundException("Api response empty");
        }

        Set<Country> countries = list.stream().map(responseCountry -> new Country(responseCountry.getName())).collect(Collectors.toSet());

        countriesRepository.saveAll(countries);

    }

    private void initNearestCityData() {

        NearestCityResponse nearestCityResponse = airVisualProvider.getNearestCity();
        NearestCity nearestCity = nearestCityMapper.map(nearestCityResponse);

        locationRepository.save(nearestCity.getLocation());

        nearestCityRepository.save(nearestCity);
    }
}
