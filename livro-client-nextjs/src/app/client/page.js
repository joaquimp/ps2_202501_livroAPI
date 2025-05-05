"use client"

import { useEffect, useState } from "react";

export default function Home() {
  return (
    <main>
      <h1>Biblioteca Client Side</h1>
      <Livros />
    </main>
  );
}

function Livros() {
  const [livros, setLivros] = useState([]);

  useEffect(() => {
    const getData = async () => {
      const resp = await fetch("http://localhost:8080/livros");
      const json = await resp.json();
      setLivros(json);
    };
    getData();
  }, []);

  return (
    <section className="livros">
      {livros && livros.map((livro) => {
        return (
          <article className="livro" key={livro.isbn}>
            <header>{livro.titulo}</header>
            <p>Autor: {livro.autor}</p>
            <p>Ano: {livro.ano}</p>
            <p>ISBN: {livro.isbn}</p>
          </article>
        )
      })}
    </section>
  )
}