package net.sgoliver.android.holausuario;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.reflect.Array;

public class ControlSpinnerActivity extends AppCompatActivity {

    private Spinner cmbOpciones;
    private TextView lblMensaje;
    private ListView lstOpciones;
    private ListView lstOpcionesPersonalizada;

    private Titular[] datos =
        new Titular []{
                new Titular("Titulo 01", "Subtitulo 01"),
                new Titular("Titulo 02", "Subtitulo 02"),
                new Titular("Titulo 03", "Subtitulo 03"),
                new Titular("Titulo 04", "Subtitulo 04"),
                new Titular("Titulo 05", "Subtitulo 05"),
                new Titular("Titulo 06", "Subtitulo 06")
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control_spinner);

        // Si creamos el adaptador desde un array
        // final String [] datos = new String [] {"Elem 1","Elem 2","Elem 3","Elem 4","Elem 5"};
        // ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, R.layout.activity_control_spinner, datos);

        // Si creamos el adaptador desde un resource
        ArrayAdapter<CharSequence> adaptador = ArrayAdapter.createFromResource(this, R.array.valores_array, android.R.layout.simple_spinner_item);

        cmbOpciones = (Spinner) findViewById(R.id.CmbOpciones);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cmbOpciones.setAdapter(adaptador);

        lblMensaje = (TextView) findViewById(R.id.LblMensaje);

        cmbOpciones.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> parent,
                                               android.view.View v, int position, long id) {
                        lblMensaje.setText("Seleccionado: " +
                                parent.getItemAtPosition(position));
                    }

                    public void onNothingSelected(AdapterView<?> parent) {
                        lblMensaje.setText("");
                    }
                });

        lstOpciones = (ListView) findViewById(R.id.LstOpciones);
        ArrayAdapter<CharSequence> adaptadorLst = ArrayAdapter.createFromResource(this, R.array.valores_array, android.R.layout.simple_list_item_1);
        lstOpciones.setAdapter(adaptadorLst);

        AdaptadorTitulares adaptadorTitulares = new AdaptadorTitulares(this, datos);
        lstOpcionesPersonalizada = (ListView) findViewById(R.id.LstOpcionesPersonalizada);
        View header = getLayoutInflater().inflate(R.layout.list_header, null);
        lstOpcionesPersonalizada.addHeaderView(header);
        lstOpcionesPersonalizada.setAdapter(adaptadorTitulares);

        lstOpcionesPersonalizada.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {

                //Alternativa 1:
                String opcionSeleccionada =
                        ((Titular) a.getItemAtPosition(position)).getTitulo();

                //Alternativa 2:
                //String opcionSeleccionada =
                //      ((TextView)v.findViewById(R.id.LblTitulo))
                //          .getText().toString();

                lblMensaje.setText("Opción seleccionada: " + opcionSeleccionada);
            }
        });
    }

    class AdaptadorTitulares extends ArrayAdapter {

        public AdaptadorTitulares(Context context, Titular[] datos) {
            super(context, R.layout.listitem_titular, datos);
        }

        public View getView(int position, View convertView, ViewGroup parent) {

            //Esto se realiza para optimizar la carga del layout y ahorrar batería, ya que si
            //se ha utilizado previamente el layout viene en el convertView, además creamos la clase
            //ViewHolder para almacenar la referencia de los contenidos que lo forman, si no valdría
            //con el siguiente código:
            /*
            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.listitem_titular, null);

            TextView lblTitulo = (TextView)item.findViewById(R.id.LblTitulo);
            lblTitulo.setText(datos[position].getTitulo());

            TextView lblSubtitulo = (TextView)item.findViewById(R.id.LblSubTitulo);
            lblSubtitulo.setText(datos[position].getSubtitulo());

            return(item);

             */
            View item = convertView;
            ViewHolder holder;
            if (item == null) {
                LayoutInflater inflater = LayoutInflater.from(getContext());
                item = inflater.inflate(R.layout.listitem_titular, null);

                holder = new ViewHolder();
                holder.titulo = (TextView) item.findViewById(R.id.LblTitulo);
                holder.subtitulo = (TextView) item.findViewById(R.id.LblSubtitulo);

                item.setTag(holder);
            } else {
                holder = (ViewHolder) item.getTag();
            }

            holder.titulo.setText(datos[position].getTitulo());
            holder.subtitulo.setText(datos[position].getSubtitulo());

            return item;
        }
    }

    static class ViewHolder {
        TextView titulo;
        TextView subtitulo;
    }
}
