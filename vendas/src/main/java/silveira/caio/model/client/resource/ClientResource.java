package silveira.caio.model.client.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import silveira.caio.model.client.repository.entity.dto.ClientDTO;
import silveira.caio.model.client.repository.entity.form.ClientForm;
import silveira.caio.model.client.repository.service.ClientService;
import silveira.caio.model.client.repository.service.mapper.ClientMapper;
import silveira.caio.model.commons.enums.ViewsEnum;
import silveira.caio.model.commons.view.ViewForm;
import silveira.caio.model.commons.view.service.ViewService;

@RestController
@RequestMapping("/clients")
@CrossOrigin(origins = "http://localhost:4200", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.DELETE })
public class ClientResource {

	@Autowired
	private ClientService service;

	@Autowired
	private ViewService viewService;

	@Autowired
	protected ClientMapper mapper;

	@PostMapping("/list")
	@ResponseStatus(value = HttpStatus.OK)
	public ViewForm<Object> list(@RequestBody ClientForm filter) {
		return ViewForm.builder().view(viewService.generateView(ViewsEnum.CLIENT.getValue()))
				.data(mapper.toListDto(service.list(mapper.toEntity(filter)))).build();
	}

	@GetMapping("/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public ClientDTO find(@PathVariable(value = "id") Long id) {
		return mapper.toDto(service.findById(id));
	}

	@PostMapping()
	@ResponseStatus(value = HttpStatus.CREATED)
	public void post(@RequestBody @Valid ClientForm client) {
		service.save(mapper.toEntity(client));
	}

	@PutMapping("/{id}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void update(@PathVariable Long id, @RequestBody @Valid ClientForm client) {
		service.update(id, mapper.toEntity(client));
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}

}
