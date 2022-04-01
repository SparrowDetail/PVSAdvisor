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
    private var boxesChecked: Int = 0
    private var selectedCategories: String = ""

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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
            //Requires the user to select at least one category
            if (boxesChecked > 0)
                Navigation.findNavController(view).navigate(R.id.navigate_to_title_selection)
            else
                Toast.makeText(view.context,getString(R.string.category_more_options),Toast.LENGTH_SHORT).show()
        }
        saveBtn.setOnClickListener {
            //TODO: Save activity data
            activity?.finish()
        }
    }

    private fun onCheckboxClicked (view: View, checkbox: CheckBox) {


        when (checkbox.id) {
            R.id.cat_char_design -> {
                if (checkbox.isChecked) {
                    Toast.makeText(view.context, selectedCategories, Toast.LENGTH_LONG).show()
                    selectedCategories += "Character Design,"
                    boxesChecked += 1
                } else {
                    Toast.makeText(view.context, "Not Category", Toast.LENGTH_LONG).show()
                    selectedCategories.replace("Character Design,", "")
                    boxesChecked -= 1
                }
            }
            R.id.cat_storyboarding -> {
                if (checkbox.isChecked) {
                    selectedCategories += "Storyboarding,"
                    boxesChecked += 1
                } else {
                    selectedCategories.replace("Storyboarding,", "")
                    boxesChecked -= 1
                }
            }
            R.id.cat_seq_art -> {
                if (checkbox.isChecked) {
                    selectedCategories += "Sequential Art,"
                    boxesChecked += 1
                } else {
                    selectedCategories.replace("Sequential Art,", "")
                    boxesChecked -= 1
                }
            }
            R.id.cat_com_book -> {
                if (checkbox.isChecked) {
                    selectedCategories += "Comic Book,"
                    boxesChecked += 1
                } else {
                    selectedCategories.replace("Sequential Art,", "")
                    boxesChecked -= 1
                }
            }
        }


    }

    override fun onDestroy() {
        super.onDestroy()
        //TODO: import data to database
    }
}