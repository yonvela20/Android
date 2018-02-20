package com.example.ionber.proyectofinalavion;

import android.app.ListActivity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DigitalClock;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Factura extends ListActivity {
    private Viajes viajes;
    TextView nom;
    String[] columnaspedidos = new String[]{"billete", "cantidad", "precio", "clase", "extras", "id_billete"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factura);
        fillData();
    }

    //Recogemos de la BD y rellenamos en la APP
    private void fillData() {
        DataBaseHelper dataBaseHelper = new DataBaseHelper(this, "dbViajes", null, 1);
        SQLiteDatabase sqLiteDatabase = dataBaseHelper.getWritableDatabase();

        Cursor itemCursor = sqLiteDatabase.query("billete", columnaspedidos, null, null, null, null, null);
        InfoBilletes item = null;

        ArrayList<InfoBilletes> resultList = new ArrayList<>();

        while (itemCursor.moveToNext()) {
            float precioget = itemCursor.getFloat(itemCursor.getColumnIndex("precio"));
            String extrasget = itemCursor.getString(itemCursor.getColumnIndex("extras"));
            String claseget = itemCursor.getString(itemCursor.getColumnIndex("clase"));
            String billeteget = itemCursor.getString(itemCursor.getColumnIndex("billete"));
            int cantidadget = itemCursor.getInt(itemCursor.getColumnIndex("cantidad"));
            int ids = itemCursor.getInt(itemCursor.getColumnIndex("id_billete"));

            item = new InfoBilletes();

            item.id = ids;
            item.extras = extrasget;
            item.clase = claseget;
            item.precio = precioget;
            item.cantidad = cantidadget;
            item.billete = billeteget;
            resultList.add(item);
        }
        itemCursor.close();
        sqLiteDatabase.close();

        TaskAdapter items = new TaskAdapter(this, R.layout.list_adapter, resultList, getLayoutInflater());
        setListAdapter(items);
    }

    private class InfoBilletes {
        int id;
        String extras;
        String clase;
        int cantidad;
        String billete;
        float precio;
    }

    private class TaskAdapter extends ArrayAdapter<InfoBilletes> {
        private LayoutInflater mInflater;
        private List<InfoBilletes> mObjects;

        private TaskAdapter(Context context, int resource, List<InfoBilletes> objects, LayoutInflater mInflater) {
            super(context, resource, objects);
            this.mInflater = mInflater;
            this.mObjects = objects;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            InfoBilletes listEntry = mObjects.get(position);

            View row = mInflater.inflate(R.layout.list_adapter, null);

            TextView extras = (TextView) row.findViewById(R.id.row_extras);
            TextView clase = (TextView) row.findViewById(R.id.row_clase);
            TextView billete = (TextView) row.findViewById(R.id.row_billete);
            TextView precio = (TextView) row.findViewById(R.id.row_precio);
            TextView cantidad = (TextView) row.findViewById(R.id.row_cantidad);
            TextView cliente = (TextView) row.findViewById(R.id.clienteName);

            extras.setText(listEntry.extras);
            clase.setText(listEntry.clase);
            billete.setText(listEntry.billete);
            precio.setText(Float.toString(listEntry.precio));
            cantidad.setText(Integer.toString(listEntry.cantidad));

            // dependiendo del bocadillo, se muestran distintas imagenes
            ImageView icon = (ImageView) row.findViewById(R.id.row_importance);
            icon.setTag(listEntry.id);
            switch (listEntry.id) {
                case 1:
                    icon.setImageResource(R.drawable.viaje1);
                    break;
                case 2:
                    icon.setImageResource(R.drawable.viaje2);
                    break;
                case 3:
                    icon.setImageResource(R.drawable.viaje3);
                    break;
                default:
                    break;
            }
            return row;
        }
    }


}

