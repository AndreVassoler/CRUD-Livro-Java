package com.example.CRUD_Livros.Controller;

import com.example.CRUD_Livros.DTO.LivroDTO;
import com.example.CRUD_Livros.Enums.Status;
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
    public List<LivroDTO> findAll() {
        return livroService.AllLivros().stream()
                .map(livroService::toDTO)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroDTO> getById(@PathVariable Long id) {
        Optional<Livro> livro = livroService.getById(id);
        return livro.map(value -> ResponseEntity.ok(livroService.toDTO(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public LivroDTO create(@RequestBody LivroDTO livroDTO) {
        Livro livro = livroService.fromDTO(livroDTO);
        return livroService.toDTO(livroService.create(livro));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        livroService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<LivroDTO> update(@PathVariable Long id, @RequestBody LivroDTO livroDTO) {
        Optional<Livro> livroOpt = livroService.getById(id);
        if (livroOpt.isPresent()) {
            Livro livro = livroOpt.get();
            livro.setTitulo(livroDTO.getTitulo());
            livro.setAutor(livroDTO.getAutor());
            Livro atualizado = livroService.create(livro);
            return ResponseEntity.ok(livroService.toDTO(atualizado));
        }
        return ResponseEntity.notFound().build();
    }

}
