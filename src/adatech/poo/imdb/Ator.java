package src.adatech.poo.imdb;

import java.util.ArrayList;
import java.util.Arrays;

public class Ator {
    private String nome;
    private String dataNascimento;
    private String localNascimento;
    private ArrayList<String> filmes;

    private ArrayList<String> atores = new ArrayList<>();
    private ArrayList<String> listaNomes = new ArrayList<>();

    public Ator(){

    }
    public void cadastrarAtor(String nome, String dataNascimento, String localNascimento, ArrayList<String> filmes) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.localNascimento = localNascimento;
        this.filmes = filmes;
        ArrayList<String> ficha = new ArrayList<>();
        ficha.add("Nome: " + this.nome);
        ficha.add("Data de Nascimento: " + this.dataNascimento);
        ficha.add("Local de Nascimento: " + this.localNascimento);
        ficha.add("Filmes: " + Arrays.toString(this.filmes.toArray()));

        atores.add(Arrays.toString(ficha.toArray()));
        listaNomes.add(this.nome);
    }
    public ArrayList<String> getAtores() {
        return atores;
    }
    public ArrayList<String> getNomeAtores() {
        return listaNomes;
    }
//    public void display() {
//        System.out.println("O ator: " + nome + " nasceu em " + dataNascimento + " em " + localNascimento +
//                " e fez os filmes: " + filmes);
//    }



}
//class Elenco {
//    // Lista de atores no elenco
//    ArrayList<Ator> elenco = new ArrayList<>();
//
// Construtor padrão
//    public Elenco() {
//    }
//
//    // Método para adicionar um ator ao elenco
//    public void setElenco(String nome, String dataNascimento, String localNascimento, ArrayList<String> filmes) {
//        Ator ator = new Ator(nome, dataNascimento, localNascimento, filmes);
//        elenco.add(ator);
//     }

//    // Método para obter a lista completa de atores no elenco
//    public ArrayList<Ator> getElenco() {
//        return elenco;
//     }
//
//    // Método para obter os nomes dos atores no elenco
//    public ArrayList<String> getAtores() {
//        ArrayList<String> atores = new ArrayList<>();
//        for (Ator ator : elenco) {
//            atores.add(ator.getNome());
//        }
//        return atores;
//     }
//}

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