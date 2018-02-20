package com.example.ionber.dibujos;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new EjemploView(this));
    }

    public class EjemploView extends View {
        public EjemploView(Context contexto){
            super(contexto);
        }

        protected void onDraw(Canvas canvas){
            int ancho = canvas.getWidth();
            int largo = canvas.getHeight();

            Paint pincel = new Paint();
            pincel.setStrokeWidth(15);
            pincel.setStyle(Paint.Style.STROKE);

            pincel.setColor(Color.BLUE);
            canvas.drawCircle(540, 800 , 450, pincel);
            pincel.setColor(Color.YELLOW);
            canvas.drawCircle(540, 800 , 400, pincel);
            pincel.setColor(Color.GREEN);
            canvas.drawCircle(540, 800 , 350, pincel);
            pincel.setColor(Color.RED);
            canvas.drawCircle(540, 800 , 300, pincel);
            pincel.setColor(Color.GRAY);
            canvas.drawCircle(540, 800 , 250, pincel);
            pincel.setColor(Color.MAGENTA);
            canvas.drawCircle(540, 800 , 200, pincel);
            pincel.setColor(Color.CYAN);
            canvas.drawCircle(540, 800 , 150, pincel);

            pincel.setColor(Color.BLACK);
            canvas.drawRect(10, 10, ancho-10, largo-10, pincel);

            canvas.drawPoint(540, 800, pincel);


            BitmapDrawable imagen;

            Resources res = this.getResources();
            imagen = (BitmapDrawable)res.getDrawable(R.drawable.pepe);
            imagen.setBounds(new Rect(70, 70, 500, 500));

            imagen.draw(canvas);
        }
    }
}
