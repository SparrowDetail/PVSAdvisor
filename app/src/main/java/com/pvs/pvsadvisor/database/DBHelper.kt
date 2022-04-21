package com.pvs.pvsadvisor.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION){

        companion object {
            private const val DATABASE_VERSION = 1
            private const val DATABASE_NAME = "PVS_Database"
        }

    override fun onCreate(db: SQLiteDatabase?) {
        //Init user table if it doesn't exist
        val createUserTable = ("CREATE TABLE ${UserContract.TABLE_NAME} (" +
                "${UserContract.PK_USERID} INTEGER PRIMARY KEY," +
                "${UserContract.KEY_EMAIL} TEXT," +
                "${UserContract.KEY_PASSWORD} TEXT," +
                "${UserContract.KEY_FIRST_NAME} TEXT," +
                "${UserContract.KEY_LAST_NAME} TEXT," +
                "${UserContract.KEY_STATUS} TEXT )" )
        db?.execSQL(createUserTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }
}