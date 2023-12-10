package adatech.poo.imdb;

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
