export default function Home() {
  return (
    <main>
      <h1>Biblioteca</h1>
      <Livros />
    </main>
  );
}

async function Livros() {
  const resp = await fetch("http://localhost:8080/livros");
  const json = await resp.json();

  return (
    <section className="livros">
      {json && json.map((livro) => {
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