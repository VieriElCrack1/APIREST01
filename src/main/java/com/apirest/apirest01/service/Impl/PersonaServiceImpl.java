package com.apirest.apirest01.service.Impl;

import com.apirest.apirest01.model.bd.Persona;

import java.util.List;

public interface PersonaServiceImpl {
    List<Persona> personas();
    void guardar(Persona persona);
    void eliminar(int id);
    Persona buscarPersona(int id);
}
