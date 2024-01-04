package devandroid.robertonobrega.applistacurso.controller;

import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import devandroid.robertonobrega.applistacurso.model.Pessoa;
import devandroid.robertonobrega.applistacurso.view.MainActivity;

public class PessoaController {

    SharedPreferences preferences;
    SharedPreferences.Editor listaVip;
    public static final String NOME_PREFERENCES = "pref_listavip";

    public PessoaController(MainActivity mainActivity){ // Aula 44, Seção 5.
        preferences = mainActivity.getSharedPreferences(NOME_PREFERENCES,0);
        listaVip = preferences.edit();
    }

    @NonNull
    @Override
    public String toString() {
        Log.d("MVC Controller","Controller Iniciada..."); // Para exibir no LogCat. d é de Debug. O
        // primeiro argumento indica que é uma tag que será identificada no LogCat. O segundo é uma String, no
        // caso, uma mensagem.
        return super.toString();
    }

    public void criarSharedPreferences(){

    }

    public void salvar(Pessoa pessoa){ // Aula 39, Seção 5.
        Log.d("MCV_Controller","Salvo: " + pessoa.toString()); // Exibindo no LogCat. d é na parte do Debug.
        listaVip.putString("primeiroNome",pessoa.getPrimeiroNome()); // Armazenando nome no SharedPreferences. OBS: O primeiro argumento é
        // uma chave, para ter "acesso ao mesmo" no objeto do SharedPreferences.
        listaVip.putString("sobreNome",pessoa.getSobreNome()); // Armazenando Sobrenome.
        listaVip.putString("nomeCurso",pessoa.getCursoDesejado()); // Armazenando Curso.
        listaVip.putString("telefoneContato",pessoa.getTelefoneContato()); // Armazenando Telefone.
        listaVip.apply(); // "Realizando" o Evento de Gravação dos Dados.
    }

    public Pessoa buscar(Pessoa pessoa){ // Aula 44, Seção 5.
        pessoa.setPrimeiroNome(preferences.getString("primeiroNome","Não Declarado o Nome")); // Setando o primeiro nome
        // da pessoa, na tela do App.
        pessoa.setSobreNome(preferences.getString("sobreNome","Não Declarado o Sobrenome"));
        pessoa.setTelefoneContato(preferences.getString("telefoneContato","Não Declarado o Telefone"));
        pessoa.setCursoDesejado(preferences.getString("nomeCurso","Não Declarado o Curso"));
        return pessoa;
    }

    public void limpar(){ // Aula 44, Seção 5. Irá limpar o "Shared Preferences".
        listaVip.clear();
        listaVip.apply();
    }

}
