package br.dev.joaquim.livroapi.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.dev.joaquim.livroapi.entities.Livro;

@RestController
public class LivroController {

    private List<Livro> livros = new ArrayList<>();

    public LivroController() {
        livros.add(new Livro("1234567", "A volta dos que não foram", 2025, "Desconhecido"));
        livros.add(new Livro("7654321", "A ida dos que não vieram", 2030, "Conhecido"));
    }
    
    @GetMapping("/livros")
    public List<Livro> buscarTodos() {
        return livros;
    }

    @GetMapping("/livros/{isbn}")
    public Livro buscarPorId(@PathVariable("isbn") String isbn) {
        for(Livro l : livros) {
            if(l.getIsbn().equals(isbn)) {
                return l;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/livros")
    public Livro registrarLivro(@RequestBody Livro novoLivro) {
        if(novoLivro.getIsbn() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ISBN não informado");
        }
        for(Livro l : livros) {
            if(l.getIsbn().equals(novoLivro.getIsbn())) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ISBN já registrado");
            }
        }

        livros.add(novoLivro);
        return novoLivro;
    }
}
