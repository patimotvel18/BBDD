package com.example.basededatos;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.basededatos.db.DbHelper;

import java.sql.SQLData;

public class MainActivity extends AppCompatActivity {

    Button Crear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Crear = findViewById(R.id.Crear);

        Crear.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                DbHelper dbHelper = new DbHelper(MainActivity.this);
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                if (db != null){
                    Toast.makeText(MainActivity.this, "Base de datos creada", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Base de datos no ah sido creada", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal, menu);
        return true;
}

    public boolean OnOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.MenuIngreso:
                nuevoregistro();
                return true;

            default:
                return super.OnOptionsItemSelected(item);
        }
    }

    private void nuevoregistro(){
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);

    }
}