package com.pvs.pvsadvisor.upload

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.navigation.Navigation
import com.pvs.pvsadvisor.R
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
    }
}