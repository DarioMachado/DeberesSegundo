package com.example.retosqlandroid

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context

class DataManager(context: Context) {
    private val dbHelper = DatabaseHelper(context)
    fun introducirDatos(nombre: String, pais: String, habitat: String, descripcion: String, tipo: String, popularidad: String, real: String){
        val db = dbHelper.writableDatabase
        val values = ContentValues().apply{
            put(DatabaseHelper.COLUMN_NOMBRE, nombre)
            put(DatabaseHelper.COLUMN_PAIS, pais)
            put(DatabaseHelper.COLUMN_HABITAT, habitat)
            put(DatabaseHelper.COLUMN_DESCRIPCION, descripcion)
            put(DatabaseHelper.COLUMN_TIPO, tipo)
            put(DatabaseHelper.COLUMN_POPULARIDAD, popularidad)
            put(DatabaseHelper.COLUMN_REAL, real)
        }
        db.insert(DatabaseHelper.TABLE_NAME, null, values)
        db.close()

    }

    @SuppressLint("Range")
    fun mostrarValores(context: Context): String{
        val db = dbHelper.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM ${DatabaseHelper.TABLE_NAME}", null)
        val datos = StringBuilder()

        while(cursor.moveToNext()){
            try{
                datos.append("ID: ")
                datos.append(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_ID)))
                datos.append(" / Nombre: ")
                datos.append(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_NOMBRE)))
                datos.append(" / País: ")
                datos.append(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_PAIS)))
                datos.append(" / Hábitat: ")
                datos.append(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_HABITAT)))
                datos.append(" / Descripción: ")
                datos.append(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_DESCRIPCION)))
                datos.append(" / Tipo: ")
                datos.append(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_TIPO)))
                datos.append(" / Popularidad: ")
                datos.append(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_POPULARIDAD)))
                datos.append(" / Real: ")
                datos.append(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_REAL)))

            }catch (e: Exception){
                datos.append("error")
            }finally {
                datos.append("\n\n")
            }
        }
        cursor.close()
        db.close()
        if(datos.isEmpty()){
            return "No hay datos en la base de datos"
        }
        return datos.toString()
    }

    fun borrar(nombre: String): Boolean{
        val db = dbHelper.writableDatabase
        return db.delete(DatabaseHelper.TABLE_NAME, "nombre=?", arrayOf(nombre)) > 0
    }

    fun actualizar()

}