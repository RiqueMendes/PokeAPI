package com.example.demo.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@Table(name = "tb_trainer")
public class Trainer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer age;

    private String city;

    @Email
    private String email;

    private String senha;

    @OneToMany(cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties("trainer")
    private List<Pokemon> pokemon;

    public Trainer(long id, String name, Integer age, String city, String senha) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.city = city;
        this.senha = senha;
    }

    
    public Trainer() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    public List<Pokemon> getPokemon() {
        return pokemon;
    }


    public void setPokemon(List<Pokemon> pokemon) {
        this.pokemon = pokemon;
    }


    public String getSenha() {
        return senha;
    }


    public void setSenha(String senha) {
        this.senha = senha;
    }

    
}
