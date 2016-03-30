package net.sgoliver.android.holausuario;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * Created by xIS11613 on 17/03/2016.
 */
public class ExtendedEditText extends EditText {

    private float escala;
    private Paint p1;
    private Paint p2;

    public ExtendedEditText(Context context) {
        super(context);
        inicializacion();
    }

    public ExtendedEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        inicializacion();
    }

    public ExtendedEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inicializacion();
    }

    private void inicializacion () {
        p1 = new Paint(Paint.ANTI_ALIAS_FLAG);
        p1.setColor(Color.BLACK);
        p1.setStyle(Paint.Style.FILL);

        p2 = new Paint(Paint.ANTI_ALIAS_FLAG);
        p2.setColor(Color.WHITE);
        p2.setTextSize(20);

        escala = getResources().getDisplayMetrics().density;
    }

    @Override
    public void onDraw (Canvas canvas) {
        //Llamamos al constructor de la clase base (EditText)
        super.onDraw(canvas);

        //Dibujamos el fondo negro del contador
        canvas.drawRect(this.getWidth()-30*escala, 5*escala, this.getWidth()-5*escala, 20*escala, p1);

        //Dibujamos el número de caracteres sobre el contador
        canvas.drawText("" + this.getText().toString().length(),this.getWidth()-28*escala, 17*escala, p2);
    }

}
