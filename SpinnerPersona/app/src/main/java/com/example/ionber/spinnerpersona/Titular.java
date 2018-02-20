package com.example.ionber.spinnerpersona;

/**
 * Created by ionber on 27/10/17.
 */

public class Titular {

    private String titulo;
    private String subtitulo;
    private int image;


    public Titular(String tit, String sub, int img){
        image = img;
        titulo = tit;
        subtitulo = sub;
    }

    public String getTitulo(){
        return titulo;
    }

    public String getSubtitulo(){
        return subtitulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setSubtitulo(String subtitulo) {
        this.subtitulo = subtitulo;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getImage(){
        return image;

    }

    public String toString(){return(titulo + " , " + subtitulo);}
}
