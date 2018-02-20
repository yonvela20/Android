package com.example.ionber.recupmm;

import android.content.Context;
import android.content.Intent;
import android.database.SQLException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Definimos las variables que usaremos. Texto, botones, String e Hilo.
    public TextView txtReloj;
    Button btnArrancar;
    Button btnPausar;
    Button btnParar;
    Boolean arranque=false;
    Boolean pause=false;
    private String crono;
    MiHilo mihilo;

    //referencias a elementos de pantalla
    TextView mItem = null;
    TextView mPlace = null;
    //identificador de entrada
    Integer mRowId = null;

    public static DataBaseHelper mDbHelper = null;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtReloj = (TextView) findViewById(R.id.txtReloj);
        btnArrancar = (Button) findViewById(R.id.buttonArranca);
        btnPausar = (Button) findViewById(R.id.buttonPausa);
        btnParar = (Button) findViewById(R.id.buttonReinicio);

        //Arrancamos el hilo
        mihilo = new MiHilo(txtReloj);
        mihilo.start();

        //Arrancar
        btnArrancar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                //Se inicia el hilo con el arranque y ponemos los botones que no son necesarios deshabilitados
                mihilo.setPausado(false);
                mihilo.setDetenido(false);

                btnArrancar.setEnabled(false);
                btnParar.setEnabled(false);
                btnPausar.setEnabled(true);
            }

        });

        //Guardar
        Button saveBtn = (Button) findViewById(R.id.add);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                setResult(RESULT_OK);
                saveData();
                finish();
            }
        });

        //Pausa con los botones necesarios habilitados
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

        //Parar con los botones necesarios habilitados
        btnParar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                btnArrancar.setEnabled(true);
                btnParar.setEnabled(false);
                btnPausar.setEnabled(false);

                mihilo.setCentesimas(0);
                mihilo.setSegundos(0);
                mihilo.setMinutos(0);
                mihilo.setHoras(0);

                crono = "00:00:00:00";

                txtReloj.setText(crono);

                mihilo.setPausado(true);
            }

        });

    }
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    //Menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.AcercaDe:
                Intent intent = new Intent(MainActivity.this, AcerdaDe.class);
                startActivity(intent);
                return true;
            case R.id.MisHorarios:
                Intent intent2 = new Intent(MainActivity.this, MisHorarios.class);
                startActivity(intent2);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //Mostrar mensaje
    private void showMessage(String message) {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, message, duration);
        toast.show();
    }

    //Guardar datos
    protected void saveData() {
        //obtener datos
        String itemText = mItem.getText().toString();
        String placeText = mPlace.getText().toString();

        try {
            MainActivity.mDbHelper.open();
            if (mRowId == null){
                //insertar
                MainActivity.mDbHelper.insertItem(itemText, placeText);
            }
            else{
                //actualizar
                TextView tv = (TextView)findViewById(R.id.txtReloj);
                String ident = tv.getText().toString();
                MainActivity.mDbHelper.updateItem(Integer.parseInt(ident),itemText, placeText);
            }
            MainActivity.mDbHelper.close();
        } catch (SQLException e) {
            e.printStackTrace();
            showMessage("Error");
        }
    }
}
