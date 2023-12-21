package adatech.poo.imdb;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
    Classe controller para o projeto IMDB.
    Objetivos:
     - catalogar filmes, atores e diretores
     - permitir pesquisas parametrizadas

    Modelagem através das classes:
     Pessoa: classe abstrata com atributos para pessoa
     Ator: estende Pessoa e inclui atributo de participação em filme
     Diretor: estende Pessoa e inclui atributo de participação em filme
     Filme: além de atributos específicos, contém:
       - atributo diretor: para objeto Diretor
       - atributo elenco: ArrayList para objetos Ator

    Modelagem de dados: uma ArrayList para cada tipo de objeto:
       -listaAtores : ArrayList<Ator>
      -listaDiretores : ArrayList<Diretor>
      -listaFilmes : ArrayList<Filme>

    O menu permite acesso a método para teste básico das classes bases
      e permite popular os ArrayList com dados para teste do programa.

    Descrição mais detalhada no README.md que acompanha este projeto.

    Sítio do projeto: https://github.com/glcamillo/poo-projeto-catalogo-imdb
    Participantes: Deyse Ribeiro, Dirce Mitiko Taira, Gerson Luiz Camillo
 */

public class IMDB {

    private static ArrayList<Ator> listaAtores = new ArrayList<Ator>();
    private static ArrayList<Diretor> listaDiretores = new ArrayList<>();
    private static ArrayList<Filme> listaFilmes = new ArrayList<>();

    // Array de string de tipos de gêneros aceitos
    static final private String[] tiposGeneros = new String[]{"ACAO", "DRAMA", "SUSPENSE", "HUMOR", "COMEDIA_ROMANTICA", "GUERRA", "DOCUMENTARIO"};


    public static void main(String[] args) {
        System.out.println("Projeto inicial para um sistema de IMDB");
        processaEntrada();
    }

