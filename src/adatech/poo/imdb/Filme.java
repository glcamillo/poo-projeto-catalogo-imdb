package adatech.poo.imdb;

import java.time.LocalDate;
import java.util.ArrayList;

public class Filme {
    private String nomeFilme;
    public String descricaoFilme;
    String genero;
    LocalDate dataLancamento;

    private double orcamento;
    ArrayList<Ator>  elenco = new ArrayList<>();
    Diretor diretorFilme;
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
}
