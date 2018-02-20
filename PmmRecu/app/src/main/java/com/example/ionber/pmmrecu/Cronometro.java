package com.example.ionber.pmmrecu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Cronometro extends AppCompatActivity {
    private TextView horasText;
    private TextView minutosText;
    private TextView segundosText;
    private Button arrancar;
    private Button parar;
    private Button reiniciar;

    // Variables del reloj:
    private boolean arrancado;
    private int horas;
    private int minutos;
    private int segundos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cronometro);

        horasText = findViewById(R.id.activity_cronometro_horas);
        minutosText = findViewById(R.id.activity_cronometro_minutos);
        segundosText = findViewById(R.id.activity_cronometro_segundos);
        arrancar = findViewById(R.id.activity_cronometro_arrancar);
        parar = findViewById(R.id.activity_cronometro_parar);
        reiniciar = findViewById(R.id.activity_cronometro_reiniciar);

        final DataBaseHelper dbHelper = new DataBaseHelper(this);

        horas = 0;
        minutos = 0;
        segundos= 0;

        arrancar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrancado = true;
                while(arrancado) {
                    segundos += 1;
                    if (segundos < 10) {
                        segundosText.setText("0" + String.valueOf(segundos));
                    } else if (segundos < 60) {
                        segundosText.setText(String.valueOf(segundos));
                    } else {
                        segundosText.setText("00");
                        segundos = 0;

                        minutos +=1;
                        if (minutos < 10) {
                            minutosText.setText("0" + String.valueOf(minutos));
                        } else if (minutos < 60) {
                            minutosText.setText(String.valueOf(minutos));
                        } else {
                            minutosText.setText("00");
                            minutos = 0;

                            horas += 1;
                            if (horas < 10) {
                                horasText.setText("0" + String.valueOf(horas));
                            } else if (horas < 24) {
                                horasText.setText(String.valueOf(horas));
                            } else {
                                horasText.setText("00");
                                horas = 0;
                            }
                        }
                    }
                }
            }
        });

        parar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrancado = false;
                Bundle bundle = getIntent().getExtras();
                String nombreUsuario = bundle.getString(DataBaseContract.UsuarioEntry.KEY_NAME);
                String tiempo = horasText.getText().toString() + ":"
                        + minutosText.getText().toString() + ":"
                        + segundosText.getText().toString();
                Horario horario = new Horario(nombreUsuario, tiempo);
                dbHelper.insertHorario(horario);
            }
        });

        reiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                horasText.setText(R.string.crono_inicial);
                minutosText.setText(R.string.crono_inicial);
                segundosText.setText(R.string.crono_inicial);
                horas = 0;
                minutos = 0;
                segundos = 0;
            }
        });

    }
}