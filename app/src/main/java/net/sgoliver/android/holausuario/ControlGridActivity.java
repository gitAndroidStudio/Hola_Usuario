package net.sgoliver.android.holausuario;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

public class ControlGridActivity extends AppCompatActivity {

    String[] datos = new String[60];
    GridView gridOpciones;
    TextView lblEtiqueta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control_grid);

        for (int i = 0; i<datos.length; i++) {
            datos[i] = "Datos "+ i;
        }

        lblEtiqueta = (TextView) findViewById(R.id.LblEtiqueta);

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datos);
        gridOpciones = (GridView) findViewById(R.id.GridOpciones);
        gridOpciones.setAdapter(adaptador);

        gridOpciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                lblEtiqueta.setText("Opción Seleccionada: " + parent.getItemAtPosition(position).toString());
            }
        });
    }
}
