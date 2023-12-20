package src.adatech.poo.imdb;

import java.time.LocalDate;

public class Ator extends Pessoa {
    private boolean atorEmFilme;

    public Ator(String nome, LocalDate dataNascimento, String nacionalidade, boolean atorEmFilme) {
        super(nome, dataNascimento, nacionalidade);
        this.atorEmFilme = atorEmFilme;
    }

    public Ator(String nome, LocalDate dataNascimento, boolean atorEmFilme) {
        super(nome, dataNascimento);
        this.atorEmFilme = atorEmFilme;
    }  
  
    public Ator(String nome, boolean atorEmFilme) {
        super(nome);
        this.atorEmFilme = atorEmFilme;
    }

    public void setAtorEmFilme(boolean atorEmFilme) {
        this.atorEmFilme = atorEmFilme;
    }

    public String getNomeAtor() {
        return super.getNome();
    }

    @Override
    public String toString() {
        return "Ator{" +
                "Ator em Filme?" + atorEmFilme +
                ", Nome='" + nome + '\'' +
                ", Dt Nascimento=" + dataNascimento +
                ", nacionalidade='" + nacionalidade + '\'' +
                '}';
    }
}