package silveira.caio.model.city.repository.service.mapper;

import org.mapstruct.Mapper;

import silveira.caio.model.city.repository.entity.City;
import silveira.caio.model.city.repository.entity.dto.CityDTO;

@Mapper(componentModel = "spring")
public interface CityMapper {

	CityDTO toDto(City entity);
}
