package silveira.caio.model.client.repository.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import silveira.caio.model.client.repository.ClientRepository;
import silveira.caio.model.client.repository.entity.Client;
import silveira.caio.model.client.repository.service.mapper.ClientMapper;

@Service
public class ClientService {

	@Autowired
	private ClientMapper mapper;
	
	@Autowired
	private ClientRepository repository;

	public List<Client> list(Client entity) {
		return repository.findAll(Example.of(entity,
				ExampleMatcher.matchingAny().withStringMatcher(StringMatcher.CONTAINING).withIgnoreCase()));
	}

	public Client findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Client doesn`t exist"));
	}

	public Client save(Client client) {
		return repository.save(client);
	}

	public void delete(Long id) {
		if (Objects.nonNull(this.findById(id)))
			repository.deleteById(id);
	}

	public void update(Long id, Client newClient) {
		Client client = this.findById(id);
		mapper.updateValues(newClient, client);
		repository.save(client);
	}

}
