package com.example.ionber.pmmrecu;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public EditText nombre;
    public EditText password;
    public Cursor cursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = findViewById(R.id.activity_main_nombre);
        password = findViewById(R.id.activity_main_password);

        Button nuevo_Usuario = findViewById(R.id.activity_main_nuevo_usuario);
        TextView usuario_registrado = findViewById(R.id.activity_main_usuario_registrado);

        final DataBaseHelper dbHelper = new DataBaseHelper(this);
        cursor = dbHelper.getAllUsuarios();

        nuevo_Usuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Usuario nuevoUsuario = new Usuario(
                        nombre.getText().toString(),
                        password.getText().toString()
                );

                dbHelper.insertUsuario(nuevoUsuario);
                Toast toast =
                        Toast.makeText(getApplicationContext(),
                                "Usuario creado con éxito",
                                Toast.LENGTH_SHORT
                        );
                toast.show();
            }
        });

        usuario_registrado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usuario = comprobarUsuario(
                        cursor,
                        nombre.getText().toString(),
                        password.getText().toString()
                );
                if (usuario != null) {
                    Intent crono = new Intent(MainActivity.this, Cronometro.class);
                    crono.putExtra(DataBaseContract.UsuarioEntry.KEY_NAME, usuario);
                    startActivity(crono);
                }
            }
        });
    }

    // Para crear el menú:
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menu_horarios) {
            // TODO
            return true;
        } else if (id == R.id.menu_about) {
            // TODO
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public String comprobarUsuario(Cursor cursor, String usuario, String password) {
        if (cursor.moveToFirst()) {
            do {
                String usuarioCursor = cursor.getString(cursor.getColumnIndex(DataBaseContract.UsuarioEntry.KEY_NAME));
                String passwordCursor = cursor.getString(cursor.getColumnIndex(DataBaseContract.UsuarioEntry.KEY_PASSWORD));
                if (usuario.equals(usuarioCursor) && password.equals(passwordCursor)) {
                    return usuarioCursor;
                }
            } while (cursor.moveToNext());
        }
        return null;
    }
}
