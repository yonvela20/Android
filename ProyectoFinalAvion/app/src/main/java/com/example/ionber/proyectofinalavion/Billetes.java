package com.example.ionber.proyectofinalavion;

/**
 * Created by ionber on 20/02/18.
 */

import java.io.Serializable;

public class Billetes implements Serializable{

    private int cantidad ;
    private String billete,clase,extra;
    private float precio;

    public Billetes(float pre, String bill, int cant, String cla, String ext){

        this.billete = bill;
        this.cantidad = cant;
        this.clase = cla;
        this.extra = ext;
        this.precio = pre;

    }

    public float getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getExtra() {
        return extra;
    }

    public String getClase() {
        return clase;
    }

    public String getBillete() {
        return billete;
    }
}