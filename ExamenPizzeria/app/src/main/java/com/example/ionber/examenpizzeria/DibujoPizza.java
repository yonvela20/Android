package com.example.ionber.examenpizzeria;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DibujoPizza extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new dibujo (this));
    }

    public class dibujo extends View {
        public dibujo(Context contexto){
            super(contexto);
        }

        protected void onDraw(Canvas canvas){

            Paint pincel = new Paint();
            pincel.setStrokeWidth(15);
            pincel.setStyle(Paint.Style.STROKE);

            pincel.setColor(Color.BLACK);

            canvas.drawCircle(540, 800 , 450, pincel);
            canvas.drawCircle(540, 800 , 400, pincel);
            canvas.drawCircle(580, 880 , 40, pincel);
            canvas.drawCircle(510, 863 , 40, pincel);
            canvas.drawCircle(320, 657 , 40, pincel);
            canvas.drawCircle(657, 247 , 40, pincel);
            canvas.drawCircle(740, 458 , 40, pincel);
        }
    }
}
