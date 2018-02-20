package com.example.ionber.proyectofinalavion;

/**
 * Created by ionber on 20/02/18.
 */

public class Viajes {

    private String origen;
    private float precio;
    private String destino;
    //private String extras;
    int ids;

    public Viajes(String org, float pre, String dest,int id) {
        origen = org;
        precio = pre;
        destino = dest;
        ids = id;


    }

    //public String getExtras() {
     //   return extras;
    //}

    public String getDestino() {
        return destino;
    }

    public float getPrecio() {
        return precio;
    }

    public String getOrigen() {
        return origen;
    }

    public int getId() {
        return ids;
    }
}
