package src.adatech.poo.imdb;

import java.time.LocalDate;

public class Ator extends Pessoa {
    private boolean atorEmFilme;

    public Ator(String nomeAtor, LocalDate dataNascimento, String nacionalidade, boolean atorEmFilme) {
        super(nomeAtor, dataNascimento, nacionalidade);
        this.atorEmFilme = atorEmFilme;
    }

    public Ator(String nome, boolean atorEmFilme) {
        super(nome);
        this.atorEmFilme = atorEmFilme;
    }

    public Ator(String nome, LocalDate dataNascimento, boolean atorEmFilme) {
        super(nome, dataNascimento);
        this.atorEmFilme = atorEmFilme;
    }

    public String getNomeAtor() {
        return super.getNome();
    }

    public void setAtorEmFilme(boolean atorEmFilme) {
        this.atorEmFilme = atorEmFilme;
    }

    @Override
    public String toString() {
        return "Ator{" +
                "atorEmFilme=" + atorEmFilme +
                ", nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", nacionalidade='" + nacionalidade + '\'' +
                '}';
    }
}