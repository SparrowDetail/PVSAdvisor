package com.pvs.pvsadvisor.upload

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import androidx.navigation.Navigation
import com.pvs.pvsadvisor.R


class UploadCategoryFragment : Fragment(R.layout.fragment_upload_category) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var categorySelect = arrayOf(false, false, false, false)

        var selectedStoryboarding = false

        val checkCharDesign: CheckBox = view.findViewById(R.id.cat_char_design)
        val checkStoryboarding: CheckBox = view.findViewById(R.id.cat_storyboarding)
        val checkSeqArt: CheckBox = view.findViewById(R.id.cat_seq_art)
        val checkComicBook: CheckBox = view.findViewById(R.id.cat_com_book)

        checkCharDesign.setOnClickListener {
            Toast.makeText(view.context,"Test", Toast.LENGTH_LONG).show()
        }

        checkStoryboarding.setOnClickListener {
            if (checkStoryboarding.isChecked) {selectedStoryboarding = true}
            else if (!checkStoryboarding.isChecked) {selectedStoryboarding = false}
        }

        val nextBtn = view.findViewById<Button>(R.id.uploadNextButton_cat)
        val saveBtn = view.findViewById<Button>(R.id.uploadSaveButton_cat)
        nextBtn.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.navigate_to_title_selection)
        }
        saveBtn.setOnClickListener {
            //TODO: Save activity data
            activity?.finish()
        }


    }

    override fun onDestroy() {
        super.onDestroy()
        //TODO: import data to database
    }
}