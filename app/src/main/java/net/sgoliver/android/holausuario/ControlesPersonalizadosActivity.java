package net.sgoliver.android.holausuario;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ControlesPersonalizadosActivity extends AppCompatActivity {

    private ControlLoginActivity ctlLogin;
    private Button btnFicha;
    private TresEnRaya terTablero;
    private TextView txtCasilla;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_controles_personalizados);

        //Control personalizado extendiendo uno existente
        ctlLogin.setOnloginListener(new OnLoginListener() {
            @Override
            public void onLogin(String usuario, String password) {
                //Validamos el usuario y la contraseña
                if ("demo".equals(usuario) && "demo".equals(password)) {
                    ctlLogin.setMensaje("Login Correcto");
                } else {
                    ctlLogin.setMensaje("Login Incorrecto");
                }
            }
        });

        //Control personalizado creado desde 0
        terTablero = (TresEnRaya) findViewById(R.id.tablero);
        btnFicha = (Button) findViewById(R.id.btnFicha);
        txtCasilla = (TextView) findViewById(R.id.txtCasilla);

        btnFicha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                terTablero.alternarFichaActiva();
            }
        });

        terTablero.setOnCasillaSeleccionadaListener(new OnCasillaSeleccionadaListener() {
            @Override
            public void onCasillaSeleccionada(int fila, int columna) {
                txtCasilla.setText("Última casilla seleccionada: " + fila + "." + columna);
            }
        });
    }
}
