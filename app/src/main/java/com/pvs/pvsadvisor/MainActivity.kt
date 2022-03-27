package com.pvs.pvsadvisor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem

/*
 * Main function for Prime Vice Advisor.
 * Developed by Amar, Steven, and Jacob.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_home)
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