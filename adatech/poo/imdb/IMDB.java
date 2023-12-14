package adatech.poo.imdb;

// Não é necessário, pois todas as classes estarão no mesmo pacote.
// import adatech.poo.imdb.Diretor;

import java.time.LocalDate;
import java.util.ArrayList;

/*
    Classe driver para o projeto IMDB.
    Objetivos:
     - catalogar filmes, atores e diretores
     - permitir pesquisas parametrizadas
    Modelagem através de classes: Filme, Ator, Diretor
    
    Em 20231210: inclusão de métodos para testes das
      classes. Objetos para classes Filme, Ator e Diretor
      podem ser criadas e testadas dentro do respectivo
      método.

 */

public class IMDB {

    public static void main(String[] args) {
        System.out.println("Projeto inicial para m sistema de IMDB");
        processaEntrada();
        
        // Testa classe Diretor
        testDiretor();
        // Testa classe Filme
        testFilme();
        //Testa classe Ator
        testAtor();
    }
    
    // Método para tratar entrada de dados
    static void processaEntrada() {

    }

    /* Método para testar a funcionalidade da classe Filme.
       Todas as alterações devem ser incluídas aqui nesta
       fase do projeto.
    */
    public static void testFilme() {
        Filme filme = new Filme("As pontes de Madison","O fotógrafo Robert Kincaid (Clint Eastwood) vagou" +
            " pela vida da dona de casa Francesca Johnson (Meryl Streep) por quatro dias na década de 1960.",
            "Drama romântico",LocalDate.of(1995,05,16),15000000.00,
            "Clint Eastwood", new ArrayList<Ator>("Clint Eastwood", "Merryl Streep"));

        Filme filme1 = new Filme("Interestelar","Uma equipe de exploradores viaja através de um buraco" +
          "de minhoca no espaço, na tentativa de garantir a sobrevivência da humanidade.","Aventura, Ficção Científica",
          LocalDate.of(2014,07,15),1000000.00,"Christopher Nolan",new ArrayList<Ator>
          ("Matthew McConaughey","Anne Hathaway", "Jessica Chastain"));

        Filme filme2 = new Filme("O Poderoso Chefão","O patriarca idoso de uma dinastia do crime " +
                "organizado transfere o controle de seu império clandestino para seu filho relutante.",
                "Policial, Drama", LocalDate.of(1972,07,15),10000000.00,"Francis Coppola",
                new ArrayList<Ator> ("Marlon Brando>","Al Pacino", "James Caan")) ;

        OperacoesFilme.incluirFilme (filme);
        OperacoesFilme.incluirFilme (filme1);
        OperacoesFilme.incluirFilme (filme2);

        Filme filmeApesquisar = OperacoesFilme.pesquisarFilme("as pontes de madison");
        filmeApesquisar = OperacoesFilme.pesquisarFilme("Seven");

    }

    /* Método para testar a funcionalidade da classe Pessoa.
       Todas as alterações devem ser incluídas aqui nesta
       fase do projeto.
    */
    public static void testPessoa() {

    }

    /* Método para testar a funcionalidade da classe Ator.
       Todas as alterações devem ser incluídas aqui nesta
       fase do projeto.
    */
    public static void testAtor() {
        Ator[] elenco;
        elenco = new Ator[5];
        String[] filmes = {"volvo", "BMW", "Ford", "Mazda"};
        elenco[0] = new Ator("Gustavo","10/11/1999","Nova Iguaçu",filmes);
        elenco[0].display();
        elenco[1] = new Ator("Deyse","27/02/1968","Rio de Janeiro",filmes);
        elenco[1].display();
   }

    /* Método para testar a funcionalidade da classe Diretor.
       Todas as alterações devem ser incluídas aqui nesta
       fase do projeto.
    */
    public static void testDiretor() {
        ArrayList<Diretor> diretores = new ArrayList<>();

        diretores.add(new Diretor("Antoine Fuqua"));
        System.out.println("Nome diretor: " + diretores.get(0).getNomeDiretor());
    }

}
