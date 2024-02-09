package com.example.sqlej3android

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import androidx.core.database.getStringOrNull
import java.lang.StringBuilder

class DataManager(context: Context) {
    private val dbHelper = DatabaseHelper(context)
    fun introducirDatos(nombre: String, apellidos: String, dni: String, edad: Int, curso: String){
        val db = dbHelper.writableDatabase
        val values = ContentValues().apply{
            put(DatabaseHelper.COLUMN_NAME, nombre)
            put(DatabaseHelper.COLUMN_APELLIDOS, apellidos)
            put(DatabaseHelper.COLUMN_DNI, dni)
            put(DatabaseHelper.COLUMN_EDAD, edad)
            put(DatabaseHelper.COLUMN_CURSO, curso)
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
                datos.append(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_NAME)))
                datos.append(" / Apellidos: ")
                datos.append(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_APELLIDOS)))
                datos.append(" / DNI: ")
                datos.append(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_DNI)))
                datos.append(" / EDAD: ")
                datos.append(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_EDAD)))
                datos.append(" / CURSO: ")
                datos.append(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_CURSO)))
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

}