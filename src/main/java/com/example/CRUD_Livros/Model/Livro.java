package com.example.CRUD_Livros.Model;

import com.example.CRUD_Livros.Enums.Status;
import jakarta.persistence.*;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String autor;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status; // Adicionado

    public Livro() {
    }

    public Livro(String titulo, String autor, Status status) {
        this.titulo = titulo;
        this.autor = autor;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
