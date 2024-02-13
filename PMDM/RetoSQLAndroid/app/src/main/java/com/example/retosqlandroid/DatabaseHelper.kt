package com.example.retosqlandroid

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context,
    DATABASE_NAME, null, DATABASE_VERSION) {
    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "Deberes.db";
        const val TABLE_NAME = "criptidos";
        const val COLUMN_ID = "_id";
        const val COLUMN_NOMBRE = "nombre";
        const val COLUMN_PAIS = "pais"
        const val COLUMN_HABITAT = "habitat"
        const val COLUMN_DESCRIPCION = "descripcion"
        const val COLUMN_TIPO = "tipo"
        const val COLUMN_POPULARIDAD = "popularidad"
        const val COLUMN_REAL = "real"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val CREATE_TABLE = "CREATE TABLE $TABLE_NAME " +
                "($COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$COLUMN_NOMBRE TEXT, " +
                "$COLUMN_PAIS TEXT," +
                "$COLUMN_HABITAT TEXT," +
                "$COLUMN_DESCRIPCION TEXT," +
                "$COLUMN_TIPO TEXT," +
                "$COLUMN_POPULARIDAD TEXT," +
                "$COLUMN_REAL TEXT"+
                ")";
        db.execSQL(CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

}