package silveira.caio.model.city.repository.service.mapper;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import silveira.caio.model.city.repository.CityRepository;
import silveira.caio.model.city.repository.entity.City;

@Service
public class CityService {

	@Autowired
	private CityRepository repository;

	public City findById(Long id) {
		if (Objects.isNull(id))
			return null;
		return repository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "City doesn`t exist"));
	}
}
