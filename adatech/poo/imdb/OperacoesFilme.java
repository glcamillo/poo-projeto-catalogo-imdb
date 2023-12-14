package adatech.poo.imdb;

import java.util.ArrayList;

public class OperacoesFilme {

    public static ArrayList<Filme> filmesDoBancoDeDados = new ArrayList<>();
    public OperacoesFilme() {
        this.filmesDoBancoDeDados = new ArrayList<>();
    }
    public static ArrayList<Filme> getFilmesDoBancoDeDados() {
        return filmesDoBancoDeDados;
    }
    public static void incluirFilme(Filme filme) {

        filmesDoBancoDeDados.add(filme);
        System.out.println("Filme " + filme.getNomeFilme() +  " foi salvo com sucesso.");

    }

    public static Filme pesquisarFilme(String nomeFilme) {
        boolean achou = false;
        Filme filmePesquisado = new Filme();
        int index = 0;
        for (Filme item : filmesDoBancoDeDados) {
            if (item.getNomeFilme().equals(nomeFilme.toLowerCase())) {
                index = filmesDoBancoDeDados.indexOf (item);
                System.out.println("Filme encontrado: ");
                System.out.println("Nome do filme: " + item.getNomeFilme());
                System.out.println("Descrição: " + item.descricaoFilme);
                System.out.println("Diretor: " + item.diretor);
                System.out.println("Atores principais: " + item.atores[0]+", "+item.atores[1]);
                achou = true;
                filmePesquisado = filmesDoBancoDeDados.get(index);
            }
        }
        if (!achou) {
            System.err.println("Filme não cadastrado: " + nomeFilme);
        }
        return filmePesquisado;
    }

}
