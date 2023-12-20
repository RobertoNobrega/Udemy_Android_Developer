package devandroid.robertonobrega.applistacurso.model;

// Aula 29, Seção 4: Paradigma de Programação Orientada a Objetos. Nesta aula, começa a ensinar a implementar
// a classe Pessoa.
// Aula 30, Seção 4: Paradigma de Programação Orientada a Objetos. Atributo/Método.
public class Pessoa{

    private String primeiroNome; // Atributo da classe Pessoa, de tipo String, modificador de acesso private,
    // chamado primeiroNome. Atalho: Após o ponto e vírgula, segure a tecla Ctrl, seguido da tecla D. Irá
    // realizar, na linha seguinte, uma cópia do conteúdo da linha atual.
    private String sobreNome; // Atributo.
    private String cursoDesejado, telefoneContato; // Atributos. OBS: Numa mesma linha, é possível declarar
    // mais de um atributo de um mesmo tipo de dado.

    public Pessoa(){ /* Método Construtor da classe Pessoa. OBS: Não é preciso criálo, pois ele é
                        definido por 'default' (ele ficará 'invisível na classe Pessoa'). */

    }

    // Abaixo, teremos os métodos set e get.  Atalho: Clique com o botão direito do mouse. Escolha a opção
    // Generate. Para gerar os métodos set e get, escolha a opção Getter and Setter. Depois, marque o(s)
    // atributo(s) para gerar os métodos correspondentes.

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;  // Na aula 31, da Seção 4, o prof chega a usar o Modo Debug desta linha.
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
}
