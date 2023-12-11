import adatech.poo.imdb.Diretor;

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
        //Tetsa classe Ator
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
