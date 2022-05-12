package pl.sda.rest1.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pl.sda.rest1.model.Country;
import pl.sda.rest1.dto.PageDTO;
import pl.sda.rest1.repos.CountriesRepository;

@Service
@RequiredArgsConstructor
public class CountriesService {

    private final CountriesRepository countriesRepository;

    public PageDTO<Country> fetchAllCountries(int pageNo, int size) {
        PageRequest pageRequest = PageRequest.of(pageNo, size);

        Page<Country> countryPage = countriesRepository.findAll(pageRequest);
        PageDTO<Country> countryPageDTO = new PageDTO<>();
        countryPageDTO.map(countryPage);
        return countryPageDTO;
    }
}
