package com.pvs.pvsadvisor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment

/*
 * Developed by Amar, Steven, and Jacob.
 */
class SignupFragment : Fragment(R.layout.activity_signup)
{
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // References a edit text for new user
        val firstname = view.findViewById<EditText>(R.id.editTextTextFirstName)
        val lastname = view.findViewById<EditText>(R.id.editTextTextLastName)
        val email = view.findViewById<EditText>(R.id.editTextTextEmailAddress)
        val password = view.findViewById<EditText>(R.id.editTextTextPassword)
        val repeatpassword = view.findViewById<EditText>(R.id.editTextTextRepeatPassword)

        // References a create button
        val btn_create = view.findViewById<Button>(R.id.b_create)

        // On-click listener to create a new user and take to user main home
        btn_create.setOnClickListener {
            val intent = Intent(view.context, MainActivity::class.java)
            startActivity(intent)
        }
    }

}