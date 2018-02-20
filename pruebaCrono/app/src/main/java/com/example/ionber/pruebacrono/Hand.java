package com.example.ionber.pruebacrono;

/**
 * Created by ionber on 16/02/18.
 */

import android.os.Handler;
import android.os.Message;
import android.widget.TextView;


public class Hand extends Handler
{
    String hcron;
    TextView tiempo;

    public Hand(TextView t)
    {
        tiempo = t;
    }
    public void handleMessage(Message msg)
    {
        tiempo.setText(hcron);
    }
    public void setHcron(String hcron) {
        this.hcron = hcron;
    }
    public void act()
    {
        super.sendEmptyMessage(0);
    }
}