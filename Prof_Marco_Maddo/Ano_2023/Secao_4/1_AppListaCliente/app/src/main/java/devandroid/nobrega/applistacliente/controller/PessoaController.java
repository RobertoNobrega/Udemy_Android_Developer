package devandroid.nobrega.applistacliente.controller;

import android.util.Log;

import devandroid.nobrega.applistacliente.model.Pessoa;

public class PessoaController{

    public void salvar(Pessoa pessoa){
        Log.d("Dados da Pessoa Gravada", pessoa.toString());
    }
}
