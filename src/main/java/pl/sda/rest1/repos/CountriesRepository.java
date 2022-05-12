package pl.sda.rest1.repos;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import pl.sda.rest1.model.Country;

@Repository
public interface CountriesRepository extends PagingAndSortingRepository<Country, String>{

}
