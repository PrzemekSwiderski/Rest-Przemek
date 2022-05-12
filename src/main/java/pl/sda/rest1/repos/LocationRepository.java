package pl.sda.rest1.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.rest1.model.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

}
