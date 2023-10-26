package silveira.caio.model.client.repository.service.mapper;

import java.util.List;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import silveira.caio.model.client.repository.entity.Client;
import silveira.caio.model.client.repository.entity.dto.ClientDTO;
import silveira.caio.model.client.repository.entity.form.ClientForm;

@Mapper(componentModel="spring")
public interface ClientMapper {

	ClientDTO toDto(Client entity);
	
	List<ClientDTO> toListDto(List<Client> entitys);
	
	@Mapping(target = "id", ignore = true)
	Client toEntity(ClientForm form);
	
	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	void updateValues(Client form, @MappingTarget Client client);
}
