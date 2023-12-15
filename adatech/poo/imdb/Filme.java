package adatech.poo.imdb;

import java.time.LocalDate;
import java.util.ArrayList;

// Não é necessário, pois todas as classes estarão no mesmo pacote.
// import adatech.poo.imdb.Diretor;

public class Filme {
        private String nomeFilme;
        public String descricaoFilme;
        String genero;

        Diretor diretor;
        LocalDate dataLancamento;

        private double orcamento;
        ArrayList<Ator> atores = new Arraylist();

        public Filme () {}
        public Filme (String nomeFilme, String descricaoFilme,String genero,LocalDate dataLancamento,
                      double orcamento, Diretor diretor, ArrayList<Ator> atores) {
            this.nomeFilme = nomeFilme;
            this.dataLancamento = dataLancamento;
            this.orcamento = orcamento;
            this.atores = atores;
            this.descricaoFilme = descricaoFilme;
            this.diretor = diretor;
            this.genero = genero;
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
        public String getDescricaoFilme () { return this.descricaoFilme; }

        public String getAtores () {  return this.atores; }


}



