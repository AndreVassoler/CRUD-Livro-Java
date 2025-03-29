package com.example.CRUD_Livros.Repository;

import com.example.CRUD_Livros.Enums.Status;
import com.example.CRUD_Livros.Model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Long> {

    List<Livro> findByStatus(Status status);

}
