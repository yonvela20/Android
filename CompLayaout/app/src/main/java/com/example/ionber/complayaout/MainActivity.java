package com.example.ionber.complayaout;

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

        final Button botonLinear = (Button) findViewById(R.id.botonLinear);
        final Button botonTable = (Button) findViewById(R.id.botonTable);
        final Button botonRelative = (Button) findViewById(R.id.botonRelative);
        final Button botonCheckBox = (Button) findViewById(R.id.botonCheckBox);
        final Button botonRadioButton = (Button) findViewById(R.id.botonRadioButton);
        final Button botonToggle = (Button) findViewById(R.id.botonToggle);

        //boton Linear Pantalla 1
        botonLinear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent miIntent1 = new Intent(MainActivity.this, Pantalla1.class);
                startActivity(miIntent1);
            }
        });

        //boton Table Pantalla 2
        botonTable.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent miIntent2 = new Intent(MainActivity.this, Pantalla2.class);
                startActivity(miIntent2);
            }
        });

        //boton Relative Pantalla 3
        botonRelative.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent miIntent3 = new Intent(MainActivity.this, Pantalla3.class);
                startActivity(miIntent3);
            }
        });

        //boton Radio Button Pantalla 4
        botonRadioButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent miIntent4 = new Intent(MainActivity.this, Pantalla4.class);
                startActivity(miIntent4);
            }
        });

        //boton Check Box Pantalla 5
        botonCheckBox.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent miIntent5 = new Intent(MainActivity.this, Pantalla5.class);
                startActivity(miIntent5);
            }
        });

        //boton Toggle Pantalla 6
        botonToggle.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent miIntent6 = new Intent(MainActivity.this, Pantalla6.class);
                startActivity(miIntent6);
            }
        });
    }
}
