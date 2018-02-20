package com.example.ionber.ejerciciolayoutbotones;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Se declaran los botones
        final Button pantalla1 = (Button) findViewById(R.id.pantalla1);
        final Button pantalla2 = (Button) findViewById(R.id.pantalla2);
        final Button pantalla3 = (Button) findViewById(R.id.pantalla3);
        final Button pantalla4 = (Button) findViewById(R.id.pantalla4);


        //Intent de las pantallas
        pantalla1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent miIntent1 = new Intent(MainActivity.this, Pantalla1.class);
                startActivity(miIntent1);
            }
        });

        pantalla2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent miIntent2 = new Intent(MainActivity.this, Pantalla2.class);
                startActivity(miIntent2);
            }
        });

        pantalla3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent miIntent3 = new Intent(MainActivity.this, Pantalla3.class);
                startActivity(miIntent3);
            }
        });

        pantalla4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent miIntent4 = new Intent(MainActivity.this, Pantalla4.class);
                startActivity(miIntent4);
            }
        });
    }
}
