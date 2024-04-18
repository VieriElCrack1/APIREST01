package com.apirest.apirest01.controller.backoffice;

import com.apirest.apirest01.model.bd.Persona;
import com.apirest.apirest01.service.Impl.PersonaServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping("/registrar")
    public ResponseEntity<?> registrar(@RequestBody Persona persona) {
        try{
            personaService.guardar(persona);
            return ResponseEntity.ok().body("Se Registró La Persona: " + persona.getNompersona());
        }catch (Exception e) {
            System.out.println("Error en: " + e.getCause().getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error En Registrar");
        }
    }

    @GetMapping("/buscar/{idpersona}")
    public ResponseEntity<?> buscar(@PathVariable Integer idpersona) {
        try{
            Persona p = personaService.buscarPersona(idpersona);
            Map<String, Object> rs = new HashMap<>();
            if(p == null) {
                rs.put("No Se Encontro", p);
            }else{
                rs.put("Se Encontro", p.getNompersona());
            }
            return ResponseEntity.ok().body(rs);
        }catch (Exception e) {
            System.out.println("Error en: " + e.getCause().getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error En Buscar Persona");
        }
    }

    @PutMapping("/actualizar/{idpersona}")
    public ResponseEntity<?> actualizar(@PathVariable Integer idpersona, @RequestBody Persona persona) {
        try{
            Persona p = personaService.buscarPersona(idpersona);
            p.setNompersona(persona.getNompersona());
            p.setApepersona(persona.getApepersona());
            p.setIdpais(persona.getIdpais());
            personaService.guardar(p);
            return ResponseEntity.ok().body("Se Actualizo Exitosamente, La persona : " + persona.getNompersona());
        }catch (Exception e) {
            System.out.println("Error en: " + e.getCause().getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error En Actualizar Persona");
        }
    }

    @DeleteMapping("/eliminar/{idpersona}")
    public ResponseEntity<?> eliminar(@PathVariable Integer idpersona) {
        try{
            String men;
            if(idpersona <= 0) {
                men = "No Se Encontro A La Persona";
            }else {
                personaService.eliminar(idpersona);
                men = "Se Elimino a la Persona";
            }
            return ResponseEntity.ok().body(men);
        }catch (Exception e) {
            System.out.println("Error en: " + e.getCause().getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error En Eliminar Persona");
        }
    }
}
