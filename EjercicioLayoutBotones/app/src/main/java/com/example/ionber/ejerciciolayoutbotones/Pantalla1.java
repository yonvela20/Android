package com.example.ionber.ejerciciolayoutbotones;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class Pantalla1 extends AppCompatActivity {

    RadioButton botonRojo;
    RadioButton botonVerde;
    RadioButton botonAzul;
    Button botonColor;
    Button botonCancelar;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla1);
        initialUISetup();
    }
    public void initialUISetup() {
        botonRojo = (RadioButton) findViewById(R.id.radioButton1);
        botonVerde = (RadioButton) findViewById(R.id.radioButton2);
        botonAzul = (RadioButton) findViewById(R.id.radioButton3);
        botonColor = (Button) findViewById(R.id.botonColor);
        botonCancelar = (Button) findViewById(R.id.botonCancelar);
        textView = (TextView) findViewById(R.id.textView);

        botonColor.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                getColor(v);
            }
        });

        botonCancelar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                textView.setBackgroundColor(Color.WHITE);
            }
        });
    }
    public void getColor(View v){

        if (botonRojo.isChecked()){
            textView.setBackgroundColor(Color.RED);
        }

        if (botonVerde.isChecked()){
            textView.setBackgroundColor(Color.GREEN);
        }

        if (botonAzul.isChecked()){
            textView.setBackgroundColor(Color.BLUE);
        }
    }
}

