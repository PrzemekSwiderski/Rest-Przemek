package pl.sda.rest1.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.rest1.model.Country;
import pl.sda.rest1.dto.PageDTO;
import pl.sda.rest1.services.CountriesService;

@RestController
@RequestMapping("api/countries")
@RequiredArgsConstructor
public class CountriesController {

    private final CountriesService countriesService;

    @GetMapping
    public PageDTO<Country> getAllCountries(@RequestParam(required = false, defaultValue = "0") int pageNo,
                                            @RequestParam(required = false, defaultValue = "10") int size){
        return countriesService.fetchAllCountries(pageNo, size);
    }

}
