package com.example.proyectosql1

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context

class DataManager(context: Context) {
    private val dbHelper = DatabaseHelper(context)
    fun addName(nombre: String, pass: String) {
        val db = dbHelper.writableDatabase
        val values = ContentValues().apply {
            put(DatabaseHelper.COLUMN_NAME, nombre)
            put(DatabaseHelper.COLUMN_PASS, pass)
        }
        db.insert(DatabaseHelper.TABLE_NAME, null, values)
        db.close()
    }
    @SuppressLint("Range")
    fun getAllNames(context: Context): String {
        val db = dbHelper.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM ${DatabaseHelper.TABLE_NAME}", null)
        val names = StringBuilder()
        while (cursor.moveToNext()) {
            val name = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_NAME))
            names.append("Nombre: ")
            names.append("$name\n")
        }
        cursor.close()
        db.close()
        if (names.isEmpty()) {
            return "No hay nombres en la base de datos"
        }
        return names.toString()
    }

    @SuppressLint("Range")
    fun getAll(context: Context): String{
        val db = dbHelper.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM ${DatabaseHelper.TABLE_NAME}", null)
        val datos = StringBuilder()
        while (cursor.moveToNext()) {
           try {
               val name = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_NAME))
               datos.append("Nombre: ")
               datos.append("$name /")
               val pass = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_PASS))
               datos.append(" Contraseña")
               datos.append("$pass")

           }catch (e: Exception){
                datos.append("error")
           }finally {
               datos.append("\n")
           }

        }
        cursor.close()
        db.close()
        if (datos.isEmpty()) {
            return "No hay datos en la base de datos"
        }
        return datos.toString()

    }
}