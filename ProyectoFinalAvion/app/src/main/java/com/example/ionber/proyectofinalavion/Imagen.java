package com.example.ionber.proyectofinalavion;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Imagen extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return new EjemploView(this.getContext());
    }

    public class EjemploView extends View {
        public EjemploView(Context contexto) {
            super(contexto);
            Resources res = contexto.getResources();

        }

        protected void onDraw(Canvas canvas) {

            Paint pincel = new Paint();
            pincel.setColor(Color.YELLOW);
            pincel.setStrokeWidth(30);
            pincel.setStyle(Paint.Style.STROKE);
            canvas.drawCircle(530, 500, 150, pincel);
            pincel.setStyle(Paint.Style.FILL_AND_STROKE);
            pincel.setColor(Color.RED);
            canvas.drawCircle(530, 500, 130, pincel);
            pincel.setStrokeWidth(3);
            pincel.setTextSize(50);
            pincel.setTypeface(Typeface.DEFAULT_BOLD);
            pincel.setColor(Color.BLACK);
            canvas.drawText("Hecho por Ion Vela",200,1400,pincel);
        }
    }
}