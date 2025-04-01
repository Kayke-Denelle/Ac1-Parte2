package com.example.cinema.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cinema.Models.Filmes;

@Repository
public interface  FilmeRepository extends JpaRepository<Filmes, Long> {

    List<Filmes> findByDuracaoGreaterThan(Integer duracao);
    
    List<Filmes> findByDuracaoLessThanEqual(Integer duracao);
    
    List<Filmes> findByTituloStartingWith(String titulo);
    
}
