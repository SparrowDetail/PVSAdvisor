package com.pvs.pvsadvisor.upload

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import androidx.navigation.Navigation
import com.pvs.pvsadvisor.R

class UploadProjectFileUploadFragment : Fragment(R.layout.fragment_upload_project_file_upload) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nextBtn = view.findViewById<Button>(R.id.uploadNextButton_prj_file)
        val saveBtn = view.findViewById<Button>(R.id.uploadSaveButton_prj_file)
        nextBtn.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.navigate_to_advice_detail)
        }
    }
}