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

//        ArrayList<Filme> filmesDoBancoDeDados = getFilmesDoBancoDeDados();
        boolean repetido = false;

//        for ( Filme item : filmesDoBancoDeDados) {
//            if ( item.getNomeFilme().equals(filme.getNomeFilme())) {
//                repetido = true;
//                System.out.println("Filme já cadastrado.");
//                break;
//            }
//        }
        if (!repetido) filmesDoBancoDeDados.add(filme);
        System.out.println("Filme " + filme.getNomeFilme() +  " foi salvo com sucesso.");

    }
//    public void excluirFilme (String filme) {
//        boolean excluido = false;
//        for (Filme item : this.filmesDoBancoDeDados) {
//            if ( item.getNomeFilme().equals(filme)) {
//                this.filmesDoBancoDeDados.remove (item);
//                System.out.println("Filme excluido com sucesso.");
//                excluido = true;
//                break;
//                }
//            }
//            if (!excluido) {
//                System.err.println("Filme não cadastrado.");
//            }
//        }
//
//        public void alterarFilme (Filme filme) {
//            boolean alterado = false;
//            for (Filme item : this.filmesDoBancoDeDados) {
//                if ( item.getNomeFilme().equals(filme)) {
//                    filmesDoBancoDeDados.replaceAll (filme);
//                    System.out.println("Filme alterado com sucesso.");
//                    alterado = true;
//                    break;
//                }
//            }
//            if (!alterado) {
//                System.err.println("Filme não cadastrado.");
//            }
//        }

}
