package silveira.caio.model.order.repository.service.mapper;

import java.util.List;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import silveira.caio.model.order.repository.entity.Order;
import silveira.caio.model.order.repository.entity.dto.OrderDTO;

@Mapper(componentModel="spring")
public interface OrderMapper {

	
	@Mapping(source="client.name", target = "clientName")
	OrderDTO toDto(Order entity);
	
	List<OrderDTO> toListDto(List<Order> entitys);
	
	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	void updateValues(Order form, @MappingTarget Order client);
}
