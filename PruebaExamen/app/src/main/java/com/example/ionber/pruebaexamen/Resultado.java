package com.example.ionber.pruebaexamen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Resultado extends AppCompatActivity {

    Spinner miSpinner2;
    final static String menu2[] = {"Acerca de ", "Pantalla dibujo "};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        //Menu con Acerca de y la Pantalla del dibujo

        miSpinner2 = (Spinner) findViewById(R.id.spinner2);

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item, menu2);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        miSpinner2.setAdapter(adaptador);


        miSpinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView arg0, View arg1, int position, long id) {
                String mensaje = "La pantalla seleccionada es: " + menu2[position];
                showToast(mensaje);
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        //Texto del editText
        final TextView peso = (TextView) findViewById(R.id.peso);
        final TextView zona = (TextView) findViewById(R.id.zona);
        final TextView tarifa = (TextView) findViewById(R.id.tarifa);
        final TextView decoracion = (TextView) findViewById(R.id.decoracion);


        Bundle bundlePeso = getIntent().getExtras();
        peso.setText(bundlePeso.getString("PESO"));

        Bundle bundleZonas = getIntent().getExtras();
        zona.setText(bundleZonas.getString("ZONAS"));

        Bundle bundleTarifa = getIntent().getExtras();
        tarifa.setText(bundleTarifa.getString("TARIFA"));

        Bundle bundleDecoracion = getIntent().getExtras();
        decoracion.setText(bundleDecoracion.getString("DETALLE"));
    }

    public void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}
