package com.example.ionber.recupmm;

/**
 * Created by ionber on 16/02/18.
 */
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

//Esta clase se encarga de que en el textView se representen los valores del tiempo

public class Helper extends Handler
{
    String crono;
    TextView tiempo;

    public Helper(TextView tiempo)
    {
        this.tiempo = tiempo;
    }
    public void handleMessage(Message msg)
    {
        tiempo.setText(crono);
    }
    public void setCrono(String crono) {
        this.crono = crono;
    }
    public void act()
    {
        super.sendEmptyMessage(0);
    }
}