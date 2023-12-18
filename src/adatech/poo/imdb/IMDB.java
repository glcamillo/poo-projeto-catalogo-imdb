package src.adatech.poo.imdb;

// Não é necessário, pois todas as classes estarão no mesmo pacote.
// import adatech.poo.imdb.Diretor;

//import src.adatech.poo.imdb.Ator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

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

    /*   Base de dados de objetos Ator, Diretor e Filme
      -listaAtores : ArrayList<Ator>
      -listaDiretores : ArrayList<Diretor>
      -listaFilmes : ArrayList<Filme>
      +tiposGeneros : Enum
      +main(args : String[]) : static void

     */
    private ArrayList<Ator> listaAtores = new ArrayList<Ator>();
    private static ArrayList<Diretor> listaDiretores = new ArrayList<>();
    private ArrayList<Filme> listaFilmes = new ArrayList<>();

    // Exemplos
    private enum tiposGeneros {HUMOR, COMEDIA_ROMANTICA, GUERRA, DOCUMENTARIO };


    public static void main(String[] args) {
        System.out.println("Projeto inicial para um sistema de IMDB");
        processaEntrada();
        
        // Testa classe Diretor
        testDiretor();
        // Testa classe Filme
        testFilme();
        //Testa classe Ator
        testAtor();
    }

    // ===========  Métodos Públicos para PROCESSAR ENTRADAS  ===========
    /*
      +processarEntrada(void) : void
      +processarEntradaAtor(void) : void
      +processarEntradaDiretor() : void
      +processarEntradaFilme() : void
     */
    // Método para tratar entrada de dados
    static void processaEntrada() {
        Scanner leitor = new Scanner(System.in);
        System.out.println(" === Menu IMDB ====");
        System.out.println(" 1. Incluir Ator");
        System.out.println(" 2. Incluir Diretor");
        System.out.println(" 3. Incluir Filme");
        System.out.print(" Qual opção: ");
        String linhaOpcao = leitor.nextLine();
        if (linhaOpcao.equals("2"))
            processarEntradaDiretor();

    }


    static void processarEntradaDiretor() {
        Scanner leitor = new Scanner(System.in);
        System.out.println(" === Entrada de DIRETORES (digitar SAIR para terminar) === ");
        boolean repete = true;
        do {
            System.out.print("Qual nome de Diretor? ");
            String linhaNomeDiretor = leitor.nextLine();
            if (linhaNomeDiretor.equalsIgnoreCase("sair"))
                repete = false;
            else {
                Diretor diretor = pesquisarDiretor(linhaNomeDiretor);
                if (diretor == null) {
                    System.out.printf("\nDiretor de nome %s não existe. Será incluído.\n", linhaNomeDiretor);
                    diretor = incluirDiretor(linhaNomeDiretor);
                    if (diretor == null) {
                        System.err.println("Objeto diretor não criado");
                    }
                }
            }
        } while (repete);
    }

    static void processaEntradaAtor() {

    }

    static void processaEntradaFilme() {

    }




    // ===========  Métodos Privados para INCLUSÃO ===========
    /* Se inclusão bem sucedida, returna referência ao objeto criado;
           caso contrário, null.
      -incluirAtor(nomeAtor : String) : Ator
      -incluirDiretor(nomeDiretor: String) : Diretor
      -incluirFilme(nomeFilme : String) : Filme
     */
