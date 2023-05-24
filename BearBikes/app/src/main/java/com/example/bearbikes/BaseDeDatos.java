package com.example.bearbikes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.bearbikes.modeles.Sitio;
import com.example.bearbikes.modeles.Taller;

import java.util.ArrayList;
import java.util.List;

public class BaseDeDatos extends SQLiteOpenHelper {
    public BaseDeDatos(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version){
        super(context,name,factory,version);
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        String query = "create table ciclistas(ID integer primary key autoincrement,"+"Nombre text, Password text)";
        db.execSQL(query);
        String query2 = "create table sitios (ID integer primary key autoincrement,"+"Nombre text, Descripcion text ,Direccion text)";
        db.execSQL(query2);
        String query3 = "create table talleres (ID integer primary key autoincrement,"+"Nombre text, Descripcion text ,Direccion text)";
        db.execSQL(query3);
    }

    @Override
    public void onUpgrade(SQLiteDatabase dd,int oldVersion, int newVersion){
    }
    public void abrir(){this.getWritableDatabase();}
    public void cerrar(){this.close();}

    public void insertarSitios(String nom, String des, String dir){
        ContentValues valores = new ContentValues();
        valores.put("Nombre",nom);
        valores.put("Descripcion",des);
        valores.put("Direccion",dir);
        this.getWritableDatabase().insert("sitios",null,valores);
    }

    public List<Sitio> getAllSitios() {
        List<Sitio> Sitios = new ArrayList<Sitio>();

        String selectQuery = "SELECT  * FROM Sitios";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Sitio Sitio = new Sitio();
                Sitio.setID(Integer.parseInt(cursor.getString(0)));
                Sitio.setNombre(cursor.getString(1));
                Sitio.setDescripcion(cursor.getString(2));
                Sitio.setDireccion(cursor.getString(3));
                Sitios.add(Sitio);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return Sitios;
    }

    public boolean eliminarSitio(int idProducto) {
        SQLiteDatabase db = this.getWritableDatabase();
        int filasEliminadas = db.delete("sitios", "id = ?", new String[]{String.valueOf(idProducto)});
        return filasEliminadas > 0;
    }

    public boolean actualizarSitio(Sitio sitio) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("Nombre", sitio.getNombre());
        values.put("Descripcion", sitio.getDescripcion());
        values.put("Direccion", sitio.getDireccion());

        int filasActualizadas = db.update("sitios", values, "id = ?", new String[]{String.valueOf(sitio.getID())});
        return filasActualizadas > 0;
    }

    public void insertarTalleresPrueba(){
        ContentValues valores = new ContentValues();
        valores.put("Nombre","Ciclometa");
        valores.put("Descripcion","One of the best stores in DF for all levels of bike parts from generic brands to Campagnolo.");
        valores.put("Direccion","C. Lago Müritz 30, Mariano Escobedo, Miguel Hidalgo, 11320 Ciudad de México, CDMX");
        this.getWritableDatabase().insert("talleres",null,valores);
        valores.put("Nombre","Biciterra");
        valores.put("Descripcion","Excelente servicio  y atención por parte de Carlos! Me ha ayudado varias veces con el mantenimiento y algunos detallitos de mi bicicleta. Además me iba a ayudar con la venta de mi bicicleta antes de que regreso a Alemania. Al final la voy a dar a una amiga pero Carlos la arregló para que queda perfecta antes. Muchas gracias!!");
        valores.put("Direccion","Lago Xochimilco, Calle Bahia de Sta. Barbara esq, 11320 Ciudad de México, CDMX");
        this.getWritableDatabase().insert("talleres",null,valores);
    }

    public List<Taller> getAllTalleres() {
        List<Taller> Talleres = new ArrayList<Taller>();

        String selectQuery = "SELECT  * FROM talleres";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Taller taller = new Taller();
                taller.setID(Integer.parseInt(cursor.getString(0)));
                taller.setNombre(cursor.getString(1));
                taller.setDescripcion(cursor.getString(2));
                taller.setDireccion(cursor.getString(3));
                Talleres.add(taller);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return Talleres;
    }

    public boolean eliminarTalleres(int idProducto) {
        SQLiteDatabase db = this.getWritableDatabase();
        int filasEliminadas = db.delete("taller", "id = ?", new String[]{String.valueOf(idProducto)});
        return filasEliminadas > 0;
    }

    public boolean actualizarTalleres(Sitio sitio) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("Nombre", sitio.getNombre());
        values.put("Descripcion", sitio.getDescripcion());
        values.put("Direccion", sitio.getDireccion());

        int filasActualizadas = db.update("taller", values, "id = ?", new String[]{String.valueOf(sitio.getID())});
        return filasActualizadas > 0;
    }
}