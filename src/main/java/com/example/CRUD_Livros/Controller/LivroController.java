package com.example.CRUD_Livros.Controller;

import com.example.CRUD_Livros.Model.Livro;
import com.example.CRUD_Livros.Service.LivroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private final LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @GetMapping
    public List<Livro> findAll() {
        return livroService.AllLivros();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> getById(@PathVariable Long id) {
        Optional<Livro> livro = livroService.getById(id);
        return livro.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Livro create(@RequestBody Livro livro) {
        return livroService.create(livro);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        livroService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
