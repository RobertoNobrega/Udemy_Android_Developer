package devandroid.robertonobrega.applistacurso.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import devandroid.robertonobrega.applistacurso.R;

// Aula 51, Seção 6.

public class SplashActivity extends AppCompatActivity {

    public static final int TIME_OUT_SPLASH = 3000; // Aula 51, Seção 6. Esta variável, será o tempo ( em milissegundos )
    // para transitar uma Activity para outra Activity.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        comutarTelaSplash();
    }

    private void comutarTelaSplash(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Intent é uma intenção ( ex: Activity é uma Intenção ).
                Intent telaPrincipal = new Intent(SplashActivity.this,MainActivity.class); // Intenção. No primeiro
                // argumento, coloca-se o nome da Activity que se encontra atualmente ( aqui, é a SplashActivity ). No Segundo
                // argumento, coloca o nome da Activity que deseja ir, após o tempo de espera acabar ( aqui, é a MainActivity ).
                startActivity(telaPrincipal); // Iniciando os procedimentos "descritos no argumento da classe Intent acima".
                finish(); // OBS: Este método é colocado, pois, uma vez a tela de Splash carregada ( na execução do App ), não
                // poderá mais voltar a mesma ( enquanto o App estiver sendo executado ).
            }
        }, TIME_OUT_SPLASH); // Neste método, iremos usar uma "pausa temporária".
    }
}