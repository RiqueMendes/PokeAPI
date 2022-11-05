package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
import javax.validation.Valid;
import com.example.demo.model.Pokemon;
import com.example.demo.repository.PokeRepository;

@RestController
@RequestMapping("/pokemon")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PokeController {
    
    @Autowired
    private PokeRepository pokeRepository;


    @Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
		
	}

    @GetMapping("/all")
    public ResponseEntity<List<Pokemon>> getAll(){
        return ResponseEntity.ok(pokeRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pokemon> getById(@PathVariable Long id){
        return pokeRepository.findById(id)
        .map(resp -> ResponseEntity.ok(resp))
        .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping
    public ResponseEntity<Pokemon> post (@Valid @RequestBody Pokemon pokemon){
    return ResponseEntity.status(HttpStatus.CREATED).body(pokeRepository.save(pokemon));
   
    }
    @PostMapping
    public ResponseEntity<Pokemon> pokemon (@Valid @RequestBody Pokemon pokemon){
        return ResponseEntity.status(HttpStatus.CREATED).body(pokeRepository.save(pokemon));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        pokeRepository.deleteById(id);
    }

}

   

