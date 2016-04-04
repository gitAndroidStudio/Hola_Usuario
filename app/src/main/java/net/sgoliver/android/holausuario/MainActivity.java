package net.sgoliver.android.holausuario;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button btnHolaUsuario;
    private Button btnLayouts;
    private Button btnBotones;
    private Button btnBotonesTexto;
    private Button btnBotonesCheck;
    private Button btnControlSpinner;
    private Button btnControlGrid;
    private Button btnControlRecycled;
    private Button btnCardView;
    private Button btnExtendedEditText;
    private Button btnPestanas;
    private Button btnFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Obtenemos una referencia a los controles de la interfaz
        btnHolaUsuario = (Button) findViewById(R.id.BtnHolaUsuario);
        btnLayouts = (Button) findViewById(R.id.BtnLayouts);
        btnBotones = (Button) findViewById(R.id.BtnBotones);
        btnBotonesTexto = (Button) findViewById(R.id.BtnBotonesTexto);
        btnBotonesCheck = (Button) findViewById(R.id.BtnBotonesCheck);
        btnControlSpinner = (Button) findViewById(R.id.BtnControlesSpinner);
        btnControlGrid = (Button) findViewById(R.id.BtnControlesGrid);
        btnControlRecycled = (Button) findViewById(R.id.BtnControlesRecicled);
        btnCardView = (Button) findViewById(R.id.BtnCardView);
        btnExtendedEditText = (Button) findViewById(R.id.BtnExtendedEditText);
        btnPestanas = (Button) findViewById(R.id.BtnPestanas);
        btnFragments = (Button) findViewById(R.id.BtnFragments);


        //Implementamos el evento OnClick del Botón
        btnHolaUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creamos el Intent
                Intent intent = new Intent(MainActivity.this, HolaUsuarioActivity.class);
                startActivity(intent);
            }
        });

        //Implementamos el evento OnClick del Botón
        btnLayouts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creamos el Intent
                Intent intent = new Intent(MainActivity.this, LayoutActivity.class);
                startActivity(intent);
            }
        });

        //Implementamos el evento OnClick del Botón
        btnBotones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (MainActivity.this, BotonesActivity.class);
                startActivity(intent);
            }
        });

        //Implementamos el evento OnClick del Botón
        btnBotonesTexto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (MainActivity.this,ControlesTextoActivity.class);
                startActivity(intent);
            }
        });

        //Implementamos el evento OnClick del Botón
        btnBotonesCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BotonesCheckActivity.class);
                startActivity(intent);
            }
        });

        //Implementamos el evento OnClick del Botón
        btnControlSpinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (MainActivity.this, ControlSpinnerActivity.class);
                startActivity(intent);
            }
        });

        //Implementamos el evento OnClick del Botón
        btnControlGrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (MainActivity.this, ControlGridActivity.class);
                startActivity(intent);
            }
        });

        //Implementamos el evento OnClick del Botón
        btnControlRecycled.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ControlRecycledActivity.class);
                startActivity(intent);
            }
        });

        //Implementamos el evento OnClick del Botón
        btnCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, UICardViewActivity.class);
                startActivity(intent);
            }
        });

        //Implementamos el evento OnClick del Botón
        btnExtendedEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (MainActivity.this, ControlesPersonalizadosActivity.class);
                startActivity(intent);
            }
        });

        //Implementamos el evento OnClick del Botón
        btnPestanas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (MainActivity.this, PestanasActivity.class);
                startActivity(intent);
            }
        });

        //Implementamos el evento OnClick del Botón
        btnFragments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (MainActivity.this, FragmentsActivity.class);
                startActivity(intent);
            }
        });

    /*
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    */
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        /*
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
        */

        switch (item.getItemId()) {
            case R.id.action_nuevo:
                Log.i("ActionBar", "Nuevo!");
                return true;
            case R.id.action_buscar:
                Log.i("ActionBar", "Buscar!");
                ;
                return true;
            case R.id.action_settings:
                Log.i("ActionBar", "Settings!");
                ;
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
