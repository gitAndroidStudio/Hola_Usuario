package net.sgoliver.android.holausuario;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by xIS11613 on 23/03/2016.
 */
public class ControlLoginActivity extends LinearLayout {

    private EditText txtUsuario;
    private EditText txtPassword;
    private Button btnAceptar;
    private TextView lblMensaje;
    private OnLoginListener listener;

    public ControlLoginActivity(Context context) {
        super(context);
        inicializar ();
    }

    public ControlLoginActivity(Context context, AttributeSet attrs) {
        super(context, attrs);
        inicializar ();

        //Procesamos los atributos xml personalizados
        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.ControlLoginActivity);
        String textoBoton = a.getString(R.styleable.ControlLoginActivity_login_text);

        a.recycle();
    }

    private void inicializar () {

        //Utilizamos el layout 'control login' como interfaz de control
        String infService =  Context.LAYOUT_INFLATER_SERVICE;
        LayoutInflater li = (LayoutInflater)getContext().getSystemService(infService);
        li.inflate(R.layout.activity_control_login,this,true);

        //Obtenemos las referencias a los distintos controles
        txtUsuario = (EditText) findViewById(R.id.TxtUsuario);
        txtPassword = (EditText) findViewById(R.id.TxtPassword);
        btnAceptar = (Button) findViewById(R.id.BtnAceptar);
        lblMensaje = (TextView) findViewById(R.id.LblMensaje);

        //Asignamos los eventos necesarios
        asignarEventos();
    }

    private void asignarEventos () {

        btnAceptar.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onLogin(txtUsuario.getText().toString(),txtPassword.getText().toString());
            }
        });

    }

    public void setMensaje (String mensaje) {
        lblMensaje.setText(mensaje);
    }

    public void setOnloginListener (OnLoginListener l){
        listener = l;
    }
}
