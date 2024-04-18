package com.apirest.apirest01.repository;

import com.apirest.apirest01.model.bd.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer> {
}
