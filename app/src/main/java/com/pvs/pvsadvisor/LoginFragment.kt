package com.pvs.pvsadvisor

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment

/*
 * Developed by Amar, Steven, and Jacob.
 */
class LoginFragment : Fragment(R.layout.activity_login)
{
    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)

        // References a email and password edit text
        val email = view.findViewById<EditText>(R.id.editTextTextEmailAddress)
        val password = view.findViewById<EditText>(R.id.editTextTextPassword)

        // References a login and signup buttons
        val btn_login = view.findViewById<Button>(R.id.b_create)
        val btn_signup = view.findViewById<Button>(R.id.b_signup)

        // On-click listener to login and take to user main home
        btn_login.setOnClickListener{
            val intent = Intent(view.context, MainActivity::class.java)
            startActivity(intent)
        }

        // On-click listener to sign up page
        btn_signup.setOnClickListener{
            val intent = Intent(view.context, SignupFragment::class.java)
            startActivity(intent)
        }
    }
}