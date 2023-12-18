package src.adatech.poo.imdb;

import java.time.LocalDate;

public abstract class Pessoa {
    protected String nome;
    protected LocalDate dataNascimento;
    protected String nacionalidade;

    public Pessoa() {
    }
    public Pessoa(String nome){
        this.nome = nome;
        this.dataNascimento = null;
        this.nacionalidade = null;
    }

    public Pessoa(String nome, LocalDate dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.nacionalidade = null;
    }

    public Pessoa(String nome, LocalDate dataNascimento, String nacionalidade) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.nacionalidade = nacionalidade;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    @Override
    public String toString() {
        if (dataNascimento == null && nacionalidade == null) {
            return "Pessoa{" +
                    "nome='" + nome + '\'';
        }
        if (dataNascimento != null && nacionalidade == null) {
            return "Pessoa{nome='" + nome + '\'' +
                    ", dataNascimento=" + dataNascimento + '}';
        }
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", nacionalidade='" + nacionalidade + '\'' +
                '}';
    }
}
