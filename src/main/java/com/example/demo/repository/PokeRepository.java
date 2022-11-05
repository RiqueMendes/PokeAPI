package com.example.demo.repository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PokeRepository extends JpaRepository<Pokemon, Long> {

    


    //public List<Pokemon>findByPokemon(String pokemon);
    //public List<Pokemon>findallbyPokemonContainingIgnoreCase(String pokemon);
    
}
