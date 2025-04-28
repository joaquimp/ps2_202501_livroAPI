package br.dev.joaquim.livroapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.dev.joaquim.livroapi.entities.Livro;

public interface LivroRepository extends JpaRepository<Livro, String> {
    
}