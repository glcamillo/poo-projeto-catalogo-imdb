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

    // Estrutura de dados dos objetos do projeto
    private static ArrayList<Ator> listaAtores = new ArrayList<Ator>();
    private static ArrayList<Diretor> listaDiretores = new ArrayList<>();
    private static ArrayList<Filme> listaFilmes = new ArrayList<>();

    // Array de string de tipos de gêneros aceitos
    static final private String[] tiposGeneros = new String[]{"ACAO", "DRAMA",
            "SUSPENSE", "HUMOR", "COMEDIA_ROMANTICA", "GUERRA", "DOCUMENTARIO"};

    // Declarado e inicializado de forma estática na classe. Objetivo: resolver
    //   problemas de leitura.
    private static final Scanner leitor = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Projeto inicial para um sistema de IMDB");
        processarEntrada();
    }

    // ===========  Métodos Públicos para PROCESSAR ENTRADAS  ===========
    /*      +processarEntrada(void) : void
            +processarEntradaAtor(void) : void
            +processarEntradaDiretor() : void
            +processarEntradaFilme() : void
     */
    // Método para tratar entrada de dados (menu principal)
    static void processarEntrada() {

        System.out.println(" -------------------------------------------------------------------------");
        System.out.println("                         Projeto IMDB");
        System.out.println(" Sistema de cadastro e pesquisa de filmes, atores e diretores. Simula o IMDB.");
        System.out.println(" O menu possui escolhas para:");
        System.out.println("   a) Inclusão de ator, diretor e filmes.");
        System.out.println("   b) Pesquisas por ");
        System.out.println("    - nome de ator e nome de diretor: também retornam participação em filmes.");
        System.out.println("    - nome de filme: pode retornar mais de um (vide obs a seguir).");
        System.out.println("   c) Métodos para: teste de classes e inicialiazação com dados estáticos iniciais");
        System.out.println("    de atores, diretores e filmes para fins de popular bases de dados.");
        System.out.println(" -------------------------------------------------------------------------");
        System.out.println(" Observações importantes:");
        System.out.println("   a) Um mesmo nome pode se referir a diferentes FILMES. O sistema fará");
        System.out.println("     inclusão independente de demais dados serem iguais.");
        System.out.println("   b) Para sair de qualquer entrada de dados deve-se digitar SAIR.");
        System.out.println("   c) Para teste inicial pode-se iniciar pelas seleções 11, 12 e 13 que farão\n" +
                "         inicialização de dados estáticos para testes.");
        System.out.println(" -------------------------------------------------------------------------");

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
                    processarEntradaFilme();
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
                    imprimirListaAtores();
                    break;
                case "8":
                    imprimirListaDiretores();
                    break;
                case "9":
                    imprimirListaFilmes();
                    break;
                case "10":
                    imprimirListaAtores();
                    imprimirListaDiretores();
                    imprimirListaFilmes();
                    break;
                case "11":
                    testarAtor();
                    break;
                case "12":
                    testarDiretor();
                    break;
                case "13":
                    testarFilme();
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
        System.out.print("\n === Entrada de ATORES (digitar SAIR para terminar) === \n");
        boolean repete = true;
        do {
            System.out.print("Qual nome do Ator / Atriz? ");
            String linhaNomeAtor = leitor.nextLine();
            if (linhaNomeAtor.equalsIgnoreCase("sair"))
                repete = false;
            else {
                ator = pesquisarAtor(linhaNomeAtor);
                if (ator == null) {
                    System.out.printf("\nAtor/Atriz de nome %s não existe. Será incluído. Incluir demais atributos:\n", linhaNomeAtor);

                    ator = incluirAtor(linhaNomeAtor);
                    if (ator == null) {
                        System.err.println("Objeto ator não criado");
                    } else {
                        System.out.println("Cadastro realizado!!!");
                        System.out.printf("\n%s\n", ator.toString());
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
    private static Ator incluirAtor(String nomeAtor) {
        Ator ator = null;
        LocalDate nascimento = null;
        String naturalidade = null;
        try {
            nascimento = lerData("nascimento");
        } catch (java.text.ParseException e) {
        }
        try {
            naturalidade = lerLocal("nascimento");
        }catch (java.text.ParseException e){
            System.out.println("ERRO");
        }
        try{
            ator = new Ator(nomeAtor, nascimento, naturalidade, false);
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
        System.out.print("\n === Entrada de DIRETORES (digitar SAIR para terminar) === \n");
        boolean repete = true;
        do {
            System.out.print("\nQual nome de Diretor? ");
            String linhaNomeDiretor = leitor.nextLine();
            if (linhaNomeDiretor.equalsIgnoreCase("sair"))
                repete = false;
            else {
                diretor = pesquisarDiretor(linhaNomeDiretor);
                if (diretor == null) {
                    System.out.printf("\nDiretor de nome %s não existe. Será incluído. Incluir demais atributos:\n", linhaNomeDiretor);
                    diretor = incluirDiretor(linhaNomeDiretor);
                    if (diretor == null) {
                        System.err.println("Objeto diretor não criado");
                    } else {
                        System.out.println("Cadastro realizado!!!");
                        System.out.printf("\n%s\n", diretor.toString());
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


    /* Método para processar entrada do usuário para FILME.  Serão solicitadas
        diversas informações para compor os atributos de um Filme. Ao final
        será o objeto Filme com os atributos. Caso algum atribute falte ou
        dê erro na entrada, o objeto será criado com valor contendo null.
     */
    static void processarEntradaFilme() {
        Filme filme = null;
        Diretor diretor = null;

        System.out.print("\n === Entrada de FILMES (digitar SAIR para terminar) === \n");
        boolean repete = true;
        String filmeNome = new String();
        System.out.print("\nEntre com o nome do Filme: ");
        filmeNome = leitor.nextLine();
        while (repete) {
            if (filmeNome.equalsIgnoreCase("sair")) {
                repete = false;
                break;
            } else {
                // Aqui, diferente de Ator e Diretor, vários filmes podem ter o mesmo nome
                System.out.print("\nEntre com uma descrição do Filme: ");
                String filmeDescricao = leitor.nextLine();
                String filmeGenero = processarEntradaGenero();

                // Leitura da Data de Lançamento
                LocalDate filmeDataLancamento = null;
                try {
                    filmeDataLancamento = lerData("data de lançamento");
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }

                // Leitura do Orçamento
                Double filmeOrcamento = 1.0;
                System.out.print("Qual ORÇAMENTO do Filme? ");
                filmeOrcamento = leitor.nextDouble();

                // Leitura do Diretor: um único por Filme
                diretor = null;
                System.out.print("\n--- Menu de DIRETOR(A) para Filme");
                System.out.printf("\n -1   Para INCLUIR novo DIRETOR");
                System.out.printf("\n  0   Para SAIR (para filme sem diretor)");
                System.out.print("\nE lista de escolha DIRETORES já no sistema:");

                boolean continuarDiretor = true;
                do {
                    int i = 1;
                    int itemDiretorInt = 0;
                    for (Diretor item : listaDiretores) {
                        System.out.printf("\n  %d - %s", i++, item.getNome());
                    }
                    System.out.print("\nEntre com o número do(a) diretor(a). (0) termina. (-1) inclui novo: ");
                    itemDiretorInt = leitor.nextInt();
                    if (itemDiretorInt == 0)
                        continuarDiretor = false;
                    else if (itemDiretorInt < -1 || itemDiretorInt > i) {
                        System.out.println("Número inválido. Entre novamente ou SAIR.");
                    } else if (itemDiretorInt == -1) {
                        System.out.print("\nQual nome do Diretor a incluir? ");
                        String novoNomeDiretor = leitor.nextLine();
                        novoNomeDiretor = leitor.nextLine();
                        diretor = incluirDiretor(novoNomeDiretor);
                    } else {
                        // O array inicia com ZERO e o primeiro da lista é um
                        diretor = listaDiretores.get(itemDiretorInt-1);
                        continuarDiretor = false;
                    }
                } while (continuarDiretor);

                // Leitura do Elenco do Filme: entrada de objetos Ator
                ArrayList<Ator> elenco = new ArrayList<>();
                Ator ator = null;
                System.out.print("\n--- Menu de ATORES/ATRIZES para Filme");
                System.out.printf("\n -1   Para INCLUIR novo ATOR/ATRIZ");
                System.out.printf("\n  0   Para SAIR da inclusão do elenco");
                System.out.print("\nE lista de escolha ATORES já no sistema:");

                boolean continuarAtor = true;
                do {
                    int j = 1;
                    for (Ator item : listaAtores) {
                        System.out.printf("\n  %d - %s", j++, item.getNome());
                    }
                    int itemAtorInt = 0;
                    System.out.print("\nQual número de ator/atriz. (0) termina. (-1) inclui novo: ");
                    itemAtorInt = leitor.nextInt();
                    if (itemAtorInt == 0)
                        continuarAtor = false;
                    else if (itemAtorInt < -1 || itemAtorInt > j) {
                        System.out.println("Número inválido. Entre novamente ou SAIR.");
                    } else if (itemAtorInt == -1) {
                        System.out.print("\nQual nome do Ator/Atriz a incluir? ");
                        String novoNomeAtor = leitor.nextLine();
                        novoNomeAtor = leitor.nextLine();
                        ator = incluirAtor(novoNomeAtor);
                    } else
                        // O array inicia com ZERO e o primeiro da lista é um
                        elenco.add(listaAtores.get(itemAtorInt - 1));
                } while (continuarAtor);

                // Cria objeto Filme com os dados do usuário
                // TODO incluir try-catch
                Filme novoFilme = new Filme(filmeNome, filmeDescricao, filmeGenero, filmeDataLancamento, filmeOrcamento, diretor, elenco);
                listaFilmes.add(novoFilme);
                System.out.print("\nFilme incluído com sucesso:\n");
                System.out.printf("%s", novoFilme.toString());
                if (diretor != null)
                    diretor.setDiretorEmFilme(true);
                if ( ! elenco.isEmpty())
                    for (Ator item: elenco)
                        item.setAtorEmFilme(true);
            }
            System.out.print("\n\nEntre com o nome do filme ou 'sair' para terminar inclusão filmes: ");
            filmeNome = leitor.nextLine();
            filmeNome = leitor.nextLine();
        }
    }

    private static String processarEntradaGenero() {
        // Scanner leitor = new Scanner(System.in);
        System.out.println("Considere os seguintes gêneros de filme: ");
        System.out.printf("%s\n", Arrays.toString(tiposGeneros));
        System.out.print("Escolha qual GÊNERO do filme: ");
        String genero = leitor.nextLine();
        for (String item : tiposGeneros) {
            if (item.equalsIgnoreCase(genero))
                return item;
        }
        return null;
    }

    private static LocalDate lerData(String mensagem) throws ParseException {
        String dateFormat = "yyy-MM-dd";
        boolean pular = false;
        System.out.printf("Qual data (ano-mês-dia) de %s (formato numérico:yyyy-mm-dd)? ", mensagem);
        do {
            try {
                String dataLidaEntrada = leitor.nextLine();
                return LocalDate.parse(dataLidaEntrada);
            } catch (Exception e) {
                System.out.println("Formato de data inválido.");
                System.out.println("Insira novamente ou pule(Enter):");
                String chave = leitor.nextLine();
                if (chave.isEmpty()) {
                    pular = true;
                    return null;
                } else {
                    return LocalDate.parse(chave);
                }
            }
        }while (pular);
    }
    private static String lerLocal(String mensagem) throws ParseException {
        boolean pular = false;
        System.out.printf("Qual local de %s (Cidade)? ", mensagem);
        do {
            String localEntrada = leitor.nextLine();
            if(localEntrada.isEmpty()) {
                System.out.println("Local não informado.");
                System.out.println("Insira novamente ou pule(Enter):");
                String chave = leitor.nextLine();
                if (chave.isEmpty()) {
                    pular = true;
                    return null;
                } else {
                    return chave;
                }
            }else{
                return localEntrada;
            }
        }while (pular);
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
    static void pesquisarAtores() {
        String chave = "";
        boolean encontrou = false;
        boolean repete = true;
        Scanner entrada = new Scanner(System.in);
        do {
            System.out.print("\nQual nome de Ator você deseja buscar? ");
            chave = entrada.nextLine();
            System.out.println("Nome buscado: " + chave);
            for (Ator ator : listaAtores) {
                if (ator.getNomeAtor().toLowerCase().contains(chave.toLowerCase())) {
                    System.out.println(ator.toString());
                    System.out.println("");
                    for (Filme item1 : listaFilmes ) {
                        String item1String = item1.toString();
                        if (item1String.contains(ator.getNomeAtor())) {
                            System.out.println("Filmes que atuou: " + item1.getNomeFilme());
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
        do {
            System.out.print("\nQual nome de Diretor você deseja buscar?");
            chave = leitor.nextLine();
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
        boolean repete = true, achou = false;
        do {
            System.out.print("\nQual nome do Filme a pesquisar ou 'sair' para terminar? ");
            String filmeNome = leitor.nextLine();
            if (filmeNome.equalsIgnoreCase("sair"))
                repete = false;
            else {
                achou = false;
                for (Filme item : listaFilmes) {
                    if (item.getNomeFilme().toLowerCase().contains(filmeNome.toLowerCase())) {
                        System.out.println("Nome Filme: " + item.getNomeFilme());
                        System.out.println("Ano de Lançamento: " + item.getDataLancamento());
                        System.out.println("Descrição: " + item.getDescricaoFilme());
                        System.out.println("Gênero: " + item.getGenero());
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

    static void imprimirListaAtores() {
        System.out.print("\n\n === LISTA ATORES === \n");
        for (Ator ator : listaAtores)
            System.out.println(ator.toString());
    }

    static void imprimirListaDiretores() {
        System.out.print("\n\n === LISTA DIRETORES === \n");
        for (Diretor item : listaDiretores)
            System.out.println(item.toString());
    }

    static void imprimirListaFilmes() {
        System.out.print("\n\n === LISTA FILMES === \n");

        for (Filme item : listaFilmes) {
            System.out.println(item.toString());
        }
    }


    // ==== Métodos Públicos para TESTES INTERNOS e inclusão de dados estáticos   ===========

    public static void testarFilme() {
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

        Filme filme = new Filme("As pontes de Madison","O fotógrafo Robert Kincaid vagou" +
                " pela vida da dona de casa Francesca Johnson por quatro dias na década de 1960.",
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
        Filme filme1 = new Filme("Interestelar","Equipe de exploradores viaja através de um buraco" +
                ", na tentativa de garantir a sobrevivência da humanidade.","Aventura, Ficção Científica",
                LocalDate.of(2014,07,15),1000000.00,diretorFilme1,elenco1) ;

        listaFilmes.add(filme);
        listaFilmes.add(filme1);
        diretorFilme.setDiretorEmFilme(true);
        diretorFilme1.setDiretorEmFilme(true);
        for (Ator item: elenco) {
            item.setAtorEmFilme(true);
        }
        for (Ator item: elenco1) {
            item.setAtorEmFilme(true);
        }

        System.out.print("\n ===  Testa classe Filme: criação objetos e impressão  ====\n");
        System.out.print(" ===           LISTA FILMES          === \n");
        for (Filme item : listaFilmes) {
            System.out.println(item.toString());
        }
    }


    public static void testarAtor() {
        listaAtores.add(new Ator("Deyse", LocalDate.parse("1968-02-27"),
                "Rio de Janeiro",
                false));
        listaAtores.add(new Ator("Gustavo", LocalDate.parse("1999-11-10"),
                "Mova Iguaçu",
                false));
        listaAtores.add(new Ator("Clint Eastwood", LocalDate.parse("1930-05-31"),
                "Texas",false));
        listaAtores.add(new Ator("Merryl Streep", LocalDate.parse("1949-06-22"),
                "Los Angeles",
                false));
        listaAtores.add(new Ator("Matthew McConaughey", LocalDate.parse("1969-11-04"),
                "São Paulo",
                false));
        listaAtores.add(new Ator("Anne Hathaway", LocalDate.parse("1982-11-12"),
                "Nova York",
                false));
        listaAtores.add(new Ator("Jessica Chastain", LocalDate.parse("1977-03-24"),
                "Sacramento",
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
    public static void testarDiretor() {
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