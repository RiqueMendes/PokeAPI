package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Trainer;
import com.example.demo.repository.TrainerRepository;

@RestController
@RequestMapping("/trainer")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TrainerController {
    
    public TrainerController(TrainerRepository trainerRepository, PasswordEncoder encoder) {
        this.trainerRepository = trainerRepository;
        this.encoder = encoder;
    }

    
    @Autowired
    private TrainerRepository trainerRepository;
    private final PasswordEncoder encoder; 
    
    @GetMapping("/all")
    public ResponseEntity<List<Trainer>> getAll(){
        return ResponseEntity.ok(trainerRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trainer> getById(@PathVariable Long id){
        return trainerRepository.findById(id)
        .map(resp -> ResponseEntity.ok(resp))
        .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping
    public ResponseEntity<Trainer> post (@Valid @RequestBody Trainer trainer){
    return ResponseEntity.status(HttpStatus.CREATED).body(trainerRepository.save(trainer));
   
    }
    @PostMapping("/register")
    public ResponseEntity<Trainer> trainer (@Valid @RequestBody Trainer trainer){
        trainer.setSenha(encoder.encode(trainer.getSenha()));
        return ResponseEntity.status(HttpStatus.CREATED).body(trainerRepository.save(trainer));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        trainerRepository.deleteById(id);
    }
 

    
    
}
