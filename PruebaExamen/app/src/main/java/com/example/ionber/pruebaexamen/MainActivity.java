package com.example.ionber.pruebaexamen;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner miSpinner;
    final static String zonas[] = {"Zona A: Asia y Oceanía: 30€", "Zona B: América y África: 20€", "Zona C: Europa: 10€"};
    CheckBox tarjeta;
    CheckBox regalo;
    String strMensaje = "";
    String tarifaMsg = "";
    RadioButton TarifaNormal;
    RadioButton TarifaUrgente;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //CREACION DEL SPINNER
        miSpinner = (Spinner) findViewById(R.id.spinner1);

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item, zonas);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        miSpinner.setAdapter(adaptador);

        miSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView arg0, View arg1, int position, long id) {
                String mensaje = zonas[position];
                showToast(mensaje);
            }
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        //DECLARACION DE ELEMENTOS
        final EditText miTexto = (EditText) findViewById(R.id.editText);
        final Spinner textoSpinner = (Spinner) findViewById(R.id.spinner1);
        final CheckBox textoChk1 = (CheckBox) findViewById(R.id.checkBox1);
        final CheckBox textoChk2 = (CheckBox) findViewById(R.id.checkBox2);

        //BOTON CALCULO
        final Button botonpasar = (Button) findViewById(R.id.button);
        botonpasar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent miIntent = new Intent(MainActivity.this, Resultado.class);

                Bundle bundlePeso = new Bundle();
                Bundle bundleZona = new Bundle();
                Bundle bundleTarifa = new Bundle();
                Bundle bundleDetalle = new Bundle();

                String mensajePeso = "El peso es: " + miTexto.getText();
                bundlePeso.putString("PESO", mensajePeso);


                String mensajeZonas = "La zona es: " + textoSpinner.getSelectedItem();
                bundleZona.putString("ZONAS", mensajeZonas);

                getTarifa(v);
                bundleDetalle.putString("DETALLE", tarifaMsg);

                getDetalleClick(v);
                bundleDetalle.putString("DETALLE", strMensaje);

                miIntent.putExtras(bundlePeso);
                miIntent.putExtras(bundleZona);
                miIntent.putExtras(bundleTarifa);
                miIntent.putExtras(bundleDetalle);

                startActivity(miIntent);
            }
        });
        initialUISetup();
    }

    public void initialUISetup() {
        tarjeta = (CheckBox) findViewById(R.id.checkBox1);
        regalo  = (CheckBox) findViewById(R.id.checkBox2);
    }
    public void getDetalleClick(View v) {
        strMensaje = "";
        if (tarjeta.isChecked()) {
            strMensaje = " Caja regalo ";
        }if (regalo.isChecked()) {
            strMensaje = "Tarjeta Personalizada  ";
        } if (tarjeta.isChecked() && regalo.isChecked()){
            strMensaje = "Tarjeta Personalizada y Caja Regalo";
        }
    }

    public void getTarifa(View v){
        final RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId){
                if(radioGroup.getCheckedRadioButtonId() == R.id.radioButton1){
                    tarifaMsg = "Tarifa normal";
                } if (radioGroup.getCheckedRadioButtonId() == R.id.radioButton2){
                    tarifaMsg = "Tarifa urgente";
                }
            }
        });

    }

    public void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

}
