## PROJETO FINAL - CATÁLOGO DE FILMES - IMDb


## Disciplina: Programação Orientada a Objetos I - Curso: Ser + Tech Programa 50+ (Turma #1076)
### Professor: Rodolfo Ferreira de Lima
### Grupo 03 
- **Deyse Ribeiro** 
- **Dirce Mitiko Taira**
- **Gerson Camillo**
- **Teofilo Nicolau**

<img src="./rolodefilme.png" alt="Rolo de filme">

### DESCRIÇÃO DO PROJETO:
Este projeto tem como objetivo principal desenvolver um sistema que apresente um catálogo de filmes, similar ao Internet Movie Database (IMDb).


Cada um dos filmes catalogados, deverá possuir alguns atributos, tais como: nome, data de lançamento, orçamento e descrição.

Assim como também, apresentar um diretor, uma lista de atores que trabalharam no filme. 
E adicionar atributos para as pessoas. 

<br/>
<br/>
Implementar uma aplicação em que o usuário possa:

-> cadastrar filmes;

-> cadastrar atores;

-> associar um filme com seus atores e diretores;

-> permitir pesquisar filmes cadastrados pelo nome, desconsiderando letras maiúsculas e minúsculas.


<br/>
<br/>
**OBSERVAÇÕES**:

 - É necessário que se utilize os conceitos de programação orientada a objetos vistos nas aulas: como encapsulamento, herança, polimorfismos e classes abstratas.
 - O projeto será desenvolvido em grupos de até 4 integrantes
 - A entrega será feita via repositório GIT. 
 - A avaliação será feita considerando os commits individuais, portanto é importante que todos colaborem no desenvolvimento do projeto.


<img src="./FOTOFILME1.png" alt="Película de filme">

## Diagrama de classes básico do projeto
Uma prévia das classes.

```mermaid
classDiagram
    Pessoa <|-- Diretor
    Pessoa <|-- Ator
    Pessoa : +String nomeCompleto
    Pessoa : -DateTime dataNascimento
    Pessoa : -String sexo
    Pessoa : -String nacionalidade
    Pessoa: +obtemDataNascimento()
    Pessoa: +obtemSexto()
    Pessoa: +obtemNacionalidade()
    class Diretor{
      +Filme[] filmes
      +obtemFilmes()
      Diretor(String nomeCompleto, DateTime nascimento, String sexo, String nacionalidade)
    }
    class Ator{
      -int (static) numeroParticipacaoFilmes
      -Filme[] participacaoFilmes
      Ator(String nomeCompleto, DateTime nascimento, String sexo, Filme filme)
      +obtemParticipacaoFilmes()
    }
    class Filme{
      +String nomeFilme
      -String genero
      -DateTime dataLancamento
      -Ator[5] atores
      Filme(String nomeFilme, String genero, DateTime datalanc, Ator[] atores)
      +obtemGenero()
      +obtemDataLancamento()
      +obtemAtores()
    }

```
