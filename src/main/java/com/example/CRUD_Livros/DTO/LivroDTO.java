package com.example.CRUD_Livros.DTO;

import com.example.CRUD_Livros.Enums.Status;

public class LivroDTO {
    private Long id;
    private String titulo;
    private String autor;
    private Status status;

    public LivroDTO() {
    }

    public LivroDTO(Long id, String titulo, String autor, Status status) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.status = status;
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
