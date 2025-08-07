package silveira.caio.model.city.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import silveira.caio.model.city.repository.entity.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

}
