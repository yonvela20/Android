package com.example.ionber.pruebacrono;

/**
 * Created by ionber on 16/02/18.
 */

import android.widget.TextView;

public class MiHilo extends Thread
{
    public boolean detenido;
    public boolean pausado;
    double euros = 00;
    int centesimas = 00,minutos=00, segundos=00, horas=00;
    double precio;
    Hand handler,handler2;
    String cron,cron2;
    //Cron c;

    //Cuando incio el hilo ya está detenido a false y pausado a true
    public MiHilo(TextView t)
    //, double p, TextView cs
    {
        //precio = p/3600;
        //c = new Cron();
        detenido = false;
        pausado = true;
        handler = new Hand(t);
        //handler2 = new Hand(cs);
    }

    @SuppressWarnings("static-access")
    public void run()
    {
        while(!detenido)
        {
            while(!pausado)
            {
                try {
                    if(centesimas == 99){
                        centesimas = 00;
                        segundos++;
                        euros=euros+precio;
                    }
                    if (segundos == 59) {
                        segundos = 00;
                        minutos++;
                    }
                    if (minutos == 59) {
                        minutos = 00;
                        horas++;
                    }

                    centesimas++;

                    cron2 = euros+"";
                    cron = horas + " : " + minutos + " : " + segundos + " : " + centesimas;
                    handler.setHcron(cron);
                    //handler2.setHcron(cron2);
                    handler.act();
                    //handler2.act();
                    this.sleep(9);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

/*    public void setPrecio(int p)
    {
        this.precio=p;
    }
    public double getPrecio()
    {
        return precio;
    }
    public void setEuros(int e)
    {
        this.euros=e;
    }
    public double getEuros()
    {
        return euros;
    } */
    public void setDetenido(boolean detenido) {
        this.detenido = detenido;
    }
    public void setPausado(boolean pausado) {
        this.pausado = pausado;
    }
    public void setCentesimas(int centesimas) {
        this.centesimas = centesimas;
    }
    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }
    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }
    public void setHoras(int horas) {
        this.horas = horas;
    }
}
