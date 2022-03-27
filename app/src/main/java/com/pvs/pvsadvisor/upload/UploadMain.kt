package com.pvs.pvsadvisor.upload

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pvs.pvsadvisor.R

/**
 * Handles the main functionality of the project upload process (i.e. Start and transition
 * between pages
 * **/
class UploadMain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.upload_catagory_select)
    }

}