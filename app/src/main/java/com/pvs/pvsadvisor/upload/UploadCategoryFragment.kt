package com.pvs.pvsadvisor.upload

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.pvs.pvsadvisor.R

class UploadCategoryFragment: Fragment(R.layout.upload_category_select) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var categorySelect = arrayOf(false, false, false, false)

        var selectedStoryboarding = false

        val checkCharDesign: CheckBox = view.findViewById(R.id.cat_char_design)
        val checkStoryboarding: CheckBox = view.findViewById(R.id.cat_storyboarding)
        val checkSeqArt: CheckBox = view.findViewById(R.id.cat_seq_art)
        val checkComicBook: CheckBox = view.findViewById(R.id.cat_com_book)

        checkCharDesign.setOnClickListener {
            Toast.makeText(view.context,"Test",Toast.LENGTH_LONG).show()
        }

        checkStoryboarding.setOnClickListener {
            if (checkStoryboarding.isChecked) {selectedStoryboarding = true}
            else if (!checkStoryboarding.isChecked) {selectedStoryboarding = false}
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        //TODO: import data to database
    }
}