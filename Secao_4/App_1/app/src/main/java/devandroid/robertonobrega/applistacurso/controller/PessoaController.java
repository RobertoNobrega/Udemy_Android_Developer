package devandroid.robertonobrega.applistacurso.controller;

import android.util.Log;

import androidx.annotation.NonNull;

import devandroid.robertonobrega.applistacurso.model.Pessoa;

public class PessoaController {

    @NonNull
    @Override
    public String toString() {
        Log.d("MVC Controller","Controller Iniciada..."); // Para exibir no LogCat. d é de Debug. O
        // primeiro argumento indica que é uma tag que será identificada no LogCat. O segundo é uma String, no
        // caso, uma mensagem.
        return super.toString();
    }

    public void salvar(Pessoa pessoa){ // Aula 39, Seção 5.
        Log.d("MCV_Controller","Salvo: " + pessoa.toString()); // Exibindo no LogCat. d é na parte do Debug.
    }

}
