package com.pvs.pvsadvisor.upload

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.Navigation
import com.pvs.pvsadvisor.R

class UploadTitleFragment : Fragment(R.layout.fragment_upload_title) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val titleEditText: EditText = view.findViewById(R.id.title_edit_text)

        val nextBtn = view.findViewById<Button>(R.id.uploadNextButton_title)
        val saveBtn = view.findViewById<Button>(R.id.uploadSaveButton_title)
        nextBtn.setOnClickListener {
            if (!TextUtils.isEmpty(titleEditText.text)) {
                Toast.makeText(view.context,titleEditText.text, Toast.LENGTH_SHORT).show()
                Navigation.findNavController(view).navigate(R.id.navigate_to_file_upload)
            }
            else
                Toast.makeText(view.context,getString(R.string.title_required_text), Toast.LENGTH_SHORT).show()
        }
        saveBtn.setOnClickListener {
            //TODO: Save activity data
            activity?.finish()
        }
    }
}