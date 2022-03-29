package com.pvs.pvsadvisor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

/*
 * Developed by Amar, Steven, and Jacob.
 */
class Signup : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        // References a edit text for new user
        val firstname = findViewById<EditText>(R.id.editTextTextFirstName)
        val lastname = findViewById<EditText>(R.id.editTextTextLastName)
        val email = findViewById<EditText>(R.id.editTextTextEmailAddress)
        val password = findViewById<EditText>(R.id.editTextTextPassword)
        val repeatpassword = findViewById<EditText>(R.id.editTextTextRepeatPassword)

        // References a create button
        val btn_create = findViewById<Button>(R.id.b_create)

        // On-click listener to create a new user and take to user main home
        btn_create.setOnClickListener{
            val intent = Intent(this, UserHomeMain::class.java)
            startActivity(intent)
        }


    }
}