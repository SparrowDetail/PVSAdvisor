package com.pvs.pvsadvisor.upload

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.pvs.pvsadvisor.R

/**
 * Handles the main functionality of the project upload process (i.e. Start and transition
 * between pages
 * **/
class UploadMain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //TODO: Implement content view progress in DB
        setContentView(R.layout.upload_main_activity)

        //Implement fragment data
        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<UploadCategoryFragment>(R.id.uploadMainFragmentView)
            }
        }

        //Activity save button
        val fragSaveButton = findViewById<Button>(R.id.uploadSaveButton)
        fragSaveButton.setOnClickListener {
            //TODO: Save project data to Database
            finish()
        }

        val fragNextButton = findViewById<Button>(R.id.uploadNextButton)
        fragNextButton.setOnClickListener {
            //TODO: Set view data to Database

        }
    }



}