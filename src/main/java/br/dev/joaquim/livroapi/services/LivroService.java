package br.dev.joaquim.livroapi.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import br.dev.joaquim.livroapi.entities.Livro;

@Service
public class LivroService {
    private List<Livro> livros = new ArrayList<>();

    public LivroService() {
        livros.add(new Livro("1234567", "A volta dos que não foram", 2025, "Desconhecido"));
        livros.add(new Livro("7654321", "A ida dos que não vieram", 2030, "Conhecido"));
    }
    
    
    public List<Livro> buscarTodos() {
        return livros;
    }

    public Livro buscarPorId(String isbn) {
        for(Livro l : livros) {
            if(l.getIsbn().equals(isbn)) {
                return l;
            }
        }
        return null;
    }

    public Livro registrarLivro(Livro novoLivro) {
        if(novoLivro.getIsbn() == null) {
            return null;
        }
        for(Livro l : livros) {
            if(l.getIsbn().equals(novoLivro.getIsbn())) {
                return null;
            }
        }

        livros.add(novoLivro);
        return novoLivro;
    }
}
