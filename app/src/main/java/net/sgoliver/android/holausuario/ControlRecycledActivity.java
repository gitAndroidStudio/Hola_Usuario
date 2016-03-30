package net.sgoliver.android.holausuario;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class ControlRecycledActivity extends AppCompatActivity {

    private RecyclerView recView;
    private ArrayList<Titular> datos;
    private Button btnInsertar;
    private Button btnMover;
    private Button btnEliminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control_recycled);

        //Inicialización de la lista datos de ejemplo
        datos = new ArrayList<Titular>();
        for (int i=0;i<50; i++) {
            Titular titular = new Titular("Título "+i,"Subtítulo item"+i);
            datos.add(titular);
        }

        //Inicializamos recView
        recView = (RecyclerView) findViewById(R.id.RecView);
        recView.setHasFixedSize(true);

        final AdaptadorTitulares adaptador = new AdaptadorTitulares(datos);

        adaptador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("DemoRecView", "Pulsado el elemento" + recView.getChildAdapterPosition(v));
            }
        });

        recView.setAdapter(adaptador);
        //recView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false));
        recView.setLayoutManager(new GridLayoutManager(this,3));

        recView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        recView.setItemAnimator(new DefaultItemAnimator());

        btnInsertar = (Button) findViewById(R.id.BtnInsertar);
        btnInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datos.add(1, new Titular ("Nuevo Titular", "Subtitulo nuevo Titular"));
                adaptador.notifyItemInserted(1);
            }
        });

        btnEliminar = (Button) findViewById(R.id.BtnEliminar);
        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datos.remove(1);
                adaptador.notifyItemRemoved(1);
            }
        });

        btnMover = (Button) findViewById(R.id.BtnMover);
        btnMover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Titular aux = datos.get(1);
                datos.set(1, datos.get(2));
                datos.set(2, aux);
                adaptador.notifyItemMoved(1,2);
            }
        });
    }
}
