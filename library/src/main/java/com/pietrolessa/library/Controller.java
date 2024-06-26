package com.pietrolessa.library;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController //indica pro spring boot que isso eh uma classe controller
@RequestMapping("/biblioteca")  //a partir daqui fica http://localhostot:8080/biblioteca/livros ao inves de ter que escrever /biblioteca/livros em cada @GetMapping
public class Controller {
    private List<Livro> livros;

    public Controller(){
        this.livros = new ArrayList<>();
        livros.add(new Livro(140, "Maze Runner", "James Dashner", 2009));
        livros.add(new Livro(140,"Aprendendo Outra coisa", "Zezinho Pato", 2023));
        livros.add(new Livro(141, "O Guia do Mochileiro das Galáxias", "Douglas Adams", 1979));
        livros.add(new Livro(142, "O Senhor dos Anéis: A Sociedade do Anel", "J.R.R. Tolkien", 1954));
        livros.add(new Livro(143, "Harry Potter e a Pedra Filosofal", "J.K. Rowling", 1997));
        livros.add(new Livro(144, "Harry Potter e a Câmara Secreta", "J.K. Rowling", 1998));

    }
    @GetMapping("") //o tipo de requisicao eh um get
    
    @CrossOrigin(origins = "*") //porta esta aberta 
    public String mensagemDeBemVindo(){
        return "Sim, isso é um site "; 
    }
    //Devolver a lista de livros:
    @GetMapping("/livros") 
    @CrossOrigin(origins = "*")
    public List<Livro> getLivros(){
        return livros;
    }
    //Devolver a lista de autores:
    @GetMapping("/autores")
    @CrossOrigin(origins = "*")
    public Set<String> getAutor(){
        return livros.stream()
            .map(livro->livro.getAutor())
            .collect(Collectors.toSet());
    }

    //Devolver a lista de títulos:
    @GetMapping("/titulos")
    @CrossOrigin(origins = "*")
    public Set<String> getTitulo(){
        return livros.stream()
            .map(livro->livro.getTitulo())
            .collect(Collectors.toSet());
    }

    //Devolver a lista dos livros publicados no ano indicado usando uma query string: /biblioteca/livrosPorAno&ano=<valor>
    @GetMapping("/livrosautor")
    @CrossOrigin(origins = "*")
    public List<Livro> getLivrosAutor(@RequestParam(value="autor")String autor){
        System.out.println("AUTOR:"+autor);
        System.out.println(livros);
        return livros.stream()
            .filter(livro->livro.getAutor().equals(autor))
            .toList();
    }

    //Devolve a lista dos livros cujo ano de publicacao eh inferior ao ano informado: /biblioteca/desatualizados/ano
    // @GetMapping("/livrosautor/{autor}/ano/{ano}")
    // @CrossOrigin(origins = "*")
    // public List<Livro>getLivrosAutor(@RequestParam(value="autor")String autor){
    //     return livros.stream()
    //         .filter(livro->livro.getAutor().equals(autor))
    //         .toList();
    // }

    //Crie um rota que permita consultar todos os livros de um determinado autor publicados em um determinado ano 


    //Crie uma rota POST que permita atualizar/corrigir os dados de um livro do acervo da biblioteca (atualiza todos os campos menos o codigo)
        
}
    

