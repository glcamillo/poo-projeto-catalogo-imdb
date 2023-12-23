package adatech.poo.imdb;

import java.time.LocalDate;
import java.util.ArrayList;

public class Filme {
    private String nomeFilme;
    private String descricaoFilme;
    private String genero;
    private LocalDate dataLancamento;

    private double orcamento;
    ArrayList<Ator>  elenco = new ArrayList<>();
    Diretor diretorFilme;

    // Construtores para Filme
    public Filme (){}

    public Filme (String nomeFilme,
                  String descricaoFilme,
                  String genero,
                  LocalDate dataLancamento,
                  double orcamento, Diretor diretorFilme,
                  ArrayList<Ator> elenco)
    {
        this.nomeFilme = nomeFilme;
        this.descricaoFilme = descricaoFilme;
        this.genero = genero;
        this.dataLancamento = dataLancamento;
        this.orcamento = orcamento;
        this.elenco = elenco;
        this.diretorFilme = diretorFilme;
    }

    // Método sobrescrito para impressão do objeto Filme
    @Override
    public String toString() {
        ArrayList<String> elencoParaImpressao = new ArrayList<>();
        for (Ator ator : elenco)
            elencoParaImpressao.add(ator.getNomeAtor());
        return  "\nFilme: " +
                "Nome: " + nomeFilme +
                "\nDescricao: " + descricaoFilme +
                "\nGênero: " + genero +
                ", Data de Lancamento: " + dataLancamento +
                ", Orçamento: " + orcamento +
                "\nDiretor: " + diretorFilme.getNomeDiretor() +
                "\nElenco: " + elencoParaImpressao.toString();
    }

    public String getNomeFilme() {
        return this.nomeFilme;
    }

    public LocalDate getDataLancamento() {
        return this.dataLancamento;
    }

    public double getOrcamento() {
        return this.orcamento;
    }

    public String getDescricaoFilme () {
        return this.descricaoFilme;
    }

    public String getGenero() {
        return genero;
    }

    public ArrayList<Ator> getElenco() {return elenco;}

    public Diretor getDiretor () {return diretorFilme;}
}