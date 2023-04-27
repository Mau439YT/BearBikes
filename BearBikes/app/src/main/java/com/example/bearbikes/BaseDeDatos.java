package com.example.bearbikes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

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
    public void insertarSitiosPrueba(){
        ContentValues valores = new ContentValues();
        valores.put("Nombre","Hola");
        valores.put("Descripcion","Hola");
        valores.put("Direccion","Hola");
        this.getWritableDatabase().insert("sitios",null,valores);
    }
    public Cursor VerificarUsuario(String user, String pass)throws SQLException{
        Cursor regCursor = null;
        regCursor = this.getWritableDatabase().query("ciclistas",new String[]{"ID","Nombre", "Password"},"Nombre like '"+user+"'"+"and Password like '"+pass+"'",null,null,null,null);
        return regCursor;
    }

    //public Cursor obtenerColumna(String tabla, String columna) {
    //    SQLiteDatabase db = dbHelper.getReadableDatabase();
    //    Cursor cursor = db.query(tabla, columnas, null, null, null, null, null);
    //    return cursor;
    //}


}