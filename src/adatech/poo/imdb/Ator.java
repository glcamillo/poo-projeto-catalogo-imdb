package adatech.poo.imdb;

import java.time.LocalDate;
import java.util.ArrayList;

// @Gerson start --------------------
// Como a classe Ator será filha de Pessoa,
// não há necessidade de declarar atributos já
// definidos em Pessoa.
public class Ator extends Pessoa{
    // Esses atributos refatorei (troquei de nome) pois são os
    //  mesmos em Pessoa
    private String nomeAtor;
    private String dataNascimentoAtor;
    private String localNascimentoAtor;
    // Esse atributo é mais para especializar o Ator
    // diferenciando de Pessoa e de Diretor
    private boolean atorEmFilme;


    // Sugiro excluir essa referência a filmes.
    // Deixar pra pesquisar por atores na classe filme.
    private ArrayList<String> filmes;

    public Ator(String nome, LocalDate dataNascimento, String nacionalidade, boolean atorEmFilme) {
        super(nome, dataNascimento, nacionalidade);
        this.atorEmFilme = atorEmFilme;
    }

    // Este método sobrescrito seria pra substituir o display
    // Eles teriam a mesma função
    @Override
    public String toString() {
        return "Ator{" +
               ", atorEmFilme=" + atorEmFilme +
                ", nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", nacionalidade='" + nacionalidade + '\'' +
                '}';
    }
    // @Gerson --------------------finish

    // Construtor para inicializar um objeto Ator
    public Ator(String nome, String dataNascimentoAtor, String localNascimentoAtor, ArrayList<String> filmes) {
        this.nomeAtor = nome;
        this.dataNascimentoAtor = dataNascimentoAtor;
        this.localNascimentoAtor = localNascimentoAtor;
        this.filmes = filmes;
    }

    // Método para exibir informações sobre o ator
    public void display() {
        System.out.println("O ator: " + nomeAtor + " nasceu em " + dataNascimentoAtor + " em " + localNascimentoAtor +
                " e fez os filmes: " + filmes);
    }


    // Método para obter os nomes dos atores no elenco
    public ArrayList<String> getAtores() {
        ArrayList<String> atores = new ArrayList<>();
        ArrayList<Ator> elenco = new ArrayList<>();
        for (Ator ator : elenco) {
            atores.add(ator.getNomeAtor());
        }
        return atores;
     }

    String getNomeAtor() {
        return this.nomeAtor;
    }
}

// Classe que representa um elenco de atores
class Elenco {
    // Lista de atores no elenco
    ArrayList<Ator> elenco = new ArrayList<>();
 
    // Construtor padrão
    public Elenco() {
    }
 
    // Método para adicionar um ator ao elenco
    public void setElenco(String nome, String dataNascimento, String localNascimento, ArrayList<String> filmes) {
        Ator ator = new Ator(nome, dataNascimento, localNascimento, filmes);
        elenco.add(ator);
     }
 
    // Método para obter a lista completa de atores no elenco
    public ArrayList<Ator> getElenco() {
        return elenco;
     }
 
    // Método para obter os nomes dos atores no elenco
    public ArrayList<String> getAtores() {
        ArrayList<String> atores = new ArrayList<>();
        for (Ator ator : elenco) {
            atores.add(ator.getNomeAtor());
        }
        return atores;
     }
}

//public class Elenco{
//Ator[] elenco;
//elenco = new Ator[5];
//}
/*
class Main{
    public static void main(String[] args) {
        Ator[] elenco;
        elenco = new Ator[5];
        String[] filmes = {"volvo", "BMW", "Ford", "Mazda"};
        elenco[0] = new Ator("Gustavo","10/11/1999","Nova Iguaçu",filmes);
        elenco[0].display();
        elenco[1] = new Ator("Deyse","27/02/1968","Rio de Janeiro",filmes);
        elenco[1].display();

    }
}*/
