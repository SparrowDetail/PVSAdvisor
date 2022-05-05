package com.pvs.pvsadvisor

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment

/*
 * Developed by Amar, Steven, and Jacob.
 */
class LoginFragment : Fragment(R.layout.activity_login)
{
    private var isAllFieldsChecked: Boolean = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)

        // References a login and signup buttons
        val btn_login = view.findViewById<Button>(R.id.b_create)
        val btn_signup = view.findViewById<Button>(R.id.b_signup)

        // On-click listener to login and take to user main home
        btn_login.setOnClickListener{

            isAllFieldsChecked = CheckAllFields();
            if (isAllFieldsChecked) {
                Toast.makeText(view.context,"Login successful!",Toast.LENGTH_SHORT).show()
                val intent = Intent(view.context, MainActivity::class.java)
                startActivity(intent)
            }
        }

        // On-click listener to sign up page
        btn_signup.setOnClickListener{
            Toast.makeText(view.context,"Welcome to PVS, start your journey!",Toast.LENGTH_SHORT).show()
            val intent = Intent(view.context, SignupFragment::class.java)
            startActivity(intent)
        }
    }

    // Checks for credential requirements during the login procedure. Via nullability ammong the
    // the given strings of information. Still needs a cryptography standard implementation for
    // internet based access for its database.
    private fun CheckAllFields(): Boolean {

        val emailInfo = view?.findViewById<EditText>(R.id.editTextTextEmailAddress)
        val passwordInfo = view?.findViewById<EditText>(R.id.editTextTextPassword)

        if (emailInfo != null) {
            if (emailInfo.length() === 0) {
                emailInfo.error = "Email is required"
                return false
            }
        }
        if (passwordInfo != null) {
            if (passwordInfo.length() === 0) {
                passwordInfo.error = "Password is required"
                return false
            }
        }
        // after all validation return true.
        return true
    }
}