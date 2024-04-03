package com.pietrolessa.library;

import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class AcervoMemorialmpl implements IAcervoRepository {
    private List<Livro> livros;

    public AcervoMemorialmpl() {
        livros = new LinkedList<>();

        livros.add(new Livro(140, "Maze Runner", "James Dashner", 2009));
        livros.add(new Livro(140,"Aprendendo Outra coisa", "Zezinho Pato", 2023));
        livros.add(new Livro(141, "O Guia do Mochileiro das Galáxias", "Douglas Adams", 1979));
        livros.add(new Livro(142, "O Senhor dos Anéis: A Sociedade do Anel", "J.R.R. Tolkien", 1954));
        livros.add(new Livro(143, "Harry Potter e a Pedra Filosofal", "J.K. Rowling", 1997));
        livros.add(new Livro(144, "Harry Potter e a Câmara Secreta", "J.K. Rowling", 1998));
    }

    @Override
    public List<Livro> getAll() {
        return livros;
    }

    @Override
    public boolean cadastraLivroNovo(Livro livro) {
        livros.add(livro);
        return true;
    }

    @Override
    public boolean removeLivro(int codigo) {
        List<Livro> tmp = livros.stream()
                .filter(livro -> livro.getId() == codigo)
                .collect(Collectors.toList());
        return livros.removeAll(tmp);
    }

    @Override
    public List<String> getAutores() {
        return livros.stream()
                .map(livro->livro.getAutor())
                .distinct()
                .toList();
    }

    @Override
    public List<Livro> getLivrosDoAutor(String autor) {
        return null;
    }

    @Override
    public List<String> getTitulos() {
        return livros.stream()
                .map(livro->livro.getTitulo())
                .distinct()
                .toList();
    }

    @Override
    public Livro getLivroTitulo(String titulo) {
        return livros.stream()
                .filter(livro->livro.getTitulo().equals(titulo))
                .findAny()
                .orElse(null);
    }

    
}
