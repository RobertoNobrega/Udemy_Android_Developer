package devandroid.robertonobrega.applistacurso;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    /*
        Aula 21, Seção 4: O prof. informa que a pasta ( onde está o arquivo MainActivity.java )
        será a que trabalharemos muito. As outras duas pastas ( dentro da pasta java ), trata-se
        para uso em testes (obs: o prof, neste momento, excluiu essas pastas, por não ser úteis
        para este início de programação; porém são importantes para desenvolvimentos "grandes").
        Na pasta drawable, vai possuir imagens do App (OBS: ic_launcher_foreground.xml (v24), é para
        API 24).
        Na pasta xml, tem dois arquivos. Neles, podemos fornecer mais permissões ao App.
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}