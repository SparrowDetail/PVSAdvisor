package com.pvs.pvsadvisor.upload

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import androidx.navigation.Navigation
import com.pvs.pvsadvisor.R

class UploadTitleFragment : Fragment(R.layout.fragment_upload_title) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nextBtn = view.findViewById<Button>(R.id.uploadNextButton_title)
        val saveBtn = view.findViewById<Button>(R.id.uploadSaveButton_title)
        nextBtn.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.navigate_to_file_upload)
        }
        saveBtn.setOnClickListener {
            //TODO: Save activity data
            activity?.finish()
        }
    }
}