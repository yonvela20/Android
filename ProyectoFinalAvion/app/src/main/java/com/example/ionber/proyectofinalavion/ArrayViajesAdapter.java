package com.example.ionber.proyectofinalavion;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ArrayViajesAdapter extends ArrayAdapter<Viajes>{
    Context context;
    Viajes [] arrViajes;
    private TextView textViewPrecio, textViewOrigen,textViewDestino,tvId;
    ImageView imageView ;


    public ArrayViajesAdapter(Context context, Viajes [] arrViajes) {
        super(context, R.layout.spinner_helper, arrViajes);
        this.context = context;
        this.arrViajes= arrViajes ;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (view == null){
            view = inflater.inflate(R.layout.spinner_helper,null);
        }

        textViewPrecio = view.findViewById(R.id.precio);
        textViewOrigen =  view.findViewById(R.id.origen);
        textViewDestino =  view.findViewById(R.id.destino);
        tvId = view.findViewById(R.id.id);

        imageView= view.findViewById(R.id.image);

        String cast = Float.toString(arrViajes[position].getPrecio());

        String cast2 = Integer.toString(arrViajes[position].getId());



        textViewPrecio.setText(cast);
        textViewOrigen.setText(arrViajes[position].getOrigen());
        textViewDestino.setText(arrViajes[position].getDestino());
        tvId.setText(cast2);

        switch (arrViajes[position].getId()){
            case 1:
                imageView.setImageResource(R.drawable.viaje1);
                break;
            case 2:
                imageView.setImageResource(R.drawable.viaje2);
                break;
            case 3:
                imageView.setImageResource(R.drawable.viaje3);
                break;
            default:
                break;
        }

        return view;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getView(position,convertView,parent);
    }


}