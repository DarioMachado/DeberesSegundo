package com.example.sqlej3android

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context,
    DATABASE_NAME, null, DATABASE_VERSION) {
    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "Deberes.db";
        const val TABLE_NAME = "alumnos";
        const val COLUMN_ID = "_id";
        const val COLUMN_NAME = "nombre";
        const val COLUMN_APELLIDOS = "apellidos"
        const val COLUMN_DNI = "dni"
        const val COLUMN_EDAD = "edad"
        const val COLUMN_CURSO = "curso"
    }
    override fun onCreate(db: SQLiteDatabase) {
        val CREATE_TABLE = "CREATE TABLE $TABLE_NAME " +
                "($COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$COLUMN_NAME TEXT, " +
                "$COLUMN_APELLIDOS TEXT," +
                "$COLUMN_DNI TEXT," +
                "$COLUMN_EDAD NUMERIC," +
                "$COLUMN_CURSO TEXT" +
                ")";
        db.execSQL(CREATE_TABLE)
    }
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }
}