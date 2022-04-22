package com.pvs.pvsadvisor.database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

/** Database helper class used to create, update, and query the database**/
class DBHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION){

        //Companion object used to store current database version and database name
        companion object {
            private const val DATABASE_VERSION = 1 //Must update if table is added or changed
            private const val DATABASE_NAME = "PVS_Database"
        }

    /**Called whenever the database is initialized or upgraded **/
    override fun onCreate(db: SQLiteDatabase?) {
        //Init user table if it doesn't exist
        val createUserTable = ("CREATE TABLE ${ContractUser.TABLE_NAME} (" +
                "${ContractUser.PK_USERID} INTEGER PRIMARY KEY AUTOINCREMENT," +
                "${ContractUser.KEY_EMAIL} TEXT," +
                "${ContractUser.KEY_PASSWORD} TEXT," +
                "${ContractUser.KEY_FIRST_NAME} TEXT," +
                "${ContractUser.KEY_LAST_NAME} TEXT," +
                "${ContractUser.KEY_STATUS} TEXT )" )
        db?.execSQL(createUserTable)

        //Init project table if it doesn't exist
        val createProjectTable = ("CREATE TABLE ${ContractProject.TABLE_NAME} (" +
                "${ContractProject.PK_PROJECT_ID} INTEGER PRIMARY KEY AUTOINCREMENT," +
                "${ContractProject.FK_USER_ID} INTEGER FOREIGN KEY," +
                "${ContractProject.KEY_PROJECT_TITLE} TEXT," +
                "${ContractProject.KEY_CATEGORIES} TEXT," +
                "${ContractProject.KEY_ADVICE_TYPE} TEXT," +
                "${ContractProject.KEY_ADVICE_DESCRIPTION} TEXT," +
                "${ContractProject.KEY_FORMAT_TYPE} TEXT )" )
        db?.execSQL(createProjectTable)
    }

    /** Removes existing data and calls onCreate to upgrade the database on version change **/
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        //Execute sql command to drop existing tables
        val sqlUser = "DROP TABLE IF EXISTS ${ContractUser.TABLE_NAME}"
        db!!.execSQL(sqlUser)
        val sqlProject = "DROP TABLE IF EXISTS ${ContractProject.TABLE_NAME}"
        db.execSQL(sqlProject)
        //Updates data to new table
        onCreate(db)
    }

    /** Used to insert new user data to the database **/
    fun insertUser(user:ModelUser) : Long {
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