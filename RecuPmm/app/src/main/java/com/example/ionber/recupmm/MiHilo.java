package com.example.ionber.recupmm;

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
    Helper handler;
    String cron;

    //Cuando incio el hilo ya está detenido a false y pausado a true
    public MiHilo(TextView tiempo)
    {
        detenido = false;
        pausado = true;
        handler = new Helper(tiempo);
    }

    //metodo mediante el cual el reloj es funcional
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

                    cron = horas + " : " + minutos + " : " + segundos + " : " + centesimas;
                    handler.setCrono(cron);
                    handler.act();
                    this.sleep(9);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    //Setters
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