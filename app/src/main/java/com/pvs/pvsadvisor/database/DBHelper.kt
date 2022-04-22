package com.pvs.pvsadvisor.database

import android.content.ContentValues
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
        val createUserTable = ("CREATE TABLE ${ContractUser.TABLE_NAME} (" +
                "${ContractUser.PK_USERID} INTEGER PRIMARY KEY," +
                "${ContractUser.KEY_EMAIL} TEXT," +
                "${ContractUser.KEY_PASSWORD} TEXT," +
                "${ContractUser.KEY_FIRST_NAME} TEXT," +
                "${ContractUser.KEY_LAST_NAME} TEXT," +
                "${ContractUser.KEY_STATUS} TEXT )" )
        db?.execSQL(createUserTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        //Collect target table
        val table : String = ContractUser.TABLE_NAME
        //Execute sql command to drop existing table
        val sql = "DROP TABLE IF EXISTS $table"
        db!!.execSQL(sql)
        //Updates data to new table
        onCreate(db)
    }

    fun insertUser(user:ModelUser) : Long{
        //Get writable database
        val db = this.writableDatabase

        //Collect values as a dictionary
        val contentValues = ContentValues()
        contentValues.put(ContractUser.KEY_EMAIL,user.email)
        contentValues.put(ContractUser.KEY_PASSWORD,user.pswd)
        contentValues.put(ContractUser.KEY_FIRST_NAME,user.firstN)
        contentValues.put(ContractUser.KEY_LAST_NAME,user.lastN)
        contentValues.put(ContractUser.KEY_STATUS,user.status)

        //Create SQL insert request and sets completion state to complete
        val complete = db.insert(ContractUser.TABLE_NAME,null,contentValues)

        //Close database connection
        db.close()

        return complete
    }
}