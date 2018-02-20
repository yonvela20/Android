package com.example.ionber.vidaapp;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Pantalla2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);

        final TextView otroSaludo = (TextView) findViewById(R.id.saludo2);

        Bundle recogerBundle = getIntent().getExtras();
        otroSaludo.setText(recogerBundle.getString("TEXTO"));

        showToast(recogerBundle.getString("TEXTO"));
    }

    protected void onStart() {
        super.onStart();
        Toast.makeText(this,"onStart - A2", Toast.LENGTH_SHORT).show();
    }

    protected void onResume() {
        super.onResume();
        Toast.makeText(this,"onResume - A2", Toast.LENGTH_SHORT).show();
    }

    protected void onPause() {
        Toast.makeText(this,"onPause - A2", Toast.LENGTH_SHORT).show();
        super.onPause();
    }

    protected void onStop() {
        super.onStop();
        Toast.makeText(this,"onStop - A2", Toast.LENGTH_SHORT).show();
    }

    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this,"onRestart - A2", Toast.LENGTH_SHORT).show();
    }

    protected void onDestroy() {
        Toast.makeText(this,"onDestroy - A2", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }
    protected void showToast(CharSequence text){

        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}
