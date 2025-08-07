package silveira.caio.model.user.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import silveira.caio.model.commons.view.ViewForm;
import silveira.caio.model.commons.view.service.ViewService;
import silveira.caio.model.user.repository.entity.dto.UserDTO;
import silveira.caio.model.user.repository.entity.form.UserForm;
import silveira.caio.model.user.repository.service.UserService;
import silveira.caio.model.user.repository.service.mapper.UserMapper;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4200", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.DELETE })
public class UserResource {

	@Autowired
	private UserService service;
	@Autowired
	UserMapper mapper;
	@Autowired
	private ViewService viewService;
	
	@PostMapping("/list")
	@ResponseStatus(value = HttpStatus.OK)
	public ViewForm<Object> list(@RequestBody UserForm filter) {
		return ViewForm.builder().view(viewService.generateView("view.user"))
				.data(mapper.toListDto(service.list(mapper.toEntity(filter)))).build();
	}

	
	@GetMapping("/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public UserDTO find(@PathVariable(value = "id") Long id) {
		return mapper.toDto(service.findById(id));
	}

	@PostMapping()
	@ResponseStatus(value = HttpStatus.CREATED)
	public void post(@RequestBody @Valid UserForm form) {
		service.save(mapper.toEntity(form));
	}
}
