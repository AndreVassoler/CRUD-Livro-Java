package com.example.CRUD_Livros.Repository;

import com.example.CRUD_Livros.Model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {


}
