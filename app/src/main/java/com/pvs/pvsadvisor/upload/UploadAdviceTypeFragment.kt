package com.pvs.pvsadvisor.upload

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import com.pvs.pvsadvisor.R


class UploadAdviceTypeFragment : Fragment(R.layout.fragment_upload_advice_type) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nextBtn = view.findViewById<Button>(R.id.uploadNextButton_adv)
        val saveBtn = view.findViewById<Button>(R.id.uploadSaveButton_adv)
        saveBtn.setOnClickListener {
            //TODO: Save activity data
            activity?.finish()
        }
    }

}