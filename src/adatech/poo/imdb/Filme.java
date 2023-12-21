package adatech.poo.imdb;

import java.time.LocalDate;
import java.util.ArrayList;

// Não é necessário, pois todas as classes estarão no mesmo pacote.
// import adatech.poo.imdb.Diretor;

public class Filme {
        private String nomeFilme;
        public String descricaoFilme;
        String genero;
        LocalDate dataLancamento;

        private double orcamento;
//        String[] atores = new String[5];
//        String diretor;
        // @Gerson  start -------------------
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
        return "Filme{" +
                "nome:" + nomeFilme + '\'' +
                ", descricao:'" + descricaoFilme + '\'' +
                ", genero='" + genero + '\'' +
                ", dataLancamento=" + dataLancamento +
                ", orcamento=" + orcamento +
                ", diretorFilme=" + diretorFilme.getNomeDiretor() +
                ", elenco=" + elenco +
                '}';
    }

    // @Gerson --------------------finish

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
