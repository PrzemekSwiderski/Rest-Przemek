package pl.sda.rest1.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.sda.rest1.model.NearestCity;

import java.util.List;
import java.util.Optional;

@Repository
public interface NearestCityRepository extends CrudRepository<NearestCity, Long> {

    List<NearestCity> findAll();

    Optional<NearestCity> getById(Long id);

}
