package net.sgoliver.android.holausuario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class FragmentsActivity extends AppCompatActivity implements FragmentListado.CorreosListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragments);

        FragmentListado frgListado = (FragmentListado) getSupportFragmentManager().findFragmentById(R.id.FrgListado);
        frgListado.setCorreosListener(this);
    }

    @Override
    public void onCorreoSeleccionado(Correo c) {
        boolean hayDetalle = (getSupportFragmentManager().findFragmentById(R.id.FrgDetalle) != null);
        if (hayDetalle) {
            ((FragmentDetalle) getSupportFragmentManager().findFragmentById(R.id.FrgDetalle)).mostrarDetalle(c.getTexto());
        } else {
            Intent intent = new Intent(FragmentsActivity.this, FragmentDetalle.class);
            intent.putExtra(DetalleActivity.EXTRA_TEXTO, c.getTexto());
            startActivity(intent);

        }
    }
}
