package com.example.cinema.Models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Diretor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;
    
    @OneToMany(mappedBy = "diretor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Filmes> filmes;

    public Diretor() {}
    
    public Diretor(String nome) {
        this.nome = nome;
    }
    
    public Long getId() {
        return id;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public List<Filmes> getFilmes() {
        return filmes;
    }
    
    public void setFilmes(List<Filmes> filmes) {
        this.filmes = filmes;
    }
}