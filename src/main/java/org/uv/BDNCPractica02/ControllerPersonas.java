/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/SpringFramework/RestController.java to edit this template
 */
package org.uv.BDNCPractica02;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
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
@RequestMapping("/url")
public class ControllerPersonas {
    
    @Autowired()
    private RepositoryPersonas repositoryPersonas;
    
    @GetMapping()
    public List<Persona> list() {
        return repositoryPersonas.findAll();
    }
    
    @GetMapping("/{id}")
    public Persona get(@PathVariable String id) {
        return null;
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable String id, @RequestBody Persona input) {
        return null;
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody Persona input) {
        return null;
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        return null;
    }
    
}
