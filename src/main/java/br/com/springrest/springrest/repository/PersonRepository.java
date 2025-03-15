package br.com.springrest.springrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.springrest.springrest.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {}