package com.pvs.pvsadvisor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.Button
import androidx.fragment.app.Fragment
import com.pvs.pvsadvisor.upload.UploadMain

/*
 * Main function for Prime Vice Advisor.
 * Developed by Amar, Steven, and Jacob.
 */
class UserHomeMainFragment : Fragment(R.layout.user_home) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //References new project upload button
        val newProjectUploadButton = view.findViewById<Button>(R.id.projectUploadButton)
        //On-click listener for new project upload button
        newProjectUploadButton.setOnClickListener {
            val intent = Intent(view.context,UploadMain::class.java)
            startActivity(intent)
        }
    }
}