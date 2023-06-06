package devandroid.nobrega.applistacliente.view; // Será meu "ID de app", quando estiver divulgado na loja do
// Google Play Store.

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import devandroid.nobrega.applistacliente.R;
import devandroid.nobrega.applistacliente.controller.PessoaController;
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

                            Aula 37, Seção 5
          Nesta aula, ensina a criar uma branch (chamada Versao1_CleanCode) no AndroidStudio.
          Depois, manutenção do código, por meio desta nova branch.
          Em seguida, Commit deste código.

                            Aula 39, Seção 5
          MVC usando SharedPreferences, para gravar dados de objetos.
            OBS: O SharedPreferences cria um arquivo temporário, que vai gravar
            strings, números, dados booleanos, etc.
          Os dados, deste app, ficam armazenados em um arquivo, chamado pref_listavip.xml,
          localizado no seguinte diretório (em Device File Explorer, do AndroidStudio)
               devandroid.nobrega.applistacliente/shared_prefs/pref_listavip.xml

                            Aula 40, Seção 5
          MVC usando SharedPreferences, para recuperar dados salvos
           Foi criado uma nova branch (no AndroidStudio), chamada SharedPreferences_BuscarDados,
           usando como referência a branch main.
           Vai ser recuperado os dados gravados, que se encontram no arquivo pref_listavip.xml
             OBS: Essa versão do app, desta aula, usando a branch SharedPreferences_BuscarDados, intitulado
             na Commit 1 (branch SharedPreferences_BuscarDados), sobrescreve os dados de uma possível nova
             pessoa que deseja se cadastrar (EX: Se P1 tem dados registrados no arquivo pref_listavip.xml e,
             por acaso, P2 se registra, os dados de P1 foram "apagados", sendo substituídos pelos dados de P2).


         	                Aula 41: MVC usando SharedPreferences para limpar dados salvos previamente
	      Atalho:  Na classe MainActivity, selecione um objeto qualquer declarado (ex: btnLimpar). Depois, segure o ctrl,
	      apertando em seguida a tecla B . Vai exibir uma "pequena janela", mostrando, no código da classe MainActivity,
	      as partes do código que usam o objeto btnLimpar.

	                        Aula 42
	      O professor cria a branch SharedPreferences_limpar, tendo como referência a branch release (no meu, é a main).

 */

    SharedPreferences preferences; // Declarando um objeto da classe (nativa do android) SharedPreferences (para
    // permitir gravar dados de objetos).
    SharedPreferences.Editor listaVip;

    public static final String NOME_PREFERENCES = "pref_listavip";

    PessoaController controller; // Declarando um objeto (pasta controller) da classe PessoaController.

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
    protected void onCreate(Bundle savedInstanceState){ // Método onCreate. Recebe um Bundle como parâmetro.
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

        preferences = getSharedPreferences(NOME_PREFERENCES,0); // OBS: O primeiro argumento é o nome, enquanto que
        // o segundo é um valor numérico. 0 representa a operação de Leitura e Escrita.
        //SharedPreferences.Editor listaVip = preferences.edit(); // Com o objeto da classe Editor, já podemos realizar
        // a edição dos dados do objeto.
        listaVip = preferences.edit(); // Com o objeto da classe Editor, já podemos realizar
        // a edição dos dados do objeto.

        // Abaixo, estamos recupendo os dados "registrados" de uma pessoa, que se encontra em um arquivo do próprio dispositivo.
        pessoa.setPrimeiroNome(preferences.getString("primeiroNome","")); // Recuperando Nome no arquivo pref_listavip.xml.
        // O primeiro argumento é o valor do atributo name, que se encontra na tag string do mesmo arquivo (no arquivo, diz que o valor
        // deste atributo é primeiroNome). O segundo argumento é, caso não exista esta "key" do primeiro argumento, então, será "".
        pessoa.setSobreNome(preferences.getString("sobreNome","")); // Recuperando Sobrenome.
        pessoa.setCursoDesejado(preferences.getString("nomeCurso","")); // Recuperando Nome do Curso.
        pessoa.setTelefoneContato(preferences.getString("telefoneContato","")); // Recuperando Telefone de Contato.

        controller = new PessoaController(); // Instanciando um objeto da classe PessoaController.
        controller.toString(); // Chamando o método toString, da Controller.

        /*
        outraPessoa = new Pessoa();
        outraPessoa.setPrimeiroNome("Roberto");
        outraPessoa.setSobreNome("Nóbrega");
        outraPessoa.setCursoDesejado("Java");
        outraPessoa.setTelefoneContato("11-232355");
        */

        editPrimeiroNome = findViewById(R.id.editPrimeiroNome); // Aqui, o atributo irá receber
        // a referência de seu respectivo botão, associado ao xml (neste caso,
        // o activity_main.xml), para realizar um evento específico.  R é uma classe
        // específica do próprio projeto do AndroidStudio.
        editSobreNomeAluno = findViewById(R.id.editSobreNomeAluno);
        editNomeCurso = findViewById(R.id.editNomeCurso);
        editTelefoneContato = findViewById(R.id.editTelefoneContato);

        // Abaixo, estará colocando os dados recuperados da pessoa no EditText.
        editPrimeiroNome.setText(pessoa.getPrimeiroNome());
        editSobreNomeAluno.setText(pessoa.getSobreNome());
        editNomeCurso.setText(pessoa.getCursoDesejado());
        editTelefoneContato.setText(pessoa.getTelefoneContato());

        // Abaixo, estamos obtendo a referência dos botões.
        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnFinalizar = findViewById(R.id.btnFinalizar);

        // Abaixo, se quisermos preencher o EditText (no momento da abertura do
        // App), devemos fazer o seguinte.

        // editPrimeiroNome.setText(pessoa.getPrimeiroNome());  // Vai preencher o EditText com texto,
        // usando o setText. OBS: Isso está na aula 34, da seção 4.

        btnLimpar.setOnClickListener(new View.OnClickListener(){
            @Override // Reescrevendo o método onClick abaixo.
            public void onClick(View v) {
                editPrimeiroNome.setText("");
                editSobreNomeAluno.setText("");
                editTelefoneContato.setText("");
                editNomeCurso.setText("");
                listaVip.clear(); // Limpando o listaVip.
                listaVip.apply(); // Aplicando as mudanças (após usar o método clear acima). Ou seja,
                // os dados gravados no arquivo pref_listavip.xml foram apagados, após clicar
                // botão Limpar do aplicativo.
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

                listaVip.putString("primeiroNome",pessoa.getPrimeiroNome()); // O putString tem um papel similar ao método setter, porém aplicado
                // ao SharedPreferences. O primeiro argumento é uma chave (para o atributo), enquanto que o
                // segundo argumento é o "valor" associado a chave.
                listaVip.putString("sobreNome",pessoa.getSobreNome());
                listaVip.putString("nomeCurso",pessoa.getCursoDesejado());
                listaVip.putString("telefoneContato",pessoa.getTelefoneContato());
                listaVip.apply(); // Gravando os dados do SharedPreferences.

                controller.salvar(pessoa); // Controladora "Gravando" pessoa.
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
        // Log.i("POOAndroid","Objeto outraPessoa : " + outraPessoa.toString()); // OBS: Pode usar o mesmo nome de tag para uma outra chamada de Logcat, que
        // deseja exibir dados de um outro objeto de classe.
        
    }
}