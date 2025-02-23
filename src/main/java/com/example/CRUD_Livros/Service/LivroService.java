package com.example.CRUD_Livros.Service;


import com.example.CRUD_Livros.Model.Livro;
import com.example.CRUD_Livros.Repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    private final LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public List<Livro> AllLivros() {
        return livroRepository.findAll();
    }

    public Optional<Livro> getById(Long id) {
        return livroRepository.findById(id);
    }

    public Livro create(Livro livro) {
        return livroRepository.save(livro);
    }

    public void delete(Long id) {
        livroRepository.deleteById(id);
    }
}
