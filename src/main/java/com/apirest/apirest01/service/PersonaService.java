package com.apirest.apirest01.service;

import com.apirest.apirest01.model.bd.Persona;
import com.apirest.apirest01.repository.PersonaRepository;
import com.apirest.apirest01.service.Impl.PersonaServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class PersonaService implements PersonaServiceImpl{

    private PersonaRepository personaRepository;

    @Override
    public List<Persona> personas() {
        return personaRepository.findAll();
    }

    @Override
    public void guardar(Persona persona) {
        personaRepository.save(persona);
    }

    @Override
    public void eliminar(int id) {
        personaRepository.deleteById(id);
    }

    @Override
    public Persona buscarPersona(int id) {
        return personaRepository.findById(id).orElse(null);
    }
}
