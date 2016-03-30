package net.sgoliver.android.holausuario;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class BotonesCheckActivity extends AppCompatActivity {

    private CheckBox chkMarcame;
    private TextView lblRadioButton;
    private TextView lblEventoChange;
    private RadioButton rbOpcion1;
    private RadioButton rbOpcion2;
    private RadioGroup rgOpciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_botones_check);

        lblEventoChange = (TextView) findViewById(R.id.LblEventoChange);

        chkMarcame = (CheckBox) findViewById(R.id.ChkMarcame);
        chkMarcame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isChecked = ((CheckBox) v).isChecked();
                if (isChecked) {
                    ((CheckBox) v).setText("CheckBox Marcado!");
                } else {
                    ((CheckBox) v).setText("CheckBox Desmarcado!");
                }
            }
        });

        chkMarcame.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    //buttonView.setText("" + buttonView.getText().toString() + "Estado cambiado a True.");
                    lblEventoChange.setText("Estado cambiado a True.");
                } else {
                    //buttonView.setText("" + buttonView.getText().toString() + "Estado cambiado a False.");
                    lblEventoChange.setText("Estado cambiado a False.");
                }
            }
        });

        RadioGroup rg = (RadioGroup) findViewById(R.id.GrbGrupo1);
        rg.clearCheck();
        rg.check(R.id.RbOpcion1);
        int idSeleccionado = rg.getCheckedRadioButtonId();

        lblRadioButton = (TextView) findViewById(R.id.LblRadioButton);
        rbOpcion1 = (RadioButton) findViewById(R.id.RbOpcion1);
        rbOpcion2 = (RadioButton) findViewById(R.id.RbOpcion2);

        View.OnClickListener list = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String opcion = "";
                switch (v.getId()) {
                    case R.id.RbOpcion1:
                        opcion = "Opción 1";
                        break;
                    case R.id.RbOpcion2:
                        opcion = "Opción 2";
                        break;
                }
                lblRadioButton.setText("Se ha seleccionado la opción: "+ opcion);
            }
        };
        rbOpcion1.setOnClickListener(list);
        rbOpcion2.setOnClickListener(list);

        rgOpciones = (RadioGroup) findViewById(R.id.GrbGrupo1);
        rgOpciones.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                String opcion = "";
                switch (checkedId) {
                    case R.id.RbOpcion1:
                        opcion = "Opción 1";
                        break;
                    case R.id.RbOpcion2:
                        opcion = "Opción 2";
                        break;
                }
                lblEventoChange.setText("Se ha seleccionado la opción: "+ opcion);
            }
        });

    }
}
