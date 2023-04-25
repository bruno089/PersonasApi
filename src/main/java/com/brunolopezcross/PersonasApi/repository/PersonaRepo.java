package com.brunolopezcross.PersonasApi.repository;

import com.brunolopezcross.PersonasApi.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepo extends JpaRepository<Persona, Integer> {

}
