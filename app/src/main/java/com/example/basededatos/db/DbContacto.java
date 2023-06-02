package com.example.basededatos.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class DbContacto extends DbHelper {

    Context context;

    public DbContacto(@Nullable Context context) {
        super(context);
        this.context = context;
    }
    public long insertacontacto(String nombre, String apellido, String num_control){

        long id = 0;

        try {
        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("nombre", nombre);
        values.put("apellido", apellido);
        values.put("num_control", num_control);

        id = db.insert(TABLE_CONTACTOS, null, values);
    }catch(Exception ex){
        ex.toString();
    }
    return id;

    }
}