    // ===========  Métodos Públicos para PROCESSAR ENTRADAS  ===========
    /*      +processarEntrada(void) : void
            +processarEntradaAtor(void) : void
            +processarEntradaDiretor() : void
            +processarEntradaFilme() : void
     */
    // Método para tratar entrada de dados (menu principal)
    static void processaEntrada() {

        System.out.println(" ---------------------------------------------------------");
        System.out.println("                    Projeto IMDB                    ");
        System.out.println(" Simula sistema de cadastro e pesquisa de filmes, atores ");
        System.out.println("  e diretores. Menu para inclusão de ator, diretor e filmes.");
        System.out.println(" Pesquisas por ");
        System.out.println("    a) nome de ator e nome de diretor: também retornam participação em filmes.");
        System.out.println("    b) nome de filme: pode retornar mais de um (vide obs a seguir).");
        System.out.println(" Métodos para testar as classes e que também incluem de forma estática dados");
        System.out.println("    de atores, diretores e filmes para fins de popular bases de dados.");
        System.out.println(" -------------------------------------------------------------------------");
        System.out.println(" Obs importantes: a) um mesmo nome pode se referir a diferentes filmes (sistema");
        System.out.println("     fará inclusão independente de demais dados serem iguais ou diferentes.");
        System.out.println("     b) para sair de qualquer entrada de dados deve-se digitar SAIR.");

        Scanner leitor = new Scanner(System.in);
        boolean continuar = true;
        do {
            System.out.printf("\n\n ======= Menu IMDB =======\n");
            System.out.println(" --> Entrada de dados:");
            System.out.println(" 1. Incluir Ator");
            System.out.println(" 2. Incluir Diretor");
            System.out.println(" 3. Incluir Filme");
            System.out.println(" --> Pesquisas:");
            System.out.println(" 4. Pesquisar Ator ");
            System.out.println(" 5. Pesquisar Diretor");
            System.out.println(" 6. Pesquisar por Filme");
            System.out.println(" --> Impressão:");
            System.out.println(" 7. Imprimir Lista Atores");
            System.out.println(" 8. Imprimir Lista Diretores");
            System.out.println(" 9. Imprimir Lista Filmes");
            System.out.println(" 10. Imprimir todas as listas");
            System.out.println(" --> Inicialização dados e teste classes:");
            System.out.println(" 11. Classe Ator");
            System.out.println(" 12. Classe Diretor");
            System.out.println(" 13. Classe Filme");
            System.out.println(" (S)AIR: para terminar o programa");
            System.out.print(" Qual opção: ");
            String linhaOpcao = leitor.nextLine();
            switch (linhaOpcao.toLowerCase()) {
                case "1":
                    processarEntradaAtor();
                    break;
                case "2":
                    processarEntradaDiretor();
                    break;
                case "3":
                    processaEntradaFilme();
                    break;
                case "4":
                    pesquisarAtores();
                    break;
                case "5":
                    pesquisarDiretores();
                    break;
                case "6":
                    pesquisarFilmes();
                    break;
                case "7":
                    imprimeListaAtores();
                    break;
                case "8":
                    imprimeListaDiretores();
                    break;
                case "9":
                    imprimeListaFilmes();
                    break;
                case "10":
                    imprimeListaAtores();
                    imprimeListaDiretores();
                    imprimeListaFilmes();
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
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        } while(continuar);
    }

    static void processarEntradaAtor() {
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
                    repete = false;
                } else if (ator != null) {
                    System.out.printf("\nAtor/Atriz já está cadastrado!");
                    repete = false;
                }
            }
        } while (repete);
    }
    // ===========  Método Privado INCLUSÃO Ator ===========
    /* Se inclusão bem sucedida, retorna referência ao objeto criado;
           caso contrário, null.
        -incluirAtor(nomeAtor : String) : Ator
     */
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
            System.out.print("\nQual nome de Diretor? ");
            String linhaNomeDiretor = leitor.nextLine();
            if (linhaNomeDiretor.equalsIgnoreCase("sair"))
                repete = false;
            else {
                diretor = pesquisarDiretor(linhaNomeDiretor);
                if (diretor == null) {
                    System.out.printf("\nDiretor de nome %s não existe. Será incluído. Responda com demais atributos:\n", linhaNomeDiretor);
                    diretor = incluirDiretor(linhaNomeDiretor);
                    if (diretor == null) {
                        System.err.println("Objeto diretor não criado");
                    }
                }
            }
        } while (repete);
    }
    // ===========  Método Privado INCLUSÃO Diretor ===========
    /* Se inclusão bem sucedida, retorna referência ao objeto criado;
           caso contrário, null.
        -incluirDiretor(nomeDiretor: String) : Diretor
     */
    private static Diretor incluirDiretor(String nomeDiretor) {
        LocalDate dataNascimento= null;
        try {
            dataNascimento = lerData("nascimento");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        String naturalidade = null;
        System.out.print("Qual local de nascimento do Diretor? ");
        Scanner leitor = new Scanner(System.in);
        naturalidade = leitor.nextLine();

        Diretor diretor = null;
        try {
            diretor = new Diretor(nomeDiretor, dataNascimento, naturalidade, false);
            listaDiretores.add(diretor);
        } catch (RuntimeException e) {
            System.err.println("Erro na criação objeto Diretor");
        }
        return diretor;
    }


    static void processaEntradaFilme() {
        Filme filme = null;
        Diretor diretor = null;

        Scanner leitor = new Scanner(System.in);

        System.out.println(" === Entrada de FILMES (digitar SAIR para terminar) === ");
        boolean repete = true;
        do {
            System.out.print("Qual NOME de Filme? ");
            String filmeNome = leitor.next();
            if (filmeNome.equalsIgnoreCase("sair"))
                repete = false;
            else {

                // Aqui, diferente de Ator e Diretor, vários filmes podem ter o mesmo nome
                System.out.print("Qual DESCRIÇÃO para o Filme? ");
                String filmeDescricao = leitor.nextLine();
                String filmeGenero = processaEntradaGenero();

                LocalDate filmeDataLancamento = null;
                try {
                    filmeDataLancamento = lerData("data lançamento");
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }

                Double filmeOrcamento = 1.0;
                System.out.print("Qual ORÇAMENTO do Filme? ");
                filmeOrcamento = leitor.nextDouble();

                diretor = null;
                System.out.print("Qual o nome do DIRETOR do Filme? Escolha pelo número (-1 para INCLUIR NOVO):");
                int i = 0;
                for (Diretor item : listaDiretores) {
                    System.out.printf("\n %d - %s", i++, item.getNome());
                }
                boolean continuarDiretor = true;
                do {
                    System.out.print("\nQual número de diretor (-1 para incluir NOVO)? ");
                    // String itemDiretor = leitor.nextLine();
                    String itemDiretor = leitor.next();
                    if (itemDiretor.equalsIgnoreCase("sair")) {
                        continuarDiretor = false;
                    } else if (Integer.parseInt(itemDiretor) < -1 || Integer.parseInt(itemDiretor) >= i) {
                        System.out.println("Número inválido. Entre novamente ou SAIR.");
                    } else if (Integer.parseInt(itemDiretor) == -1) {
                        System.out.print("\nQual nome do Diretor a incluir? ");
                        String novoNomeDiretor = leitor.next();
                        diretor = incluirDiretor(novoNomeDiretor);
                    } else {
                        diretor = listaDiretores.get(Integer.parseInt(itemDiretor));
                        continuarDiretor = false;
                    }
                } while (continuarDiretor);

                ArrayList<Ator> elenco = new ArrayList<>();
                Ator ator = null;
                System.out.print("\nQuais ATORES participaram do Filme? Escolha pelo número (-1 para INCLUIR NOVO):");
                int j = 0;
                for (Ator item : listaAtores) {
                    System.out.printf("\n %d - %s", j++, item.getNome());
                }
                boolean continuarAtor = true;
                do {
                    System.out.print("\nQual número de ator (SAIR para terminar; -1 para incluir NOVO)? ");
                    String itemAtor = leitor.next();
                    if (itemAtor.equalsIgnoreCase("sair")) {
                        continuarAtor = false;
                    } else if (Integer.parseInt(itemAtor) < -1 || Integer.parseInt(itemAtor) >= j) {
                        System.out.println("Número inválido. Entre novamente ou SAIR.");
                    } else if (Integer.parseInt(itemAtor) == -1) {
                        System.out.print("\nQual nome do Ator  incluir? ");
                        String novoNomeAtor = leitor.next();
                        ator = incluirAtor(novoNomeAtor);
                        elenco.add(ator);
                    } else {
                        elenco.add(listaAtores.get(Integer.parseInt(itemAtor)));
                    }
                } while (continuarAtor);

                listaFilmes.add(new Filme(filmeNome, filmeDescricao, filmeGenero, filmeDataLancamento, filmeOrcamento, diretor, elenco));
            }
        } while (repete);
    }

    // ===========  Método Privado INCLUSÃO Filme ===========
    /* Se inclusão bem sucedida, retorna referência ao objeto criado;
           caso contrário, null.
        -incluirFilme(nomeFilme : String) : Filme
     */
    private static Filme incluirFilme(String nomeFilme) {
        Filme filme = null;
        return filme;
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

    public static LocalDate lerData(String mensagem) throws ParseException {
        String dateFormat = "yyy-MM-dd";
        System.out.printf("Qual data (ano-mês-dia) de %s (formato numérico:yyyy-mm-dd)? ", mensagem);
        try {
            Scanner leitor = new Scanner(System.in);
            String dataLidaEntrada = leitor.nextLine();
            // DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            return LocalDate.parse(dataLidaEntrada);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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

    static void pesquisarAtores() {
        String chave = "";
        boolean encontrou = false;
        boolean repete = true;
        Scanner entrada = new Scanner(System.in);
        do {
            System.out.println("Qual nome você deseja buscar?");
            chave = entrada.nextLine();
            System.out.println("Nome buscado: " + chave);
            for (Ator ator : listaAtores) {
                if (ator.getNomeAtor().toLowerCase().contains(chave.toLowerCase())) {
                    System.out.println(ator.toString());
                    System.out.println("");
                    for (Filme item : listaFilmes ) {
                        if (item.elenco.contains(ator.getNomeAtor())) {
                            System.out.println("Filmes que atuou: " + item.getNomeFilme());
                        }
                    }
                    encontrou = true;
                    repete = false;
                }
            }
            if (!encontrou) {
                System.out.println("Nenhum resultado encontrado para " + chave);
            }
            if(chave.toLowerCase().equals("sair")){
                repete = false;
            }
        }while (repete);
    }

    static Diretor pesquisarDiretor(String nomeDiretor) {
        for (Diretor item : listaDiretores) {
            if (item.getNomeDiretor().toLowerCase().equalsIgnoreCase(nomeDiretor))
                return item;
        }
        return null;
    }
    static void pesquisarDiretores () {
        String chave = "";
        boolean encontrou = false;
        boolean repete = true;
        Scanner entrada = new Scanner(System.in);
        do {
            System.out.println("Qual nome você deseja buscar?");
            chave = entrada.nextLine();
            System.out.println("Nome buscado: " + chave);
            for (Diretor diretor : listaDiretores) {
                if (diretor.getNomeDiretor().toLowerCase().contains(chave.toLowerCase())) {
                    System.out.println(diretor.toString());
                    System.out.println("");
                    encontrou = true;
                    for (Filme item : listaFilmes ) {
                        if (item.diretorFilme.getNomeDiretor().equals(diretor.getNomeDiretor())) {
                            System.out.println("Filmes que dirigiu: " + item.getNomeFilme());
                        }
                    }
                    repete = false;
                }
            }
            if (!encontrou) {
                System.out.println("Nenhum resultado encontrado para " + chave);
            }
            if(chave.toLowerCase().equals("sair")){
                repete = false;
            }
        }while (repete);
    }


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
                        System.out.println("Diretor: " + item.diretorFilme.getNomeDiretor());
                        System.out.print("Atores principais: ");
                        for (Ator ator : item.elenco) {
                            System.out.println(ator.getNomeAtor());
                        }
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

        for (Filme item : listaFilmes) {
            System.out.println(item.toString());
        }
    }


    // ==== Métodos Públicos para TESTES INTERNOS e inclusão de dados estáticos   ===========

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
        Diretor diretorFilme1 = new Diretor("Christopher Edward Nolan",true);
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

        listaFilmes.add(filme);
        listaFilmes.add(filme1);

        System.out.print("\n ===  Testa classe Filme: criação objetos e impressão  ====\n");
        System.out.print(" ===           LISTA FILMES          === \n");
        for (Filme item : listaFilmes) {
            System.out.println(item.toString());
        }
    }

    public static void testPessoa() {
        ArrayList<Diretor> diretores = new ArrayList<>();
    }

    public static void testAtor() {
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
        System.out.print("\n ===  Testa Classe Ator: criação objetos e impressão  ====\n");
        System.out.print(" ===           LISTA ATORES          === \n");
        for (Ator item : listaAtores) {
            System.out.println(item.toString());
        }
    }

    /* Método para testar a funcionalidade da classe Diretor.
       Todas as alterações devem ser incluídas aqui nesta
       fase do projeto.
    */
    public static void testDiretor() {
        System.out.print("\n ===  Testa classe Diretor: criação objetos e impressão  ====\n");
        listaDiretores.add(new Diretor("Antoine Fuqua", false));
        listaDiretores.add(new Diretor("Elliott Lester", false));
        listaDiretores.add(new Diretor("Christopher Edward Nolan", LocalDate.parse("1970-07-30"), "London", false));
        listaDiretores.add(new Diretor("Clint Eastwood", LocalDate.parse("1930-06-30"), "Sacramento", false));
        System.out.print(" ===           LISTA DIRETORES          === \n");
        for (Diretor item : listaDiretores) {
            System.out.println(item.toString());
        }
    }

}


