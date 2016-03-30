package net.sgoliver.android.holausuario;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by xIS11613 on 29/03/2016.
 */
public class TresEnRaya extends View {

    public static final int VACIA = 0;
    public static final int FICHA_O = 1;
    public static final int FICHA_X = 2;

    private int[][] tablero;
    private int fichaActiva;
    private int xColor;
    private int oColor;

    private OnCasillaSeleccionadaListener listener;

    public TresEnRaya(Context context) {
        super(context);
        inicializacion ();
    }

    public TresEnRaya(Context context, AttributeSet attrs) {
        super(context, attrs);
        inicializacion ();

        // Procesamos los atributos XML personalizados
        TypedArray a =
                getContext().obtainStyledAttributes(attrs,
                        R.styleable.TresEnRaya);

        oColor = a.getColor(
                R.styleable.TresEnRaya_ocolor, Color.BLUE);

        xColor = a.getColor(
                R.styleable.TresEnRaya_xcolor, Color.RED);

        a.recycle();
    }

    public TresEnRaya(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inicializacion ();
    }

    private void inicializacion () {

        tablero = new int[3][3];
        limpiar ();
        fichaActiva = FICHA_X;
        xColor = Color.RED;
        oColor = Color.BLUE;

    }

    private void limpiar () {

        for (int i = 0; i<tablero.length;i++) {
            for (int j = 0; j<tablero [i].length; j++) {
                tablero [i][j] = VACIA;
            }
        }

    }

    public void setFichaActiva (int ficha) {
        fichaActiva = ficha;
    }

    public int getFichaActiva () {
        return fichaActiva;
    }

    public void alternarFichaActiva () {
        if (FICHA_O == fichaActiva) {
            setFichaActiva(FICHA_X);
        } else {
            setFichaActiva(FICHA_O);
        }
    }

    public int getXColor () {
        return xColor;
    }

    public void setXColor (int color) {
        this.xColor = color;
    }

    public int getOColor () {
        return oColor;
    }

    public void setOColor (int color) {
        this.oColor = color;
    }

    public void setCasilla (int fila, int col, int valor) {
        tablero [fila][col] = valor;
    }

    public int getCasilla (int fila, int col) {
        return tablero [fila] [col];
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int ancho = calcularAncho (widthMeasureSpec);
        int alto = calcularAlto (heightMeasureSpec);

        if (ancho<alto)
            ancho = alto;
        else
            alto = ancho;

        setMeasuredDimension(ancho, alto);
    }

    private int calcularAlto (int limitesSpec){
        int res = 100; //Alto por defecto

        int modo = MeasureSpec.getMode(limitesSpec);
        int limite = MeasureSpec.getSize(limitesSpec);

        if (modo == MeasureSpec.AT_MOST || modo == MeasureSpec.EXACTLY) {
            res = limite;
        }

        return res;
    }

    private int calcularAncho (int limitesSpec) {
        int res = 100; //Ancho por defecto

        int modo = MeasureSpec.getMode(limitesSpec);
        int limite = MeasureSpec.getSize(limitesSpec);

        if (modo == MeasureSpec.AT_MOST || modo == MeasureSpec.EXACTLY) {
            res = limite;
        }

        return res;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //super.onDraw(canvas);
        //Obtenemos las dimensiones del control
        int alto = getMeasuredHeight();
        int ancho = getMeasuredWidth();

        //Lineas
        Paint pBorde = new Paint();
        pBorde.setStyle(Paint.Style.STROKE);
        pBorde.setColor(Color.BLACK);
        pBorde.setStrokeWidth(2);

        canvas.drawLine(ancho / 3, 0, ancho / 3, alto, pBorde);
        canvas.drawLine(2* ancho/3,0,2* ancho/3, alto, pBorde);

        canvas.drawLine(0, alto/3, ancho, alto/3, pBorde);
        canvas.drawLine(0, 2 * alto / 3, ancho, 2 * alto / 3, pBorde);

        //Marco
        canvas.drawRect(0, 0, ancho, alto, pBorde);

        //Marcas
        Paint pMarcaO = new Paint ();
        pMarcaO.setStyle(Paint.Style.STROKE);
        pMarcaO.setStrokeWidth(8);
        pMarcaO.setColor(oColor);

        Paint pMarcaX = new Paint();
        pMarcaX.setStyle(Paint.Style.STROKE);
        pMarcaX.setColor(xColor);
        pMarcaO.setStrokeWidth(8);

        //Casillas seleccionadas
        for (int fil = 0; fil<tablero.length; fil++) {
            for (int col=0; col<tablero[fil].length; col++) {
                int ficha = getCasilla(fil,col);
                if (FICHA_O == ficha) {
                    //Pintamos Círculo
                    canvas.drawCircle(((col*ancho/3)+ (ancho/6)),
                                      ((fil*alto/3)+ (alto/6)),
                                      ancho/6 * 0.8f, pMarcaO);
                } else if (FICHA_X == ficha) {
                    //Pintamos Cuadrado
                    canvas.drawLine(col * ancho/3 + ancho/3 * 0.1f,
                                    fil* alto/3 + alto/3 *0.1f,
                                    col+1 * ancho/3 + ancho/3 * 0.9f,
                                    fil+1 * alto/3 + alto*3 * 0.9f,
                                    pMarcaX);
                    canvas.drawLine(col * ancho/3 + ancho/3 * 0.9f,
                                    fil* alto/3 + alto/3 *0.1f,
                                    col+1 * ancho/3 + ancho/3 * 0.1f,
                                    fil+1 * alto/3 + alto*3 * 0.9f,
                                    pMarcaX);
                }
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int fil = (int) (event.getX() / (getMeasuredWidth()/3));
        int col = (int) (event.getY() / (getMeasuredHeight()/3));

        //Actualizamos el tablero
        tablero [fil][col] = fichaActiva;

        //Lanzamos el evento de pulsación
        if (listener != null) {
            listener.onCasillaSeleccionada(fil, col);
        }

        //Refrescamos el control
        invalidate();

        return super.onTouchEvent(event);
    }

    public void setOnCasillaSeleccionadaListener (OnCasillaSeleccionadaListener l) {
        listener = l;
    }

}
