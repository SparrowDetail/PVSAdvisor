package com.pvs.pvsadvisor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

/*
 * Developed by Amar, Steven, and Jacob.
 */
class Login : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // References a email and password edit text
        val email = findViewById<EditText>(R.id.editTextTextEmailAddress)
        val password = findViewById<EditText>(R.id.editTextTextPassword)

        // References a login and signup buttons
        val btn_login = findViewById<Button>(R.id.b_create)
        val btn_signup = findViewById<Button>(R.id.b_signup)

        // On-click listener to login and take to user main home
        btn_login.setOnClickListener{
            val intent = Intent(this, UserHomeMain::class.java)
            startActivity(intent)
        }

        // On-click listener to sign up page
        btn_signup.setOnClickListener{
            val intent = Intent(this, Signup::class.java)
            startActivity(intent)
        }

    }
}