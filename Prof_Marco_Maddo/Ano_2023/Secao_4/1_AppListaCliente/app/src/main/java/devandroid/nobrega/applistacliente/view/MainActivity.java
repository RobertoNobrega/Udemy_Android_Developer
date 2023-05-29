package devandroid.nobrega.applistacliente.view; // Será meu "ID de app", quando estiver divulgado na loja do
// Google Play Store.

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import devandroid.nobrega.applistacliente.R;
import devandroid.nobrega.applistacliente.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    /*
                            Aula 19, Seção 4
          OBS: As duas últimas pastas que estão dentro da pasta java são para
      realizar testes no App. Se quiser, pode apagar estas duas últimas pastas
      (de acordo com o prof.Marco Maddo, pois estamos aprendendo a fazer app, de
       forma principiante).

          No arquivo proguard-rules.pro, ficam configurações importantes. Por exemplo, nele,
          podemos configurar para impedir a "engenharia reversa" do App.
          No arquivo local.properties, fica o endereço local do SDK ->     sdk.dir=/root/Android/Sdk
          No arquivo settings.gradle, ficam outras configurações. Por exemplo, include ':app' , trata-se
          de um módulo, porém é possível adicionar mais módulos no projeto.

          OBS: Este projeto de aplicativo, na aula do prof. Marco Maddo, se chama AppListaCurso. Eu digitei
          erradamente, colocando AppListaCliente.

                            Aula 24, Seção 4
          Dentro do SDK do Android, existem diversos tipos de Padrões de Projeto (Design Patterns).
             Desenvolvidos sob a experiência dos usuários, dos desenvolvedores.
          O Professor ensina, nesta aula, o padrão MVC (Model View Controller)

                            Aula 25, Seção 4
          Continuação sobre MVC.
          Professor criou uma pasta, chamada view, deslocando a classe MainActivity para dentro dela.

                            Aula 30, Seção 4
          O Professor ensina a usar o Modo Debug.

 */

    Pessoa pessoa; // Declarando um objeto da classe Pessoa. Atalho: Após digitar o nome Pessoa, insira
    // um espaço em branco. Após isso, segure o CTRL, seguido de espaço em branco.
    Pessoa outraPessoa;
    String dadosPessoa, dadosOutraPessoa;   // OBS: Está usando pascalCase - camelCase.

    EditText editPrimeiroNome; // Declarando um objeto da classe EditText. OBS: O nome deste objeto está sendo
    // considerado o mesmo nome que se encontra no  arquivo activity_main.xml, que apresenta o id chamado
    // editPrimeiroNome.
    EditText editSobreNomeAluno, editNomeCurso, editTelefoneContato; // OBS: Aqui, o mesmo caso do primeiro atributo
    // do EditText acima.

    Button btnLimpar; // OBS: Mesmo efeito dos atributos acima.
    Button btnSalvar, btnFinalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) { // Método onCreate. Recebe um Bundle como parâmetro.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // OBS: Atalho (Em R.layout.activity_main , se for selecionado com o cursor do mouse o nome
        // activity_main e, em seguida, segurar na tecla ctrl e na tecla B, vai abrir o xml do
        // activity_main.
        pessoa = new Pessoa(); // Instanciando um objeto da classe Pessoa.
        // Abaixo, estamos usando os métodos set, para preencher o objeto ( pessoa ), conforme o seu
        // MODELO, TEMPLATE.
        // pessoa.setPrimeiroNome("Marco");
        // pessoa.setSobreNome("Maddo");
        // pessoa.setCursoDesejado("Android");
        // pessoa.setTelefoneContato("11-99229191");

        outraPessoa = new Pessoa();
        outraPessoa.setPrimeiroNome("Roberto");
        outraPessoa.setSobreNome("Nóbrega");
        outraPessoa.setCursoDesejado("Java");
        outraPessoa.setTelefoneContato("11-232355");

        editPrimeiroNome = findViewById(R.id.editPrimeiroNome); // Aqui, o atributo irá receber
        // a referência de seu respectivo botão, associado ao xml (neste caso,
        // o activity_main.xml), para realizar um evento específico.  R é uma classe
        // específica do próprio projeto do AndroidStudio.
        editSobreNomeAluno = findViewById(R.id.editSobreNomeAluno);
        editNomeCurso = findViewById(R.id.editNomeCurso);
        editTelefoneContato = findViewById(R.id.editTelefoneContato);

        // Abaixo, estamos obtendo a referência dos botões.
        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnFinalizar = findViewById(R.id.btnFinalizar);

        // Abaixo, se quisermos preencher o EditText (no momento da abertura do
        // App), devemos fazer o seguinte.

        // editPrimeiroNome.setText(pessoa.getPrimeiroNome());  // Vai preencher o EditText com texto,
        // usando o setText. OBS: Isso está na aula 34, da seção 4.

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override // Reescrevendo o método onClick abaixo.
            public void onClick(View v) {
                editPrimeiroNome.setText("");
                editSobreNomeAluno.setText("");
                editTelefoneContato.setText("");
                editNomeCurso.setText("");

            }
        }); // setOnClickListener serve para Evento de Botão.

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Volte Sempre", Toast.LENGTH_LONG).show(); // Método show: Serve para exibir uma "pequena elipse de
                // texto". O primeiro argumento (do makeText) é o contexto da aplicação (no caso, a própria aplicação, representado pelo
                // MainActivity.this). O segundo argumento é a mensagem que se deseja exibir, antes de "finalizarmos o app". O terceiro
                // argumento é o Toast.LENGTH_LONG , que indica que o Toast será exibido por um "tempo a mais" no dispositivo.
                finish(); // Serve para finalizar o App.
            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Abaixo, iremos "preencher" os atributos do objeto pessoa, por meio
                // do que foi obtido nos campos do EditText.
                pessoa.setPrimeiroNome(editPrimeiroNome.getText().toString());
                pessoa.setSobreNome(editSobreNomeAluno.getText().toString());
                pessoa.setCursoDesejado(editNomeCurso.getText().toString());
                pessoa.setTelefoneContato(editTelefoneContato.getText().toString());
                // Abaixo, vai ser usado um Toast, para exibir o que foi "obtido para ser
                // gravado".
                Toast.makeText(MainActivity.this,"Salvo : " + pessoa.toString(), Toast.LENGTH_LONG).show();
            }
        }); // Evento para o botão "Salvar".

        dadosPessoa = "Primeiro Nome: ";
        dadosPessoa += pessoa.getPrimeiroNome();
        dadosPessoa += " Sobrenome: ";
        dadosPessoa += pessoa.getSobreNome();
        dadosPessoa += " Curso Desejado: ";
        dadosPessoa += pessoa.getCursoDesejado();
        dadosPessoa += " Telefone de Contato: ";
        dadosPessoa += pessoa.getTelefoneContato();

        Log.i("POOAndroid", "Objeto pessoa : " + pessoa.toString()); // Estamos usando Log aqui, para exibir dados no Logcat (encontrado no AndroidStudio). Está usando o método i, para
        // poder exibir estes dados. O primeiro parâmetro é uma tag (que vai identificar estes dados. OBS: Fornecido quando o
        // programador está usando o método i. Então, o programador está chamando de POOAndroid). O segundo parâmetro representa
        // o que o aplicativo deseja exibir no Logcat (nesse caso, está usando o toString, pois este método vai trazer os dados
        // que se encontram no objeto pessoa).
        Log.i("POOAndroid","Objeto outraPessoa : " + outraPessoa.toString()); // OBS: Pode usar o mesmo nome de tag para uma outra chamada de Logcat, que
        // deseja exibir dados de um outro objeto de classe.
        
    }
}