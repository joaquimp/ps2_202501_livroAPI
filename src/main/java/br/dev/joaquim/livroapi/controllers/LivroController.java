package br.dev.joaquim.livroapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.dev.joaquim.livroapi.entities.Livro;
import br.dev.joaquim.livroapi.services.LivroService;

@RestController
public class LivroController {

    @Autowired
    private LivroService service;

    // CREATE
    @PostMapping("/livros")
    public Livro registrarLivro(@RequestBody Livro novoLivro) {
        Livro resp = service.criar(novoLivro);
        if (resp != null)
            return resp;
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Problema com os dados informados");
    }

    // READ
    @GetMapping("/livros")
    public List<Livro> buscarTodos() {
        return service.buscarTodos();
    }

    @GetMapping("/livros/{isbn}")
    public Livro buscarPorId(@PathVariable("isbn") String isbn) {
        Livro resp = service.buscarPorId(isbn);
        if (resp != null)
            return resp;

        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    // UPDATE
    @PutMapping("/livros/{isbn}")
    public Livro atualizar(@PathVariable("isbn") String isbn, @RequestBody Livro novoLivro) {
        novoLivro.setIsbn(isbn);
        Livro resp = service.atualizar(novoLivro);
        if (resp != null)
            return resp;
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Problema com os dados informados");
    }

    // DELETE
    @DeleteMapping("/livros/{isbn}")
    public void apagar(@PathVariable("isbn") String isbn) {
        service.apagar(isbn);
    }

}
