package silveira.caio.model.user.repository.service.mapper;

import java.util.List;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import silveira.caio.model.user.repository.entity.User;
import silveira.caio.model.user.repository.entity.dto.UserDTO;
import silveira.caio.model.user.repository.entity.form.UserForm;

@Mapper(componentModel="spring")
public interface UserMapper {

	UserDTO toDto(User entity);
	
	List<UserDTO> toListDto(List<User> entitys);
	
	@Mapping(target = "id", ignore = true)
	User toEntity(UserForm form);
	
	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	void updateValues(User form, @MappingTarget User entity);
}
