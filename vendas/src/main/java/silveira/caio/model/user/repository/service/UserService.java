package silveira.caio.model.user.repository.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import silveira.caio.model.user.repository.UserRepository;
import silveira.caio.model.user.repository.entity.User;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<User> list(User entity) {
		return repository.findAll(Example.of(entity,
				ExampleMatcher.matchingAny().withStringMatcher(StringMatcher.CONTAINING).withIgnoreCase()));
	}

	public User findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User doesn`t exist"));
	}

	public void save(User entity) {
		repository.save(entity);
	}
}
