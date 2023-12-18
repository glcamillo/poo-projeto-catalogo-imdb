package adatech.poo.imdb;

import java.util.ArrayList;
import java.util.Arrays;

public class Ator {
    //private final int NUM_ATORES = 100;
    private String nome;
    private String dataNascimento;
    private String localNascimento;

    private ArrayList<String> filmes;

    // Construtor para inicializar um objeto Ator
    public Ator(String nome, String dataNascimento, String localNascimento, ArrayList<String> filmes) {  
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.localNascimento = localNascimento;
        this.filmes = filmes;
    }

    // Método para exibir informações sobre o ator
    public void display() {
        System.out.println("O ator: " + nome + " nasceu em " + dataNascimento + " em " + localNascimento +
                " e fez os filmes: " + filmes);
    }


    // Método para obter os nomes dos atores no elenco
    public ArrayList<String> getAtores() {
        ArrayList<String> atores = new ArrayList<>();
        ArrayList<Ator> elenco = new ArrayList<>();
        for (Ator ator : elenco) {
            atores.add(ator.getNome());
        }
        return atores;
     }

    String getNome() {
        return this.nome;
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
            atores.add(ator.getNome());
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
