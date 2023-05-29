package devandroid.nobrega.applistacliente.model;

// O Pacote Model apresenta(m) classe(s) para Dados.
//    OBS: CamelCase , pascalCase
// OBS2: As classes dos pacotes model, view e controller não fazem parte, nativamente, do
// SDK do Android.

// OBS: Na aula 36, Seção 4, o prof. fala sobre classe Pojo. Ou seja, uma classe que apresenta
// apenas, atributo(s), método(s) construtor(es) e método(s) geter(rs) e setter(rs). Neste caso,
// a classe Pessoa é uma classe Pojo.

public class Pessoa {

    private String primeiroNome; // Atributo. Com o modificador de acesso ( private ). Atalho: Esteja na linha do
    // atributo declarado. Nela, segure a tecla ctrl e pressione a tecla D. Vai duplicar o código para a linha abaixo.
    private String sobreNome;
    private String cursoDesejado, telefoneContato;

    public Pessoa(){ // Construtor da classe Pessoa. Sem Parâmetros.

    }

    // Abaixo, temos os métodos getters e setters. O primeiro serve para recuperar uma informação, enquanto que
    // o segundo serve para alterar informação.

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public String getCursoDesejado() {
        return cursoDesejado;
    }

    public void setCursoDesejado(String cursoDesejado) {
        this.cursoDesejado = cursoDesejado;
    }

    public String getTelefoneContato() {
        return telefoneContato;
    }

    public void setTelefoneContato(String telefoneContato) {
        this.telefoneContato = telefoneContato;
    }

    // Abaixo, temos o método toString.
    // Atalho: Digite @tost (Vai aparecer uma sugestão de método toString. Clique nela. Vai aparecer
    // uma pequena janela, com atributos da classe Pessoa, que podem ser exibidos no toString. Você
    // pode escolher ou não qual(is) deve(m) ser exibido(s). Depois, clique em OK.

    @Override  // Isto é uma anotação, de sobrescrita. Neste caso, estamos sobrescrevendo o método toString.
    public String toString() {
        return "Pessoa{" +
                "primeiroNome='" + primeiroNome + '\'' +
                ", sobreNome='" + sobreNome + '\'' +
                ", cursoDesejado='" + cursoDesejado + '\'' +
                ", telefoneContato='" + telefoneContato + '\'' +
                '}';
    }

}
