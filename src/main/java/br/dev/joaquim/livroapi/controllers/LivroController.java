package br.dev.joaquim.livroapi.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.dev.joaquim.livroapi.entities.Livro;
import br.dev.joaquim.livroapi.services.LivroService;

@RestController
public class LivroController {

    @Autowired
    private LivroService service;
    
    @GetMapping("/livros")
    public List<Livro> buscarTodos() {
        return service.buscarTodos();
    }

    @GetMapping("/livros/{isbn}")
    public Livro buscarPorId(@PathVariable("isbn") String isbn) {
        Livro resp = service.buscarPorId(isbn);
        if(resp != null) return resp;

        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/livros")
    public Livro registrarLivro(@RequestBody Livro novoLivro) {
        Livro resp = service.registrarLivro(novoLivro);
        if(resp != null) return resp;
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Problema com os dados informados");
    }
}
