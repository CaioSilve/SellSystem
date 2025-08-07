package silveira.caio.model.client.repository.service.mapper;

import java.util.List;

import org.mapstruct.AfterMapping;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import silveira.caio.model.city.repository.service.mapper.CityService;
import silveira.caio.model.client.repository.entity.Client;
import silveira.caio.model.client.repository.entity.dto.ClientDTO;
import silveira.caio.model.client.repository.entity.form.ClientForm;

@Mapper(componentModel = "spring", uses = { CityService.class })
public interface ClientMapper {

	@Mapping(target = "city.id", source = "city.id")
	@Mapping(target = "city.name", source = "city.name")
	ClientDTO toDto(Client entity);

	List<ClientDTO> toListDto(List<Client> entitys);

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "city", source = "idCity")
	Client toEntity(ClientForm form);

	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	void updateValues(Client form, @MappingTarget Client entity);

	@AfterMapping
	default Client afterMapping(@MappingTarget Client client) {
		if (client != null && client.getCity().getId() == null) {
			client.setCity(null);
		}
		return client;
	}
}
