package src.adatech.poo.imdb;

// Não é necessário, pois todas as classes estarão no mesmo pacote.
// import adatech.poo.imdb.Diretor;

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
    private static ArrayList<Ator> listaAtores = new ArrayList<Ator>();
    private static ArrayList<Diretor> listaDiretores = new ArrayList<>();
    private static ArrayList<Filme> listaFilmes = new ArrayList<>();

    // Exemplos
    static final private String[] tiposGeneros = new String[]{"ACAO", "DRAMA", "SUSPENSE", "HUMOR", "COMEDIA_ROMANTICA", "GUERRA", "DOCUMENTARIO"};


    public static void main(String[] args) {
        System.out.println("Projeto inicial para um sistema de IMDB");
        processaEntrada();
        
        // Testa classe Diretor
        testDiretor();
        // Testa classe Filme
        testFilme();
        //Testa classe Ator

    }

    // ===========  Métodos Públicos para PROCESSAR ENTRADAS  ===========
    /*      +processarEntrada(void) : void
            +processarEntradaAtor(void) : void
            +processarEntradaDiretor() : void
            +processarEntradaFilme() : void
     */

    // Método para tratar entrada de dados
    static void processaEntrada() {
        Scanner leitor = new Scanner(System.in);
        boolean continuar = true;
        do {
            System.out.println(" === Menu IMDB ====");
            System.out.println(" 1. Incluir Ator");
            System.out.println(" 2. Incluir Diretor");
            System.out.println(" 3. Incluir Filme");
            System.out.println(" 4. Imprime Lista Atores");
            System.out.println(" 5. Imprime Lista Diretores");
            System.out.println(" 6. Imprime Lista Filmes");
            System.out.println(" 7. Imprime todas as listas");
            System.out.println(" 8. Pesquisar Ator ");
            System.out.println(" 9. Pesquisar Diretor");
            System.out.println(" 10. Pesquisar Filme");
            System.out.println(" 11. Testa classe Ator e imprime lista");
            System.out.println(" 12. Testa classe Diretor e imprime lista");
            System.out.println(" 13. Testa classe FIlme e imprime lista");
            System.out.println(" s. Sair");
            System.out.print(" Qual opção: ");
            String linhaOpcao = leitor.nextLine();
            switch (linhaOpcao.toLowerCase()) {
                case "1":
                    processaEntradaAtor();
                    break;
                case "2":
                    processarEntradaDiretor();
                    break;
                case "3":
                    processaEntradaFilme();
                    break;
                case "4":
                    imprimeListaAtores();
                    break;
                case "5":
                    imprimeListaDiretores();
                    break;
                case "6":
                    imprimeListaFilmes();
                    break;
                case "7":
                    imprimeListaAtores();
                    imprimeListaDiretores();
                    imprimeListaFilmes();
                    break;
                case "8":
                    pesquisarAtores();
                    break;
                case "9":
                    pesquisarDiretores();
                    break;
                case "10":
                    pesquisarFilmes();
                    break;
                case "11":
                    testAtor();
                    break;
                case "12":
                    testDiretor();
                    break;
                case "13":
                    testFilme();
                    break;

                case "s":
                    System.exit(0);
                    ;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        } while(continuar);
    }

    static void processaEntradaAtor() {
        Ator ator = null;
        Scanner leitor = new Scanner(System.in);
        System.out.println(" === Entrada de ATORES (digitar SAIR para terminar) === ");
        boolean repete = true;
        do {
            System.out.print("Qual nome do Ator / Atriz? ");
            String linhaNomeAtor = leitor.nextLine();
            if (linhaNomeAtor.equalsIgnoreCase("sair"))
                repete = false;
            else {
                ator = pesquisarAtor(linhaNomeAtor);
                if (ator == null) {
                    System.out.printf("\nAtor/Atriz de nome %s não existe. Será incluído.\n", linhaNomeAtor);
                    ator = incluirAtor(linhaNomeAtor);
                    if (ator == null) {
                        System.err.println("Objeto ator não criado");
                    }
                }
            }
        } while (repete);
    }
    static Ator incluirAtor(String nomeAtor) {
        Ator ator = null;
        try {
            ator = new Ator(nomeAtor, null,null,false);
            listaAtores.add(ator);
        } catch (RuntimeException e) {
            System.err.println("Erro na criação objeto Ator");
        }
        return ator;
    }
    static Ator pesquisarAtor(String nomeAtor) {
        Ator atorRetornado = null;
        for (Ator item : listaAtores) {
            if (item.getNome().equalsIgnoreCase(nomeAtor)) {
                atorRetornado = item;
                break;
            }
            else atorRetornado = null ;
        }
        return atorRetornado;
    }
    static void processarEntradaDiretor() {
        Diretor diretor = null;
        Scanner leitor = new Scanner(System.in);
        System.out.println(" === Entrada de DIRETORES (digitar SAIR para terminar) === ");
        boolean repete = true;
        do {
            System.out.print("Qual nome de Diretor? ");
            String linhaNomeDiretor = leitor.nextLine();
            if (linhaNomeDiretor.equalsIgnoreCase("sair"))
                repete = false;
            else {
                diretor = pesquisarDiretor(linhaNomeDiretor);
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



    static void processaEntradaFilme() {
        Filme filme = null;
        Diretor diretor = null;

        Scanner leitor = new Scanner(System.in);

        System.out.println(" === Entrada de FILMES (digitar SAIR para terminar) === ");
        boolean repete = true;
        do {
            System.out.print("Qual NOME de Filme? ");
            String filmeNome = leitor.nextLine();
            if (filmeNome.equalsIgnoreCase("sair"))
                repete = false;
            else {
                diretor = null;
                ArrayList<Ator> elenco = new ArrayList<>();
                // Aqui, diferente de Ator e Diretor, vários filmes podem ter o mesmo nome
                System.out.print("Qual DESCRIÇÃO para o Filme? ");
                String filmeDescricao = leitor.nextLine();
                String filmeGenero = processaEntradaGenero();
                System.out.print("Qual DATA LANÇAMENTO (formato numérico: yyyy-mm-dd) do Filme? ");
                String filmeDataLancamento = leitor.nextLine();

                Double filmeOrcamento = 1_000_000.0;

                System.out.print("Qual o nome do Diretor do Filme? ");
                String diretorFilme = leitor.nextLine();
                if (pesquisarDiretor(diretorFilme) == null) {
                    incluirDiretor(diretorFilme);
                }
                System.out.print("\nQuais ATORES participaram do Filme? Escolha pelo número:");
                int i = 0;
                for (Ator item : listaAtores) {
                    System.out.printf("\n %d - %s", i++, item.getNome());
                }
                // Poderia incluir uma linha para incluir um novo ator que
                // chama o respectivo método de inclusão Ator.
                boolean continuar = true;
                do {
                    System.out.print("\nQual número de ator a incluir (SAIR para terminar): ");
                    String itemAtor = leitor.nextLine();
                    if (itemAtor.equalsIgnoreCase("sair")) {
                        continuar = false;
                    } else elenco.add(listaAtores.get(Integer.parseInt(itemAtor)));

                } while (continuar);
                listaFilmes.add(new Filme(filmeNome, filmeDescricao, filmeGenero, LocalDate.parse(filmeDataLancamento), filmeOrcamento, diretor, elenco));
            }
        } while (repete) ;
    }


    private static String processaEntradaGenero() {
        Scanner leitor = new Scanner(System.in);
        System.out.print("\nEscolha qual GÊNERO do filme:");
        System.out.printf("\n%s\n", Arrays.toString(tiposGeneros));
        String genero = leitor.nextLine();
        for (String item : tiposGeneros) {
            if (item.equalsIgnoreCase(genero))
                return item;
        }
        return null;
    }


    // ===========  Métodos Privados para INCLUSÃO ===========
    /* Se inclusão bem sucedida, returna referência ao objeto criado;
           caso contrário, null.
        -incluirAtor(nomeAtor : String) : Ator
        -incluirDiretor(nomeDiretor: String) : Diretor
        -incluirFilme(nomeFilme : String) : Filme
     */


    static Diretor incluirDiretor(String nomeDiretor) {
        Diretor diretor = null;
        try {
            diretor = new Diretor(nomeDiretor, false);
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



    // =========== Métodos Públicos para PESQUISAR e IMPRIMIR ===========
    /* Pesquisas de Ator e Diretor retornam um único objeto:
            - nomes são chaves primárias
       Pesquisas de Filmes retornam um array:
            - vários filmes podem ter o mesmo nome
      +pesquisarAtor() : void
      +pesquisarDiretor() : void
      +pesquisarFilme() : void
     */
    static void imprimirAtores(){

    }

    static void pesquisarAtores() {    }
    static Diretor pesquisarDiretor(String nomeDiretor) {
        for (Diretor item : listaDiretores) {
            if (item.getNomeDiretor().toLowerCase().equalsIgnoreCase(nomeDiretor))
                return item;
        }
        return null;
    }
    static void pesquisarDiretores () {}


    static void pesquisarFilmes() {
        Scanner leitor = new Scanner(System.in);
        boolean repete = true, achou = false;
        do {
            System.out.print("Qual NOME do Filme a pesquisar? ");
            String filmeNome = leitor.nextLine();
            if (filmeNome.equalsIgnoreCase("sair"))
                repete = false;
            else {
                achou = false;
                for (Filme item : listaFilmes) {
                    if (item.getNomeFilme().equalsIgnoreCase(filmeNome)) {
                        System.out.println("Nome Filme: " + item.getNomeFilme());
                        System.out.println("Ano de Lançamento: " + item.getDataLancamento());
                        System.out.println("Descrição: " + item.getDescricaoFilme());
                        System.out.println("Gênero: " + item.genero);
                        System.out.println("Diretor: " + item.diretorFilme);
                        System.out.println("Atores: " + item.elenco);
                        achou = true;
                        break;
                    }
                }
                if (!achou) System.out.println("Filme não cadastrado: " + filmeNome);
            }
        } while (repete);
    }

    static void imprimeListaAtores() {
        System.out.print("\n\n === LISTA ATORES === \n");
        for (Ator item : listaAtores)
            System.out.println(item.toString());
    }
    static void imprimeListaDiretores() {
        System.out.print("\n\n === LISTA DIRETORES === \n");
        for (Diretor item : listaDiretores)
            System.out.println(item.toString());
    }

    static void imprimeListaFilmes() {
        System.out.print("\n\n === LISTA FILMES === \n");
        for (Filme item : listaFilmes)
            System.out.println(item.toString());
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
        Diretor diretorFilme = new Diretor("Clint Eastwood",true);
        ArrayList<Ator> elenco = new ArrayList();
        for (Ator item : listaAtores) {
            if (item.getNome().equalsIgnoreCase("Clint Eastwood"))
                elenco.add (item);
        }
        for (Ator item : listaAtores) {
            if (item.getNome().equalsIgnoreCase("Merryl Streep"))
                elenco.add (item);
        }

        Filme filme = new Filme("As pontes de Madison","O fotógrafo Robert Kincaid (Clint Eastwood) vagou" +
                " pela vida da dona de casa Francesca Johnson (Meryl Streep) por quatro dias na década de 1960.",
                "Drama romântico",LocalDate.of(1995,05,16),15000000.00,
                diretorFilme, elenco);
        Diretor diretorFilme1 = new Diretor("Christopher Nolan",true);
        ArrayList<Ator> elenco1 = new ArrayList<>();
        for (Ator item : listaAtores) {
            if (item.getNome().equals("Matthew McConaughey"))
                elenco1.add (item);
        }
        for (Ator item : listaAtores) {
            if (item.getNome().equals("Anne Hathaway"))
                elenco1.add (item);
        }
        for (Ator item : listaAtores) {
            if (item.getNome().equals("Jessica Chastain"))
                elenco1.add (item);
        }
                Filme filme1 = new Filme("Interestelar","Uma equipe de exploradores viaja através de um buraco" +
                "de minhoca no espaço, na tentativa de garantir a sobrevivência da humanidade.","Aventura, Ficção Científica",
                LocalDate.of(2014,07,15),1000000.00,diretorFilme1,elenco1) ;


        // @Gerson start --------------------
        listaFilmes.add(filme);
        listaFilmes.add(filme1);

        System.out.print("\n\n === LISTA FILMES === \n");
        for (Filme item : listaFilmes) {
            System.out.println(item.toString());
        }
        // @Gerson --------------------finish


    }

    public static void testPessoa() {
        ArrayList<Diretor> diretores = new ArrayList<>();


    }

    /* Método para testar a funcionalidade da classe Ator.
       Todas as alterações devem ser incluídas aqui nesta
       fase do projeto.
    */
    public static void testAtor() {
        // Lista de filmes para cada ator
        ArrayList<String> filmes = new ArrayList<>(Arrays.asList("volvo", "BMW", "Ford", "Mazda"));

        // Instância da classe Elenco
        Elenco atores = new Elenco();

        // Adicionando atores ao elenco
        atores.setElenco ("Deyse", "27/02/1968", "Rio de Janeiro");
        atores.setElenco("Gustavo","10/11/1999","Nova Iguaçu");
        atores.setElenco("Clint Eastwood", "31/05/1930", "San Francisco");
        atores.setElenco("Merryl Streep","22/06/1949","Summit,New Jersey");
        atores.setElenco("Matthew McConaughey", "04/11/1969", "Texas");
        atores.setElenco("Anne Hathaway","12/11/1982","Brooklyn");
        atores.setElenco("Jessica Chastain","24/03/1977","Sacramento");

        // Obtendo a lista completa de atores e seus detalhes
        ArrayList<Ator> pessoas = atores.getElenco();
        for (Ator ator : pessoas) {
            ator.display();
        }

        // Obtendo os nomes dos atores no elenco
        ArrayList<String> nomes = atores.getAtores();
        System.out.println(nomes);

        // @Gerson start --------------------
        listaAtores.add(new Ator("Deyse", LocalDate.parse("1968-02-27"),
                "Rio de Janeiro",
                false));
        listaAtores.add(new Ator("Gustavo", LocalDate.parse("1999-11-10"),
                "Brasileira",
                false));
        listaAtores.add(new Ator("Clint Eastwood", LocalDate.parse("1930-05-31"),
                "Americano",
                false));
        listaAtores.add(new Ator("Merryl Streep", LocalDate.parse("1949-06-22"),
                "Americana",
                false));
        listaAtores.add(new Ator("Matthew McConaughey", LocalDate.parse("1969-11-04"),
                "Americano",
                false));
        listaAtores.add(new Ator("Anne Hathaway", LocalDate.parse("1982-11-12"),
                "Americana",
                false));
        listaAtores.add(new Ator("Jessica Chastain", LocalDate.parse("1977-03-24"),
                "Americana",
                false));

        System.out.print("\n\n === LISTA ATORES === \n");
        for (Ator item : listaAtores) {
            System.out.println(item.toString());
        }
        // @Gerson --------------------finish

    }

    /* Método para testar a funcionalidade da classe Diretor.
       Todas as alterações devem ser incluídas aqui nesta
       fase do projeto.
    */
    public static void testDiretor() {
        System.out.print("\n\n ===  Testa DIRETORES: criação objetos e impressão  ====\n");
        listaDiretores.add(new Diretor("Antoine Fuqua", false));
        listaDiretores.add(new Diretor("Elliott Lester", false));
        listaDiretores.add(new Diretor("Christopher Edward Nolan", LocalDate.parse("1970-07-30"), "London", false));

        System.out.print("\n\n === LISTA DIRETORES === \n");
        for (Diretor item : listaDiretores) {
            System.out.println(item.toString());
        }
    }

}
