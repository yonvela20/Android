package com.example.ionber.pruebacrono;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.app.Activity;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    //Definimos las variables que usaremos. Texto, botones, String e Hilo.
    public TextView txtReloj;
    //public TextView txtImporte;
    Button btnArrancar;
    Button btnPausar;
    Button btnParar;
    Boolean arranque=false;
    Boolean pause=false;
    double precio=60; //Precio en €/hora
    private String crono;
    //private String crono2;
    MiHilo mihilo;
    public TextView txtTiempo;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Asociamos variables con main.xml
        txtReloj = (TextView) findViewById(R.id.txtReloj);
        //txtImporte = (TextView) findViewById(R.id.txtImporte);
        btnArrancar = (Button) findViewById(R.id.BtnArrancar);
        btnPausar = (Button) findViewById(R.id.BtnPausar);
        btnParar = (Button) findViewById(R.id.BtnParar);

        //Establecemos texto en los botones y arrancamos el hilo
        mihilo = new MiHilo(txtReloj);
        //,precio,txtImporte
        mihilo.start();

        //Listener del botón Arrancar
        btnArrancar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                //Pongo el hilo a funcionar, los boolean a arrancado y no pause y actualizo botones
                mihilo.setPausado(false);
                mihilo.setDetenido(false);

                btnArrancar.setEnabled(false);
                btnParar.setEnabled(false);
                btnPausar.setEnabled(true);
            }

        });

        //Listener del botón pausar
        btnPausar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                //Cuando aprieto el pause
                mihilo.setPausado(true);

                btnArrancar.setEnabled(true);
                btnParar.setEnabled(true);
                btnPausar.setEnabled(false);
            }

        });

        //Listener del botón parar
        btnParar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                //Cuando aprieto el parar
                btnArrancar.setEnabled(true);
                btnParar.setEnabled(false);
                btnPausar.setEnabled(false);

                mihilo.setCentesimas(0);
                mihilo.setSegundos(0);
                mihilo.setMinutos(0);
                mihilo.setHoras(0);
                //mihilo.setEuros(0);

                crono = "00:00:00:00";
                //crono2 = "000,00";
                txtReloj.setText(crono);
                //txtImporte.setText(crono2);

                mihilo.setPausado(true);
            }

        });

    }
}
