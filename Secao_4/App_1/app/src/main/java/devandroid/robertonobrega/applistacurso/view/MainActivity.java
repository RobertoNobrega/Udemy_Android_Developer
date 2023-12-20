package devandroid.robertonobrega.applistacurso.view; // OBS: devandroid é o "nome da sua organização,
// empresa". robertonobrega é o nome do Desenvolvedor. applistacurso é o nome do Aplicativo que está
// sendo desenvolvido. view é o nome do pacote.

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import devandroid.robertonobrega.applistacurso.R;

public class MainActivity extends AppCompatActivity {

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

    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Aula 25, Seção 4. Nesta linha, informa que a tela
        // do app a ser aberta ( ao iniciar o app ) é a tela activity_main ( essa activity_main é uma
        // tela do XML ). OBS: Atalho: Ao selecionar o nome da tela do XML (nesse caso, activity_main),
        // ao segurar a tecla Ctrl , clique em seguida a tecla B. Vai abrir a tela do XML.
    }
}