package com.example.cinema.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tbl_filmes")
public class Filmes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    

    @Column(nullable = false, length = 200)
    private String titulo;


    @Column(nullable = false, length = 4)
    private Integer duracao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "diretor_id")
    private Diretor diretor;


    public Filmes(String titulo, Integer duracao, Diretor diretor) {
        this.duracao = duracao;
        this.titulo = titulo;
        this.diretor = diretor; 
    }

    public Filmes() {
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getDuracao() {
        return duracao;
    }

    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }


    @Override
    public String toString() {
        return "Filmes [id=" + id + ", titulo=" + titulo + ", duração=" + duracao + "]";
    }

    public Diretor getDiretor() {
        return diretor;
    }

    public void setDiretor(Diretor diretor) {
        this.diretor = diretor;
    }
    
}
