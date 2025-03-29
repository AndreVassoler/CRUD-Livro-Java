package com.example.CRUD_Livros.Service;

import com.example.CRUD_Livros.Enums.Status;
import com.example.CRUD_Livros.Model.Livro;
import com.example.CRUD_Livros.Repository.LivroRepository;
import org.springframework.stereotype.Service;
import com.example.CRUD_Livros.DTO.LivroDTO;

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
        if (livro.getStatus() == null) {
            livro.setStatus(Status.PENDENTE);
        }
        return livroRepository.save(livro);
    }

    public void delete(Long id) {
        livroRepository.deleteById(id);
    }

    public LivroDTO toDTO(Livro livro) {
        return new LivroDTO(livro.getId(), livro.getTitulo(), livro.getAutor(), livro.getStatus());
    }

    public Livro fromDTO(LivroDTO dto) {
        return new Livro(dto.getTitulo(), dto.getAutor(), dto.getStatus());
    }

    public List<LivroDTO> toDTOList(List<Livro> livros) {
        return livros.stream().map(this::toDTO).toList();
    }

    public Optional<LivroDTO> toDTO(Long id) {
        return livroRepository.findById(id)
                .map(this::toDTO);
    }

    public Livro updateLivroFromDTO(LivroDTO dto, Long id) {
        Optional<Livro> livroOpt = livroRepository.findById(id);
        if (livroOpt.isPresent()) {
            Livro livro = livroOpt.get();
            livro.setTitulo(dto.getTitulo());
            livro.setAutor(dto.getAutor());
            livro.setStatus(dto.getStatus());
            return livroRepository.save(livro);
        }
        return null;
    }

    public void updateStatus(Long id, Status status) {
        Optional<Livro> livroOpt = livroRepository.findById(id);
        if (livroOpt.isPresent()) {
            Livro livro = livroOpt.get();
            livro.setStatus(status);
            livroRepository.save(livro);
        }
    }
}
