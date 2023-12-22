package adatech.poo.imdb;

import java.time.LocalDate;

public class Ator extends Pessoa {
    private boolean atorEmFilme;

    public Ator(String nome, LocalDate dataNascimento, String naturalidade, boolean atorEmFilme) {
        super(nome, dataNascimento, naturalidade);
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

    public Ator() {

    }

    public void setAtorEmFilme(boolean atorEmFilme) {
        this.atorEmFilme = atorEmFilme;
    }

    public String getNomeAtor() {
        return super.getNome();
    }

    @Override
    public String toString() {
        return String.format("Nome: %s\nData de Nascimento: %s\nNaturalidade: %s\nAtor em Filme? %b\n", nome, dataNascimento, naturalidade, atorEmFilme);
    }
}