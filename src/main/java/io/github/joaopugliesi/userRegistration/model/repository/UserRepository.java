package io.github.joaopugliesi.userRegistration.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.joaopugliesi.userRegistration.model.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
