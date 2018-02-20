package com.example.ionber.proyectofinalavion;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String [] columnas = {"id" , "destino", "origen", "precio"};
    Viajes [] arrViajes;
    SQLiteDatabase sqLiteDatabase;

    static class ViewHolder {
        TextView origen;
        TextView precio;
        TextView destino;
        ImageView img;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText tvViajes = (EditText) findViewById(R.id.editText);
        final Spinner miSpinner = (Spinner) findViewById(R.id.spinner);
        DataBaseHelper bocadilloHelper = new DataBaseHelper(this, "dbViajes", null, 1);
        sqLiteDatabase = bocadilloHelper.getWritableDatabase();



        Cursor cursor = sqLiteDatabase.query("viajes", columnas,null,null,null,null,null);

        //Inicializamos el array con el tamaño que tenga el cursor al hacer el conteo
        arrViajes = new Viajes[cursor.getCount()];

        //recoger los datos de la BD y los almaceno en un array
        if (cursor.moveToFirst()){
            int i = 0;
            do {
                int id = cursor.getInt(0);
                String destino = cursor.getString(1);
                String origen = cursor.getString(2);
                float precio = cursor.getFloat(3);


                arrViajes[i] = new Viajes(origen, precio, destino, id);
                i++;

            }while(cursor.moveToNext());
        }



        ArrayViajesAdapter arrayViajesAdapter = new ArrayViajesAdapter(this, arrViajes);
        miSpinner.setAdapter(arrayViajesAdapter);

        miSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView arg0, View arg1, int position, long id) {
                String test = "ID: "+arrViajes[position].getId();

                Toast.makeText(getApplicationContext(),test,Toast.LENGTH_SHORT).show();            }

            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        final Button botonpasar = (Button) findViewById(R.id.button);
        final RadioButton r1 = (RadioButton) findViewById(R.id.rb1);
        final RadioButton r2 = (RadioButton) findViewById(R.id.rb2);
        final CheckBox ch1 = (CheckBox) findViewById(R.id.cb1);
        final CheckBox ch2 = (CheckBox) findViewById(R.id.cb2);
        final CheckBox ch3 = (CheckBox) findViewById(R.id.cb3);

        botonpasar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cantidad = tvViajes.getText().toString();

                int canti = Integer.parseInt(cantidad);
                int pos = miSpinner.getSelectedItemPosition();
                int precio = (int) arrViajes[pos].getPrecio();
                int cont =0;

                int complementos = anyadido(cont);
                String comple = Integer.toString(complementos);

                int paso2 = cantidad(canti, precio);
                double total = envio(paso2 + complementos);

                String resultado = Double.toString(total);
                String bocadillo  = arrViajes[pos].getOrigen();
                String tipoeenvio = clase();
                String tipoextras = extras();
                int imgbocadillo = arrViajes[pos].getId();

                sqLiteDatabase.execSQL("INSERT INTO billete (id_billete,billete,cantidad,precio,clase,extras) VALUES ( '" +imgbocadillo+"',' "+ bocadillo +  "','" +cantidad +
                        "',' " +resultado+"','"+ tipoeenvio+"','"+tipoextras+"') ");

                Intent miIntent = new Intent(MainActivity.this, Factura.class);

                startActivity(miIntent);

            }

            public int anyadido(int cont) {
                if (ch1.isChecked())
                    cont++;
                if (ch2.isChecked())
                    cont++;
                if (ch3.isChecked())
                    cont++;
                return cont;
            }

            public double envio(int precio) {
                double total = 0;
                if (r2.isChecked()){
                    total = precio + precio * 0.1;
                    return total;}
                else
                    return precio;

            }

            public int cantidad(int numero, int precio) {
                int total = numero * precio;
                return total;
            }

            public String clase() {
                String x = "";
                if (r1.isChecked()) {
                    x = "En turista";
                } else if (r2.isChecked()) {
                    x = "En primera";
                }
                return x;

            }
            public String extras() {
                String x = "";
                if (ch1.isChecked())
                    x = x + " Menu ";
                if (ch2.isChecked())
                    x = x + " Souvenir ";
                if (ch3.isChecked())
                    x = x+" Tentempie ";
                return x;

            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.AcercaDe:
                Intent one = new Intent(MainActivity.this,FragmentActivity.class);
                startActivity(one);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}