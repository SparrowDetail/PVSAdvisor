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
    private var boxesChecked: Int = 0
    private var selectedCategories: ArrayList<String> = ArrayList(3)

    /*
    * Override onViewCreated to initialize fragment core functions
    * */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Declare Category CheckBox Objects
        val checkboxCarDesign = view.findViewById<CheckBox>(R.id.cat_char_design)
        val checkboxStoryboarding = view.findViewById<CheckBox>(R.id.cat_storyboarding)
        val checkboxSeqArt = view.findViewById<CheckBox>(R.id.cat_seq_art)
        val checkboxComBook = view.findViewById<CheckBox>(R.id.cat_com_book)

        //Set Category CheckBox onClickListeners
        checkboxCarDesign.setOnClickListener {
            onCheckboxClicked(view, checkboxCarDesign)
        }
        checkboxStoryboarding.setOnClickListener {
            onCheckboxClicked(view, checkboxStoryboarding)
        }
        checkboxSeqArt.setOnClickListener {
            onCheckboxClicked(view, checkboxSeqArt)
        }
        checkboxComBook.setOnClickListener {
            onCheckboxClicked(view, checkboxComBook)
        }

        //Declare next and save button objects
        val nextBtn = view.findViewById<Button>(R.id.uploadNextButton_cat)
        val saveBtn = view.findViewById<Button>(R.id.uploadSaveButton_cat)

        //Next button on click listener
        nextBtn.setOnClickListener {
            //TODO:Replace display sample data with database storage

            //Requires the user to select at least one category

            if (boxesChecked > 0) {
                Toast.makeText(view.context, selectedCategories.toString(), Toast.LENGTH_LONG).show()
                Navigation.findNavController(view).navigate(R.id.navigate_to_title_selection)
            }
            else
                Toast.makeText(view.context,getString(R.string.category_more_options),Toast.LENGTH_SHORT).show()
        }

        //Save button on click listener
        saveBtn.setOnClickListener {
            //TODO: Save activity data
            activity?.finish()
        }
    }

    /*
    * onCheckboxClicked accepts the current view and checkbox being called and
    * constructs the current input dataset in the selectedCategories ArrayList
    * */
    private fun onCheckboxClicked (view: View, checkbox: CheckBox) {
        if (boxesChecked < 3 || !checkbox.isChecked) {
            when (checkbox.id) {
                R.id.cat_char_design -> {
                    if (checkbox.isChecked) {
                        selectedCategories.add(getString(R.string.select_character_design))
                        boxesChecked += 1
                    } else {
                        selectedCategories.remove(getString(R.string.select_character_design))
                        boxesChecked -= 1
                    }
                }
                R.id.cat_storyboarding -> {
                    if (checkbox.isChecked) {
                        selectedCategories.add(getString(R.string.select_storyboarding))
                        boxesChecked += 1
                    } else {
                        selectedCategories.remove(getString(R.string.select_storyboarding))
                        boxesChecked -= 1
                    }
                }
                R.id.cat_seq_art -> {
                    if (checkbox.isChecked) {
                        selectedCategories.add(getString(R.string.select_sequential_art))
                        boxesChecked += 1
                    } else {
                        selectedCategories.remove(getString(R.string.select_sequential_art))
                        boxesChecked -= 1
                    }
                }
                R.id.cat_com_book -> {
                    if (checkbox.isChecked) {
                        selectedCategories.add(getString(R.string.select_comic_book))
                        boxesChecked += 1
                    } else {
                        selectedCategories.remove(getString(R.string.select_comic_book))
                        boxesChecked -= 1
                    }
                }
            }
        }
        else {
            checkbox.toggle()
            Toast.makeText(view.context, getString(R.string.category_selection_limit_reached), Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        //TODO: import data to database
    }
}