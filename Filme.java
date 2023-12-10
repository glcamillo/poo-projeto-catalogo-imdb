import java.time.LocalDate;
import java.util.ArrayList;

public class Filme
        private String nomeFilme;
        private String descricaoFilme;
        String genero;
        Diretor diretor = new Diretor();

        LocalDate dataLancamento;

        private double orcamento;
        Ator [] atores = new Ator[5];

        public Filme () {}
        public Filme (String nomeFilme, LocalDate dataLancamento, double orcamento,
                      String descricaoFilme,String genero, Diretor diretor, Ator[] atores) {
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
