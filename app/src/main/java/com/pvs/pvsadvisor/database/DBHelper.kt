package com.pvs.pvsadvisor.database

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
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
                "${ContractUser.KEY_STATUS} TEXT );" )
        db?.execSQL(createUserTable)

        //Init project table if it doesn't exist
        val createProjectTable = ("CREATE TABLE ${ContractProject.TABLE_NAME} (" +
                "${ContractProject.PK_PROJECT_ID} INTEGER PRIMARY KEY AUTOINCREMENT," +
                "${ContractProject.FK_USER_ID} INTEGER," +
                "${ContractProject.KEY_PROJECT_TITLE} TEXT," +
                "${ContractProject.KEY_CATEGORIES} TEXT," +
                "${ContractProject.KEY_ADVICE_TYPE} TEXT," +
                "${ContractProject.KEY_ADVICE_DESCRIPTION} TEXT," +
                "${ContractProject.KEY_FORMAT_TYPE} TEXT," +
                " FOREIGN KEY (${ContractProject.FK_USER_ID}) " +
                " REFERENCES ${ContractUser.TABLE_NAME} (${ContractUser.PK_USERID})" +
                " ON DELETE CASCADE ON UPDATE NO ACTION );" )
        db?.execSQL(createProjectTable)


    }

    /** Removes existing data and calls onCreate to upgrade the database on version change **/
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        //Set of tables contained in the db
        val tableNames = arrayOf(
            ContractUser.TABLE_NAME,
            ContractProject.TABLE_NAME
        )
        //Executes sql commands to drop existing tables
        for(i in tableNames) {
            val sqlUser = "DROP TABLE IF EXISTS $i"
            db!!.execSQL(sqlUser)
        }
        //Updates data to new table
        onCreate(db)
    }

    /** Used to insert new user data to the database
     *  @param user ModelUser object containing user data to be inserted to database
     *  @return Long representing success of database insert function, and -1 if failed**/
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

    /** Queries the database for current user data and returns an empty ArrayList if none is found
     *  @param arg String containing query user's email (i.e. username)
     *  @return ArrayList of type ModelUser containing all users of the argument email **/
    @SuppressLint("Range")
    fun selectUserByEmail(arg : String) : ArrayList<ModelUser> {
        //Init ModelUser ArrayList
        val userList = ArrayList<ModelUser>()

        //Generate search query
        val query = "SELECT * FROM ${ContractUser.TABLE_NAME} " +
                "WHERE ${ContractUser.KEY_EMAIL} = \"$arg\""

        //Open Readable Database
        val db = this.readableDatabase
        var cursor : Cursor? = null

        //Try init cursor
        try {
            cursor = db.rawQuery(query, null)
        } catch (e : SQLiteException) {
            db.execSQL(query)
            return ArrayList()
        }

        //Init Table values
        var id:Int
        var email:String
        var pswd:String
        var fName:String
        var lName:String
        var status:String

        //Iterate through cursor object and return userList
        if (cursor.moveToFirst()) {
            do {
                id = cursor.getInt(cursor.getColumnIndex(ContractUser.PK_USERID))
                email = cursor.getString(cursor.getColumnIndex(ContractUser.KEY_EMAIL))
                pswd = cursor.getString(cursor.getColumnIndex(ContractUser.KEY_PASSWORD))
                fName = cursor.getString(cursor.getColumnIndex(ContractUser.KEY_FIRST_NAME))
                lName = cursor.getString(cursor.getColumnIndex(ContractUser.KEY_LAST_NAME))
                status = cursor.getString(cursor.getColumnIndex(ContractUser.KEY_STATUS))

                val user = ModelUser(id,email,pswd,fName,lName,status)
                userList.add(user)
            } while (cursor.moveToNext())
        }
        cursor.close()
        return userList
    }


}