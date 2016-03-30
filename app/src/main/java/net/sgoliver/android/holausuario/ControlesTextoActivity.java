package net.sgoliver.android.holausuario;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.Html;
import android.text.Spannable;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ControlesTextoActivity extends AppCompatActivity {

    private EditText txtBasico;
    private Button btnInsertarTexto;
    private TextInputLayout txtInputLayout;
    private Button btnComprobar;
    private EditText txtInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_controles_texto);

        txtBasico = (EditText) findViewById(R.id.TxtBasico);
        Editable str = Editable.Factory.getInstance().newEditable("Esto es un simulacro.");
        str.setSpan(new StyleSpan(Typeface.BOLD), 11, 20, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        txtBasico.setText(str);

        String txt = Html.toHtml(txtBasico.getText());
        System.out.println("Valor Recogido: " + txt);

        btnInsertarTexto = (Button) findViewById(R.id.BtnInsertarTexto);
        btnInsertarTexto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtBasico.setText(Html.fromHtml("<p>Esto es un <b>Simulacro</b>....</p>"), TextView.BufferType.SPANNABLE);
            }
        });


        btnComprobar = (Button) findViewById(R.id.BtnComprobar);

        txtInputLayout = (TextInputLayout) findViewById(R.id.TiLayout);
        txtInputLayout.setErrorEnabled(true);

        txtInput = (EditText) findViewById(R.id.TxtInput);

        //Asignamos el evento Onclick al botón
        btnComprobar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num = txtInput.getText().toString();

                if (num.isEmpty() || Integer.parseInt(num)%2 !=0) {
                    txtInputLayout.setError("Error: ¡No es un número par!");
                } else {
                    txtInputLayout.setError(null);
                }
            }
        });
    }

}
