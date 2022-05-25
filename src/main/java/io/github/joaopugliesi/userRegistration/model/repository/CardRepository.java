package io.github.joaopugliesi.userRegistration.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.joaopugliesi.userRegistration.model.entity.Card;

public interface CardRepository extends JpaRepository<Card, Integer>{

}
