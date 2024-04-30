/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/SpringFramework/Repository.java to edit this template
 */
package org.uv.BDNCPractica02;

import org.springframework.data.mongodb.repository.MongoRepository;


/**
 *
 * @author ASUS
 */
public interface RepositoryPersonas extends MongoRepository<Persona, String> {
    
}