//    static Ator incluirAtor(String nomeAtor) {
//        Ator ator = null;
//        return ator;
//    }

    static Diretor incluirDiretor(String nomeDiretor) {
        Diretor diretor = null;
        try {
            diretor = new Diretor(nomeDiretor);
            listaDiretores.add(diretor);
        } catch (RuntimeException e) {
            System.err.println("Erro na criação objeto Diretor");
        }
        return diretor;
    }
    static Filme incluirFilme(String nomeFilme) {
        Filme filme = null;
        return filme;
    }



    // =========== Métodos Públicos para PESQUISAR  ===========
    /* Pesquisas de Ator e Diretor retornam um único objeto:
            - nomes são chaves primárias
       Pesquisas de Filmes retornam um array:
            - vários filmes podem ter o mesmo nome
      +pesquisarAtor() : void
      +pesquisarDiretor() : void
      +pesquisarFilme() : void
     */
    static Ator pesquisarAtor(String nomeDiretor) {
        return null;
    }
    static Diretor pesquisarDiretor(String nomeDiretor) {
        for (Diretor item : listaDiretores) {
            if (item.getNomeDiretor().toLowerCase().equalsIgnoreCase(nomeDiretor))
                return item;
        }
        return null;
    }
    static Filme[] pesquisarFilmes(String nomeFilme) {
        return null;
    }



    // =========== Métodos Públicos para TESTES INTERNOS  ===========
    /* Método para testar a funcionalidade da classe Pessoa.
       Todas as alterações devem ser incluídas aqui nesta
       fase do projeto.
    */
   /* Método para testar a funcionalidade da classe Filme.
       Todas as alterações devem ser incluídas aqui nesta
       fase do projeto.
    */
    public static void testFilme() {
        Filme filme = new Filme("As pontes de Madison","O fotógrafo Robert Kincaid (Clint Eastwood) vagou" +
                " pela vida da dona de casa Francesca Johnson (Meryl Streep) por quatro dias na década de 1960.",
                "Drama romântico",LocalDate.of(1995,05,16),15000000.00,
                "Clint Eastwood", new String[]{"Clint Eastwood", "Merryl Streep"});
//        filme = ("As pontes de Madison";"O fotógrafo Robert Kincaid (Clint Eastwood) vagou" +
//                " pela vida da dona de casa Francesca Johnson (Meryl Streep) por quatro dias na década de 1960.",
//                "Drama romântico", "Clint Eastwood", "1995", String.valueOf(15000000.00),
//                "Clint Eastwood", "Merryl Streep");
//
        Filme filme1 = new Filme("Interestelar","Uma equipe de exploradores viaja através de um buraco" +
                "de minhoca no espaço, na tentativa de garantir a sobrevivência da humanidade.","Aventura, Ficção Científica",
                LocalDate.of(2014,07,15),1000000.00,"Christopher Nolan",new String []
                {"Matthew McConaughey","Anne Hathaway", "Jessica Chastain"}) ;

        OperacoesFilme.incluirFilme (filme);
        OperacoesFilme.incluirFilme (filme1);
        System.out.println("Filme incluido com sucesso.");

    }

    public static void testPessoa() {

    }

    /* Método para testar a funcionalidade da classe Ator.
       Todas as alterações devem ser incluídas aqui nesta
       fase do projeto.
    */
    public static void testAtor() {
        // Lista de filmes para cada ator
        //ArrayList<String> filmes = new ArrayList<>(Arrays.asList("volvo", "BMW", "Ford", "Mazda"));
        ArrayList<String> filmes;

//        // Instância da classe Elenco
//        Elenco atores = new Elenco();
//
//        // Adicionando atores ao elenco
//        atores.setElenco("Deyse", "27/02/1968", "Rio de Janeiro", filmes);
//        atores.setElenco("Gustavo","10/11/1999","Nova Iguaçu",filmes);
//
//        // Obtendo a lista completa de atores e seus detalhes
//        ArrayList<Ator> pessoas = atores.getElenco();
//        for (Ator ator : pessoas) {
//            ator.display();
//        }
//
//        // Obtendo os nomes dos atores no elenco
//        ArrayList<String> nomes = atores.getAtores();
//        System.out.println(nomes);
        src.adatech.poo.imdb.Ator atores = new Ator();
        ArrayList<String> lista = atores.getAtores();
        //atores.cadastrarAtor("Deyse", "27/02/1968", "Rio de Janeiro", filmes);
        //atores.cadastrarAtor("Tom Hanks", "09/07/1956", "Concord",filmes = new ArrayList<>(Arrays.asList("Forrest Gump", "O resgate do soldado Ryan", "Naufrago","Toy Story")));
        // Exemplo 1
        atores.cadastrarAtor("Tom Hanks", "09/07/1956", "Concord", new ArrayList<>(Arrays.asList("Forrest Gump", "O resgate do soldado Ryan", "Náufrago", "Toy Story")));

        // Exemplo 2
        atores.cadastrarAtor("Meryl Streep", "22/06/1949", "Summit", new ArrayList<>(Arrays.asList("O diabo veste Prada", "A escolha de Sofia", "Kramer vs. Kramer", "Mamma Mia!")));

        // Exemplo 3
        atores.cadastrarAtor("Leonardo DiCaprio", "11/11/1974", "Los Angeles", new ArrayList<>(Arrays.asList("Titanic", "O Regresso", "A Origem", "Prenda-me se for capaz")));

        // Exemplo 4
        atores.cadastrarAtor("Julia Roberts", "28/10/1967", "Atlanta", new ArrayList<>(Arrays.asList("Uma Linda Mulher", "Erin Brockovich", "Álbum de Família", "Notting Hill")));

        // Exemplo 5
        atores.cadastrarAtor("Brad Pitt", "18/12/1963", "Shawnee", new ArrayList<>(Arrays.asList("Clube da Luta", "Bastardos Inglórios", "Entrevista com o Vampiro", "Onze Homens e um Segredo")));

        //System.out.println(lista);
        for (String ator : lista) {
            System.out.println("Ator: " + ator);
        }
    }

    /* Método para testar a funcionalidade da classe Diretor.
       Todas as alterações devem ser incluídas aqui nesta
       fase do projeto.
    */
    public static void testDiretor() {
        listaDiretores.add(new Diretor("Antoine Fuqua"));

        System.out.printf("\n\n === LISTA DIRETORES === \n");
        for (Diretor item : listaDiretores) {
            System.out.println("Nome diretor: " + item.getNomeDiretor());
            System.out.println(item.toString());

        }
    }

}
