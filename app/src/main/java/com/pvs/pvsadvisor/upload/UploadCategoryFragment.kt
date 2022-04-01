package com.pvs.pvsadvisor.upload

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.pvs.pvsadvisor.R


class UploadCategoryFragment : Fragment(R.layout.fragment_upload_category) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var numberChecked = 0

        val checkboxCarDesign = view.findViewById<CheckBox>(R.id.cat_char_design)
        val checkboxStoryboarding = view.findViewById<CheckBox>(R.id.cat_storyboarding)
        val checkboxSeqArt = view.findViewById<CheckBox>(R.id.cat_seq_art)
        val checkboxComBook = view.findViewById<CheckBox>(R.id.cat_com_book)

        checkboxCarDesign.setOnClickListener {
            onCheckboxClicked(view, checkboxCarDesign)
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

    private fun onCheckboxClicked (view: View, checkbox: CheckBox) {


        when (checkbox.id) {
            R.id.cat_char_design -> {
                if (checkbox.isChecked)
                    Toast.makeText(view.context,"Checked", Toast.LENGTH_LONG).show()
                else
                    Toast.makeText(view.context,"Not Checked", Toast.LENGTH_LONG).show()
            }
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        //TODO: import data to database
    }
}