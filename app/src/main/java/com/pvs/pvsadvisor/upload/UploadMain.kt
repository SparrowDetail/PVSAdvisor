package com.pvs.pvsadvisor.upload

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.pvs.pvsadvisor.R
import com.pvs.pvsadvisor.databinding.UploadCategorySelectBinding
import java.util.*

/**
 * Handles the main functionality of the project upload process (i.e. Start and transition
 * between pages
 * **/
class UploadMain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //TODO: Implement content view progress in DB
        setContentView(R.layout.upload_main_activity)

        //For saved project, pull upload step from database
        var uploadStep:Int = 0

        //Implement fragment data
        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                replace<UploadCategoryFragment>(R.id.uploadMainFragmentView)
                setReorderingAllowed(true)
            }
        }

        //Activity save button
        val fragSaveButton = findViewById<Button>(R.id.uploadSaveButton)
        fragSaveButton.setOnClickListener {
            //TODO: Save project data to Database
            finish()
        }

        //Activity next button
        val fragNextButton = findViewById<Button>(R.id.uploadNextButton)
        fragNextButton.setOnClickListener {
            //TODO: Set view data to Database
            when (uploadStep) {
                0 -> {
                    supportFragmentManager.commit {
                        replace<UploadTitleCollectionFragment>(R.id.uploadMainFragmentView)
                        setReorderingAllowed(true)
                        addToBackStack("category")
                    }
                    uploadStep += 1
                }
                1 -> {

                }
                else -> {}
            }
        }
    }



}