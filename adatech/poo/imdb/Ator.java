import java.util.Arrays;
//Ator.class
public class Ator {
    //private final int NUM_ATORES = 100;
    private String nome;
    private String dataNascimento;
    private String localNascimento;
    private String[] filmes;
    private String[] ficha = new String[4];


    public Ator(String nome, String dataNascimento, String localNascimento, String[] filmes) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.localNascimento = localNascimento;
        this.filmes = filmes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getLocalNascimento() {
        return localNascimento;
    }

    public void setLocalNascimento(String localNascimento) {
        this.localNascimento = localNascimento;
    }

    public String[] getFilmes() {
        return filmes;
    }

    public void setFilmes(String filmes[]) {
        this.filmes = filmes;
    }

    public String[] getFicha(){
        this.ficha[0] = this.nome;
        this.ficha[1] = this.dataNascimento;
        this.ficha[2] = this.localNascimento;
        this.ficha[3] = Arrays.toString(this.filmes);
        return ficha;
    }
    public void display() {
        System.out.println("O ator: " + nome + " nasceu em " + dataNascimento + " em " + localNascimento +
                " e fez os filmes: " + Arrays.toString(filmes));
        System.out.println("Ficha:" + Arrays.toString(getFicha()));
    }
}
//public class Elenco{
//Ator[] elenco;
//elenco = new Ator[5];
//}
/*
class Main{
    public static void main(String[] args) {
        Ator[] elenco;
        elenco = new Ator[5];
        String[] filmes = {"volvo", "BMW", "Ford", "Mazda"};
        elenco[0] = new Ator("Gustavo","10/11/1999","Nova Iguaçu",filmes);
        elenco[0].display();
        elenco[1] = new Ator("Deyse","27/02/1968","Rio de Janeiro",filmes);
        elenco[1].display();

    }
}*/
