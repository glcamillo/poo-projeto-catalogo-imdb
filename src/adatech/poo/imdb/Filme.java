package src.adatech.poo.imdb;

import java.time.LocalDate;
import java.util.ArrayList;

// Não é necessário, pois todas as classes estarão no mesmo pacote.
// import adatech.poo.imdb.Diretor;

public class Filme {
        private String nomeFilme;
        public String descricaoFilme;
        String genero;

        String diretor;
        LocalDate dataLancamento;

        private double orcamento;
        String [] atores = new String[5];

        public Filme () {}
        public Filme (String nomeFilme, String descricaoFilme,String genero,LocalDate dataLancamento,
                      double orcamento, String diretor, String[] atores) {
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
        public String getDescricaoFilme () {
            return this.descricaoFilme;
        }


}
