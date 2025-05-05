package br.dev.joaquim.livroapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.dev.joaquim.livroapi.entities.Livro;
import br.dev.joaquim.livroapi.repository.LivroRepository;

@Service
public class LivroService {
    @Autowired
    private LivroRepository repository;

    // CREATE
    public Livro criar(Livro novoLivro) {
        if (buscarPorId(novoLivro.getIsbn()) != null)
            return null;
        try {
            return repository.save(novoLivro);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    // READ
    public List<Livro> buscarTodos() {
        return repository.findAll();
    }

    public Livro buscarPorId(String isbn) {
        Optional<Livro> resp = repository.findById(isbn);
        if (resp.isPresent())
            return resp.get();
        return null;
    }

    // UPDATE
    public Livro atualizar(Livro novoLivro) {
        if (buscarPorId(novoLivro.getIsbn()) == null)
            return null;
        try {
            return repository.save(novoLivro);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    // DELETE
    public void apagar(String isbn) {
        repository.deleteById(isbn);
    }
}
