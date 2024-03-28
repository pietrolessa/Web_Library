package com.pietrolessa.library;
public class Livro {
    private int ano;
    private int id;
    private String titulo;
    private String autor;

    public Livro(int id,String titulo, String autor, int ano){
        this.id= id;
        this.titulo=titulo;
        this.autor=autor;
        this.ano=ano;
    }

    public int getAno() {
        return ano;
    }
    public int getId() {
        return id;
    }
    public String getTitulo() {
        return titulo;
    }
    public String getAutor() {
        return autor;
    }

    
}
