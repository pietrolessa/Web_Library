package com.pietrolessa.library;

import java.util.List;

public class IAcervoRepository {
    public interface lAcervoRepository {
        List<Livro> getAlI();
        List<String> getTitulos();
        List<String> getAutores();
        List<Livro> getLivrosDoAutor(String autor);
        Livro getLivroTitulo(String titulo);
        boolean cadastraLivroNovo(Livro livro);
        boolean removeLivro(int codigo);
    }
}
