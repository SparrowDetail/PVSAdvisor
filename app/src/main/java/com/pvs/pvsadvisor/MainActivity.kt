package com.pvs.pvsadvisor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.pvs.pvsadvisor.messaging.Main_Messaging_Fragment
import com.pvs.pvsadvisor.profile.MainProfileFragment

/*
 * Main function for Prime Vice Advisor.
 * Developed by Amar, Steven, and Jacob.
 */
class MainActivity : AppCompatActivity() {

    lateinit var bottomNav : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Removes the top-appbar from MainActivity.
        supportActionBar?.hide()

        // Below pertains to the main bottom navigation setup.
        loadFragment(MainHomeFragment())
        bottomNav = findViewById(R.id.bottomNavigationView)
        bottomNav.setOnNavigationItemReselectedListener {
            when (it.itemId) {
                R.id.main_home_fragment -> {
                    loadFragment(MainHomeFragment())
                    return@setOnNavigationItemReselectedListener
                }
                R.id.main_Messaging_Fragment -> {
                    loadFragment(Main_Messaging_Fragment())
                    return@setOnNavigationItemReselectedListener
                }
                R.id.mainProfileFragment -> {
                    loadFragment(MainProfileFragment())
                    return@setOnNavigationItemReselectedListener
                }
            }
        }

        //This will vary on user or advisor status
        val status = "user"
        if (status == "user") {
            if (savedInstanceState == null) {
                supportFragmentManager.commit {
                    replace<MainHomeFragment>(R.id.mainFragmentContainer)
                    setReorderingAllowed(true)
                }
            }
        }
    }

    // Aids the bottom navigation for loading the fragments.
    private  fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.mainFragmentContainer,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

//    //Inflates the custom menu from menu asset
//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.user_home_menu, menu)
//        return true
//    }
//
//    //Controls menu actions on home page
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        val id = item.itemId
//        if (id == R.id.user_home_profile_directory) {
//            //TODO:Direct the user to the profile page
//            return true
//        }a
//        return super.onOptionsItemSelected(item)
//    }
}