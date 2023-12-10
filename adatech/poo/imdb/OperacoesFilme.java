import java.util.ArrayList;

public class OperacoesFilme {

    ArrayList<Filme> filmesDoBancoDeDados;

    public OperacoesFilme() {
            this.filmesDoBancoDeDados = new ArrayList<>();
        }

    public ArrayList<Filme> getFilmesDoBancoDeDados() {
        return this.filmesDoBancoDeDados;
    }
    ArrayList<Filme> filmesSalvos = filmesDoBancoDeDados;

    public void incluirFilme(Filme filme) {
        boolean repetido = false;
        for (filme : filmesDoBancoDeDados) {
            if ( filme.nomeFilme().equals(this.nomeFilme)) {
                repetido = true;
                System.out.println("Filme já cadastrado.");
                break;
            }
        }
        if (!repetido) filmesDoBancoDeDados.add(filme);
        System.out.println("Usuário foi salvo com sucesso.");

    }
    public void excluirFilme (String filme) {
        boolean excluido = false;
        for (Filme item : this.filmesDoBancoDeDados) {
            if ( item.getNomeFilme().equals(filme)) {
                this.filmesDoBancoDeDados.remove (item);
                System.out.println("Filme excluido com sucesso.");
                excluido = true;
                break;
                }
            }
            if (!excluido) {
                System.err.println("Filme não cadastrado.");
            }
        }

        public void alterarFilme (Filme filme) {
            boolean alterado = false;
            for (Filme item : this.filmesDoBancoDeDados) {
                if ( item.getNomeFilme().equals(filme)) {
                    filmesDoBancoDeDados.replaceAll (filme);
                    System.out.println("Filme alterado com sucesso.");
                    alterado = true;
                    break;
                }
            }
            if (!alterado) {
                System.err.println("Filme não cadastrado.");
            }
        }
}
