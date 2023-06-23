package devandroid.nobrega.applistacliente.controller;

import android.content.SharedPreferences;
import android.util.Log;

import devandroid.nobrega.applistacliente.model.Pessoa;
import devandroid.nobrega.applistacliente.view.MainActivity;

public class PessoaController{

    /*
                                Aula 43, Seção 5
	    Transferir para a controladora, toda a responsabilidade de salvar os dados. Aqui, a missão da Controller
	    será de Salvar, Buscar e Limpar os Dados. OBS: Isso, no momento, na parte de salvar os dados será usando
	    a classe do SharedPreferences.
	    OBS: Nesta aula, o professor cria uma nova branch, chamada Optimizar_Controller (sendo que, a branch usada,
	    no AndroidStudio para criar esta nova branch é a branch main, ao qual o último commit que percebi desta branch
	    se chama Commit 2 (branch main): ... ). Portanto, todo o código de SharedPreferences que se encontra na classe
	    MainActivity, será retirada e colocada aqui, na classe PessoaController.


     */

    SharedPreferences preferences;
    SharedPreferences.Editor listaVip; // OBS: Para criar, consultar e limpar a lista de pessoas.

    public static final String NOME_PREFERENCES = "pref_listavip";

    public PessoaController(MainActivity mainActivity){ // Construtor da classe PessoaController.
        preferences = mainActivity.getSharedPreferences(NOME_PREFERENCES, 0); // Instanciando um SharedPreferences
        // , usando o objeto da classe MainActivity.
        listaVip = preferences.edit(); // Criando a lista.
    }

    public void salvar(Pessoa pessoa){ // Método para salvar os dados da pessoa.
        Log.d("Dados da Pessoa Gravada", pessoa.toString());
        listaVip.putString("primeiroNome",pessoa.getPrimeiroNome()); // O putString tem um papel similar ao método setter, porém aplicado
        // ao SharedPreferences. O primeiro argumento é uma chave (para o atributo), enquanto que o
        // segundo argumento é o "valor" associado a chave.
        listaVip.putString("sobreNome",pessoa.getSobreNome());
        listaVip.putString("nomeCurso",pessoa.getCursoDesejado());
        listaVip.putString("telefoneContato",pessoa.getTelefoneContato());
        listaVip.apply(); // Gravando os dados do SharedPreferences.
    }

    public Pessoa buscar(Pessoa pessoa){ // Método para buscar dados.
        // Abaixo, estamos recupendo os dados "registrados" de uma pessoa, que se encontra em um arquivo do próprio dispositivo.
        pessoa.setPrimeiroNome(preferences.getString("primeiroNome","")); // Recuperando Nome no arquivo pref_listavip.xml.
        // O primeiro argumento é o valor do atributo name, que se encontra na tag string do mesmo arquivo (no arquivo, diz que o valor
        // deste atributo é primeiroNome). O segundo argumento é, caso não exista esta "key" do primeiro argumento, então, será "".
        pessoa.setSobreNome(preferences.getString("sobreNome","")); // Recuperando Sobrenome.
        pessoa.setCursoDesejado(preferences.getString("nomeCurso","")); // Recuperando Nome do Curso.
        pessoa.setTelefoneContato(preferences.getString("telefoneContato","")); // Recuperando Telefone de Contato.
        return pessoa;
    }

    public void limpar(){ // Limpar Dados.
        listaVip.clear(); // Limpando o listaVip.
        listaVip.apply(); // Aplicando as mudanças (após usar o método clear acima). Ou seja,
        // os dados gravados no arquivo pref_listavip.xml foram apagados, após clicar
        // botão Limpar do aplicativo.
    }
}
