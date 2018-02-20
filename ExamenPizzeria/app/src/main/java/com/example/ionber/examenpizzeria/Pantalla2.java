package com.example.ionber.examenpizzeria;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.AnalogClock;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

public class Pantalla2 extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);

        final TextView textView = (TextView)findViewById(R.id.miMensaje);
        final TextView textView1 = (TextView)findViewById(R.id.miMensaje1);
        final TextView textView2 = (TextView)findViewById(R.id.miMensaje2);
        final TextView textView3 = (TextView)findViewById(R.id.miMensaje3);
        final TextView textView4 = (TextView)findViewById(R.id.miMensaje4);
        final TextView textView5 = (TextView)findViewById(R.id.miMensaje5);
        final ImageView imagen  = (ImageView)findViewById(R.id.imageView2);
        final AnalogClock c1 = (AnalogClock)findViewById(R.id.analogClock);

        Bundle  miBundleRecoger = getIntent().getExtras();
        textView1.setText(miBundleRecoger.getString("PIZZA"));
        textView2.setText(miBundleRecoger.getString("PRECIO"));
        textView3.setText(miBundleRecoger.getString("EXTRA"));
        textView4.setText(miBundleRecoger.getString("UNIDAD"));
        textView5.setText(miBundleRecoger.getString("SELECCION"));
        textView.setText(miBundleRecoger.getString("TEXTO"));
        imagen.setBackgroundDrawable(getResources().getDrawable(miBundleRecoger.getInt("IMAGEN")));

    }
}
