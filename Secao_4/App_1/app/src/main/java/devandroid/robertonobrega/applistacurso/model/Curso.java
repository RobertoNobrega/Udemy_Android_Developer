package devandroid.robertonobrega.applistacurso.model;

public class Curso{
    // Aula 47, Seção 6.
    private String nomeDoCursoDesejado;

    public Curso(String nomeDoCursoDesejado){ // Construtor da classe Curso. Recebe apenas um argumento, do tipo String.
        this.nomeDoCursoDesejado = nomeDoCursoDesejado;
    }

    public String getNomeDoCursoDesejado() {
        return nomeDoCursoDesejado;
    }

    public void setNomeDoCursoDesejado(String nomeDoCursoDesejado) {
        this.nomeDoCursoDesejado = nomeDoCursoDesejado;
    }
}
