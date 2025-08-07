package silveira.caio.model.order.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import silveira.caio.model.order.repository.entity.dto.OrderDTO;
import silveira.caio.model.order.repository.entity.form.OrderForm;
import silveira.caio.model.order.repository.service.mapper.OrderMapper;

@RestController
@RequestMapping("/orders")
public class OrderResource {

	@Autowired
	OrderMapper mapper;
	
	@GetMapping
	@ResponseStatus(value = HttpStatus.OK)
	public List<OrderDTO> list(@RequestBody OrderForm filter){
		return null;
	}
}
