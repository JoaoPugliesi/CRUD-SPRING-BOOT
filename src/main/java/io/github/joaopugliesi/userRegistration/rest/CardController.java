package io.github.joaopugliesi.userRegistration.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import io.github.joaopugliesi.userRegistration.model.entity.Card;
import io.github.joaopugliesi.userRegistration.model.repository.CardRepository;


@RestController
@RequestMapping("/api/card")
public class CardController {

	public final CardRepository repository;
	
	@Autowired
	public CardController( CardRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping
	public List<Card> getAll() {
		return repository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Card save( @RequestBody Card card) {
		return repository.save(card);
	}
	
	@DeleteMapping("{id}")
	public void delete( @PathVariable Integer id) {
		repository.findById(id)
					.map(card -> {
						repository.delete(card);
						return Void.TYPE;
					})
					.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cartão não encontrado!"));
	}
}
