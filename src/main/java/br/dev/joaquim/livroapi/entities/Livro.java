package br.dev.joaquim.livroapi.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Livro {
    private String isbn;
    private String titulo;
    private int ano;
    private String autor;
}
