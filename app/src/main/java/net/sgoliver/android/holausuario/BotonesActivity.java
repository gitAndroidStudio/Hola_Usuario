package net.sgoliver.android.holausuario;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ToggleButton;

public class BotonesActivity extends AppCompatActivity {

    TextView lblMensaje;
    Button btnBotonSimple;
    ToggleButton btnToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_botones);

        lblMensaje = (TextView) findViewById(R.id.LblMensaje);

        //Evento OnClick BtnBotonSimple
        btnBotonSimple = (Button) findViewById(R.id.BtnBotonSimple);
        btnBotonSimple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lblMensaje.setText("Botón Simple Pulsado");
            }
        });

        //Evento Onclick BtnToggle
        btnToggle = (ToggleButton) findViewById(R.id.BtnToggle);
        btnToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btnToggle.isChecked()) {
                    lblMensaje.setText("Toggle estado: On");
                } else {
                    lblMensaje.setText("Toggle estado: Off");
                }
            }
        });

    }

}
