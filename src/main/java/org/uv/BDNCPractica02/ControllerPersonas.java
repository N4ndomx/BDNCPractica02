/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/SpringFramework/RestController.java to edit this template
 */
package org.uv.BDNCPractica02;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

/**
 *
 * @author ASUS
 */
@RestController
@RequestMapping("/personas")
public class ControllerPersonas {
    
    @Autowired()
    private RepositoryPersonas repositoryPersonas;
    
    @GetMapping()
    public List<Persona> list() {
        return repositoryPersonas.findAll();
    }
    
     @GetMapping("/{id}")
    public ResponseEntity<Persona> get(@PathVariable String id) {
        Optional<Persona> persona = repositoryPersonas.findById(id);
        if (persona.isPresent()) {
            return ResponseEntity.ok(persona.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
      @PutMapping("/{id}")
    public ResponseEntity<Persona> put(@PathVariable String id, @RequestBody Persona input) {
        Optional<Persona> existingPersona = repositoryPersonas.findById(id);
        if (existingPersona.isPresent()) {
            Persona updatedPersona = existingPersona.get();
            updatedPersona.setNombre(input.getNombre());
            updatedPersona.setDireccion(input.getDireccion());
            updatedPersona.setTelefono(input.getTelefono());


            repositoryPersonas.save(updatedPersona);
            return ResponseEntity.ok(updatedPersona);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping
    public ResponseEntity<Persona> post(@RequestBody Persona input) {
        Persona nuevaPersona = repositoryPersonas.save(input);
        return ResponseEntity.ok(nuevaPersona);
    }
    
     @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        Optional<Persona> persona = repositoryPersonas.findById(id);
        if (persona.isPresent()) {
            repositoryPersonas.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
}
