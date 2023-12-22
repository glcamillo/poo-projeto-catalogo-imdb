package adatech.poo.imdb;

import java.time.LocalDate;

public class Diretor extends Pessoa{
    private boolean diretorEmFilme;

    public Diretor(String nomeDiretor, LocalDate dataNacimento, String naturalidade, boolean diretorEmFilme){
        super(nomeDiretor, dataNacimento, naturalidade);
        this.diretorEmFilme = diretorEmFilme;
    }

    public Diretor(String nome, boolean diretorEmFilme) {
        super(nome);
        this.diretorEmFilme = diretorEmFilme;
    }

    public Diretor(String nome, LocalDate dataNascimento, boolean diretorEmFilme) {
        super(nome, dataNascimento);
        this.diretorEmFilme = diretorEmFilme;
    }

    public String getNomeDiretor() {
        return super.getNome();
    }

    public void setDiretorEmFilme(boolean diretorEmFilme) {
        this.diretorEmFilme = diretorEmFilme;
    }

    @Override
    public String toString() {
        return String.format("Nome: %s\nData de Nascimento: %s\nNaturalidade: %s\nDiretor em Filme? %b\n", nome, dataNascimento, naturalidade, diretorEmFilme);
    }
}