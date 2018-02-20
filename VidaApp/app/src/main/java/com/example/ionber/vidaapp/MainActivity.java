package com.example.ionber.vidaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText miTexto = (EditText) findViewById(R.id.miTxt);

        miTexto.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                String borrado = " ";
                miTexto.setText(borrado);
            }
        });

        final Button miBoton = (Button) findViewById(R.id.BotonSaludo);
        final TextView elSaludo = (TextView) findViewById(R.id.miLbl);

        Toast.makeText(this, "Estoy en la pantalla 1", Toast.LENGTH_SHORT).show();

        miBoton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent miIntent = new Intent(MainActivity.this, Pantalla2.class);

                Bundle miBundle = new Bundle();
                String mensajePaso = "Te saludo " + miTexto.getText();

                miBundle.putString("TEXTO", mensajePaso);
                miIntent.putExtras(miBundle);

                startActivity(miIntent);
            }
        });
    }

    protected void onStart() {
        super.onStart();
        Toast.makeText(this,"onStart - A1", Toast.LENGTH_SHORT).show();
    }

    protected void onResume() {
        super.onResume();
        Toast.makeText(this,"onResume - A1", Toast.LENGTH_SHORT).show();
    }

    protected void onPause() {
        Toast.makeText(this,"onPause - A1", Toast.LENGTH_SHORT).show();
        super.onPause();
    }

    protected void onStop() {
        super.onStop();
        Toast.makeText(this,"onStop - A1", Toast.LENGTH_SHORT).show();
    }

    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this,"onRestart - A1", Toast.LENGTH_SHORT).show();
    }

    protected void onDestroy() {
        Toast.makeText(this,"onDestroy - A1", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }
}
