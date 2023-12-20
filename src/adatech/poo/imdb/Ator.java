package src.adatech.poo.imdb;

import java.util.ArrayList;
import java.util.Arrays;

public class Ator extends Pessoa{
    // Esses atributos refatorei (troquei de nome) pois são os
    //  mesmos em Pessoa
    private String nomeAtor;
    private String dataNascimentoAtor;
    private String localNascimentoAtor;

    private boolean atorEmFilme;

    private ArrayList<String> atores = new ArrayList<>();
    private ArrayList<String> listaNomes = new ArrayList<>();

    public Ator(){

    public void setAtorEmFilme(boolean atorEmFilme) {
        this.atorEmFilme = atorEmFilme;
    }

    // Construtor para inicializar um objeto Ator
    public Ator(String nome, String dataNascimentoAtor, String localNascimentoAtor) {
        this.nomeAtor = nome;
        this.dataNascimentoAtor = dataNascimentoAtor;
        this.localNascimentoAtor = localNascimentoAtor;
    }

    // Método para exibir informações sobre o ator
    public void display() {
        System.out.println("O ator: " + nomeAtor + " nasceu em " +
                dataNascimentoAtor + " em " + localNascimentoAtor);

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

    // Método para adicionar um ator ao elenco
        public void setElenco(String nome,
                              String dataNascimento,
                              String localNascimento) {
        Ator ator = new Ator(nome, dataNascimento, localNascimento);
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
