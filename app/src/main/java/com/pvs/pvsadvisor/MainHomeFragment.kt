package com.pvs.pvsadvisor

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.pvs.pvsadvisor.upload.UploadMain

class MainHomeFragment : Fragment(R.layout.main_home_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //References new project upload button
        val newProjectUploadButton = view.findViewById<Button>(R.id.projectUploadButton)
        //On-click listener for new project upload button
        newProjectUploadButton.setOnClickListener {
            val intent = Intent(view.context, UploadMain::class.java)
            startActivity(intent)
        }
    }
}