package com.pvs.pvsadvisor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import com.pvs.pvsadvisor.upload.UploadMain

/*
 * Main function for Prime Vice Advisor.
 * Developed by Amar, Steven, and Jacob.
 */
class UserHomeMain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_home)

        //References new project upload button
        val newProjectUploadButton = findViewById<Button>(R.id.projectUploadButton)
        //On-click listener for new project upload button
        newProjectUploadButton.setOnClickListener {
            val intent = Intent(this,UploadMain::class.java)
            startActivity(intent)
        }
    }

    //Inflates the custom menu from menu asset
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.user_home_menu, menu)
        return true
    }

    //Controls menu actions on home page
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == R.id.user_home_profile_directory) {
            //TODO:Direct the user to the profile page
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}