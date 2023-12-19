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
}
