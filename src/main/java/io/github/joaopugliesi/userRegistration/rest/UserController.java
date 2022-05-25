package io.github.joaopugliesi.userRegistration.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import io.github.joaopugliesi.userRegistration.model.entity.User;
import io.github.joaopugliesi.userRegistration.model.repository.UserRepository;

@RestController
@RequestMapping("/api/user")
public class UserController {

	private final UserRepository repository;
	
	@Autowired
	public UserController(UserRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping
	public List<User> getAll(){
		return repository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public User save( @RequestBody @Valid User user) {
		return repository.save(user);
	}
	
	@GetMapping("{id}")
	public User findById( @PathVariable Integer id) {
		return repository.findById(id)
							.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado!"));
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete( @PathVariable Integer id) {
		repository.findById(id)
					.map(user -> {
						repository.delete(user);
						return Void.TYPE;
					})
					.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado!"));
	}
	
	@PutMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update( @PathVariable Integer id, @RequestBody @Valid User updateUser) {
		repository.findById(id)
					.map(user -> {
						user.setName(updateUser.getName());
						user.setEmail(updateUser.getEmail());
						user.setPassword(updateUser.getPassword());
						
						return repository.save(user);
					})
					.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário mão encontrado!"));
	}

}
