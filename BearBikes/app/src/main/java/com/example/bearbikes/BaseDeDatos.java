package com.example.bearbikes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.bearbikes.modeles.Sitio;

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
    }

    @Override
    public void onUpgrade(SQLiteDatabase dd,int oldVersion, int newVersion){
    }
    public void abrir(){this.getWritableDatabase();}
    public void cerrar(){this.close();}
    public void insertarCiclistas(String nom, String pass){
        ContentValues valores = new ContentValues();
        valores.put("Nombre",nom);
        valores.put("Password",pass);
        this.getWritableDatabase().insert("ciclistas",null,valores);
    }
    public void insertarSitios(String nom, String des, String dir){
        ContentValues valores = new ContentValues();
        valores.put("Nombre",nom);
        valores.put("Descripcion",des);
        valores.put("Direccion",dir);
        this.getWritableDatabase().insert("sitios",null,valores);
    }
    public Cursor VerificarUsuario(String user, String pass)throws SQLException{
        Cursor regCursor = null;
        regCursor = this.getWritableDatabase().query("ciclistas",new String[]{"ID","Nombre", "Password"},"Nombre like '"+user+"'"+"and Password like '"+pass+"'",null,null,null,null);
        return regCursor;
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
}