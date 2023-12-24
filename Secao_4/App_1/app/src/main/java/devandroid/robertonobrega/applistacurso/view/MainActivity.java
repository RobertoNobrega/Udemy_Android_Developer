package devandroid.robertonobrega.applistacurso.view; // OBS: devandroid é o "nome da sua organização,
// empresa". robertonobrega é o nome do Desenvolvedor. applistacurso é o nome do Aplicativo que está
// sendo desenvolvido. view é o nome do pacote.

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import devandroid.robertonobrega.applistacurso.R;
import devandroid.robertonobrega.applistacurso.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    // OBS: As novas versões do AndroidStudio ( para o Sistema Operacional Linux ), de 2021 para
    // diante, possuem o Java, de forma embutida.

    /*
        Aula 38, Seção 5.
    */

    // Aula 40, Seção 5.

    Pessoa pessoa; // Definindo um objeto da classe Pessoa. Até esse ponto, o objeto não está instanciado. Atalho: Após
    // inserir o nome da classe (no caso, Pessoa), segure a tecla Ctrl e em seguida tecle a tecla de Espaço em Branco. Re-
    // sultado: O AndroidStudio irá completar, automaticamente, o nome do objeto da classe.
    Pessoa outraPessoa;
    String dadosPessoa, dadosOutraPessoa;  // OBS: Objetos declarados na aula 32, da seção 4.

    EditText editPrimeiroNome; // Aula 35, Seção 4. OBS: Este objeto recebe o mesmo nome do id, chamado editPrimeiroNome,
    // presente em activity_main.xml.  O objeto aqui é para receber a referência do componente EditText ( para menter
    // comunicação ).
    EditText editSobreNomeAluno, editCursoDesejado, editTelefone;
    Button btnSalvar; // Aula 35, Seção 4. Obtendo comunicação ( do XML com a classe Java ) do botão Button.
    Button btnFinalizar, btnLimpar;
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

        editPrimeiroNome = findViewById(R.id.editPrimeiroNome); // Aula 35, Seção 4. Obtendo a referência o editText do Primeiro NOme,
        // para ser inserido no objeto editPrimeiroNome.
        editSobreNomeAluno = findViewById(R.id.editSobreNomeAluno);
        editTelefone = findViewById(R.id.editTelefone);
        editCursoDesejado = findViewById(R.id.editCursoDesejado);

        btnLimpar = findViewById(R.id.btnLimpar); // Aula 35, Seção 4.
        btnSalvar = findViewById(R.id.btnSalvar);
        btnFinalizar = findViewById(R.id.btnFinalizar);

        editPrimeiroNome.setText(pessoa.getPrimeiroNome()); // Exibindo a String de Primeiro Nome, no campo do App do próprio EditText de
        // Primeiro Nome.
        editSobreNomeAluno.setText(pessoa.getSobreNome());
        editTelefone.setText(pessoa.getTelefoneContato());
        editCursoDesejado.setText(pessoa.getCursoDesejado());

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Pronto. Dentro do corpo deste método, é que haverá as instruções a serem feitas pelo App.
                editPrimeiroNome.setText(""); // O texto será "apagado" do campo.
                editSobreNomeAluno.setText(""); // Mesmo efeito.
                editTelefone.setText(""); // Mesmo efeito.
                editCursoDesejado.setText(""); // Mesmo efeito.
            }
        }); // Aula 36, Seção 4. Este método será para realizar "Evento de Botão" ( quando o botão for clicado, vai fazer
        // alguma coisa.

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Volte Sempre",Toast.LENGTH_LONG).show(); // Serve para apresentar
                // um Toast ( balãozinho de dados, exibido pelo App ). O primeiro argumento é o contexto do App ( no caso, será
                // da classe MainActivity ). O segundo a String a ser exibida e por fim, o terceiro é o tempo de exibição do
                // mesmo.
                finish(); // Finalizando o App.
            }
        }); // Aula 36, Seção 4.

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pessoa.setPrimeiroNome(editPrimeiroNome.getText().toString());
                pessoa.setSobreNome(editSobreNomeAluno.getText().toString());
                pessoa.setTelefoneContato(editTelefone.getText().toString());
                pessoa.setCursoDesejado(editCursoDesejado.getText().toString());
                Toast.makeText(MainActivity.this,"Salvo " + pessoa.toString(),Toast.LENGTH_LONG).show();
            }
        }); // Aula 36, Seção 4.

        //int parada = 0;

        Log.i("POOAndroid",pessoa.toString()); // Aula 33, Seção 4. Este método serve para exibir dados
        // , informações, no LogCat.
    }
}