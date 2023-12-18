package adatech.poo.imdb;

public class Diretor {
    private String nomeDiretor;

    public Diretor(String nomeDiretor){
        this.nomeDiretor = nomeDiretor;
    }
    public String getNomeDiretor(){
        return this.nomeDiretor;
    }

    @Override
    public String toString() {
        return "Diretor{" +
                "nomeDiretor='" + nomeDiretor + '\'' +
                '}';
    }
}
