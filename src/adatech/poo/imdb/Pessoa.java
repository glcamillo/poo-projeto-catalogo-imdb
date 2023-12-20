package adatech.poo.imdb;

import java.time.LocalDate;

public abstract class Pessoa {
    protected String nome;
    protected LocalDate dataNascimento;
    protected String naturalidade;

    public Pessoa() {
    }
    public Pessoa(String nome){
        this.nome = nome;
        this.dataNascimento = null;
        this.naturalidade = null;
    }

    public Pessoa(String nome, LocalDate dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.naturalidade = null;
    }

    public Pessoa(String nome, LocalDate dataNascimento, String naturalidade) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.naturalidade = naturalidade;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    @Override
    public String toString() {
        if (dataNascimento == null && naturalidade == null) {
            return "Pessoa{" +
                    "Nome='" + nome + '\'';
        }
        if (dataNascimento != null && naturalidade == null) {
            return "Pessoa{Nome='" + nome + '\'' +
                    ", Dt Nascimento=" + dataNascimento + '}';
        }
        return "Pessoa{" +
                "Nome='" + nome + '\'' +
                ", Dt Nascimento=" + dataNascimento +
                ", Naturalidade='" + naturalidade + '\'' +
                '}';
    }
}
