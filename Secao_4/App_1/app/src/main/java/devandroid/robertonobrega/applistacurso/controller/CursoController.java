package devandroid.robertonobrega.applistacurso.controller;

import java.util.ArrayList;
import java.util.List;

import devandroid.robertonobrega.applistacurso.model.Curso;

public class CursoController {
    // Aula 47, Seção 6.
    private List listCursos;

    public List getListaDeCursos(){
        listCursos = new ArrayList<Curso>(); // OBS: Até aqui, está instanciando um objeto da classe List.
        // Observe que, acima, está usando o conceito de Polimorfismo.
        listCursos.add(new Curso("Java")); // Adicionando um objeto da classe Curso, dentro de um objeto da
        // interface List, definido como objeto da classe Curso.
        listCursos.add(new Curso("HTML"));
        listCursos.add(new Curso("C#"));
        return listCursos;
    }

    public ArrayList<String> dadosParaSpinner(){
        ArrayList<String> dados = new ArrayList<>(); // Instanciando um objeto do ArrayList.
        for(int i = 0; i < getListaDeCursos().size(); ++i){
            Curso objeto = (Curso)getListaDeCursos().get(i); // Obtendo um objeto da lista e atribuindo a
            // variável chamada 'objeto'.
            dados.add(objeto.getNomeDoCursoDesejado()); // Recebendo o nome do curso, para cada objeto obtido
            // no laço for.
        }
        return dados;
    }

}
