package devandroid.robertonobrega.applistacurso.view; // OBS: devandroid é o "nome da sua organização,
// empresa". robertonobrega é o nome do Desenvolvedor. applistacurso é o nome do Aplicativo que está
// sendo desenvolvido. view é o nome do pacote.

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import devandroid.robertonobrega.applistacurso.R;
import devandroid.robertonobrega.applistacurso.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    // OBS: As novas versões do AndroidStudio ( para o Sistema Operacional Linux ), de 2021 para
    // diante, possuem o Java, de forma embutida.

    /*
        Aula 21, Seção 4: O prof. informa que a pasta ( onde está o arquivo MainActivity.java )
        será a que trabalharemos muito. As outras duas pastas ( dentro da pasta java ), trata-se
        para uso em testes (obs: o prof, neste momento, excluiu essas pastas, por não ser úteis
        para este início de programação; porém são importantes para desenvolvimentos "grandes").
        Na pasta drawable, vai possuir imagens do App (OBS: ic_launcher_foreground.xml (v24), é para
        API 24).
        Na pasta xml, tem dois arquivos. Neles, podemos fornecer mais permissões ao App.

        Aula 25, Seção 4
          Dentro do SDK do Android, temos diversos Padrões de Projeto de Software.
          Nesta aula, será ensinada o padrão MVC (Model View Controller). No contexto
          de desenvolvimento Mobile, cada letra será um pacote. OBS: Esse padrão é indicado
          para quem está iniciando na carreira de desenvolvedor.

        Aula 28, Seção 4:  OBS: O prof. ensina a resolver "pequeno" bug nos campos de Layout, identificados
        pelo Emulador.

        Aula 29, Seção 4: Paradigma de Programação Oriantada a Objetos.
        Aula 30, Seção 4: Paradigma de Programação Oriantada a Objetos. Método e Atributo.
    */

    Pessoa pessoa; // Definindo um objeto da classe Pessoa. Até esse ponto, o objeto não está instanciado. Atalho: Após
    // inserir o nome da classe (no caso, Pessoa), segure a tecla Ctrl e em seguida tecle a tecla de Espaço em Branco. Re-
    // sultado: O AndroidStudio irá completar, automaticamente, o nome do objeto da classe.
    Pessoa outraPessoa;
    String dadosPessoa, dadosOutraPessoa;  // OBS: Objetos declarados na aula 32, da seção 4.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Aula 25, Seção 4. Nesta linha, informa que a tela
        // do app a ser aberta ( ao iniciar o app ) é a tela activity_main ( essa activity_main é uma
        // tela do XML ). OBS: Atalho: Ao selecionar o nome da tela do XML (nesse caso, activity_main),
        // ao segurar a tecla Ctrl , clique em seguida a tecla B. Vai abrir a tela do XML.
        pessoa = new Pessoa(); // Objeto pessoa foi instanciado.
        pessoa.setPrimeiroNome("Roberto"); // Chamando o método setPrimeiroNome. Nele, estará preenchendo um valor para o atributo
        // private, chamado primeiroNome.
        pessoa.setSobreNome("Nóbrega");
        pessoa.setCursoDesejado("Android Developer");
        pessoa.setTelefoneContato("(83)9888-888");

        outraPessoa = new Pessoa();
        outraPessoa.setPrimeiroNome("Luiz");
        outraPessoa.setSobreNome("Alves");
        outraPessoa.setCursoDesejado("Java");
        outraPessoa.setTelefoneContato("(83)9888-876");
        // int parada = 0; // Aula 31, Seção 4. Esta variável será uasada como 'parada', por meio do uso do Modo Debug.
        // Para usar o modo Debug, escolha a linha de código, que será usada a ser analisada. Escolhida, aponte o cur-
        // sor do mouse no número da linha e clique em cima do mesmo. Irá aparecer uma 'bolinha vermelha'. OBS: Para
        // desmarcar, clique em cima da 'bolinha vermelha'.

        dadosPessoa = "Primeiro Nome: ";
        dadosPessoa += pessoa.getPrimeiroNome();
        dadosPessoa += " Sobrenome: ";
        dadosPessoa += pessoa.getSobreNome();
        dadosPessoa += " Curso Desejado: ";
        dadosPessoa += pessoa.getCursoDesejado();
        dadosPessoa += " Telefone de Contato: ";
        dadosPessoa += pessoa.getTelefoneContato();

        int parada = 0;
    }
}