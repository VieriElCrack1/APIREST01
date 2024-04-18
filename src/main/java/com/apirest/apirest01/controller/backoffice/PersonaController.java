package com.apirest.apirest01.controller.backoffice;

import com.apirest.apirest01.model.bd.Persona;
import com.apirest.apirest01.service.Impl.PersonaServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@RestController
@RequestMapping("/")
public class PersonaController {
    private PersonaServiceImpl personaService;

    @GetMapping("/listado")
    public ResponseEntity<?> listado() {
        try{
            List<Persona> lista = personaService.personas();
            Map<String, List<Persona>> rs = new HashMap<>();
            if(lista.isEmpty()){
                rs.put("No hay listado", lista);
            }else {
                rs.put("", lista);
            }
            return ResponseEntity.ok().body(rs);
        } catch (Exception e) {
            System.out.println("Error en: " + e.getCause().getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error En Listar");
        }
    }
}
