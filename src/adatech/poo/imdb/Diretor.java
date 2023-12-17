package adatech.poo.imdb;

import java.time.LocalDate;

public class Diretor extends Pessoa{
    private boolean diretorEmFilme;

    public Diretor(String nomeDiretor, LocalDate dataNacimento, String nacionalidade, boolean diretorEmFilme){
        super(nomeDiretor, dataNacimento, nacionalidade);
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

    public String getNomeDiretor(){
        return super.getNome();
    }

    public void setDiretorEmFilme(boolean diretorEmFilme) {
        this.diretorEmFilme = diretorEmFilme;
    }

    @Override
    public String toString() {
        return "Diretor{" +
                "diretorEmFilme=" + diretorEmFilme +
                ", nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", nacionalidade='" + nacionalidade + '\'' +
                '}';
    }
}
