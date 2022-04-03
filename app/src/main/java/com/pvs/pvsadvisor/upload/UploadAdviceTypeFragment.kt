package com.pvs.pvsadvisor.upload

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.*
import com.pvs.pvsadvisor.R


class UploadAdviceTypeFragment : Fragment(R.layout.fragment_upload_advice_type) {
    private var adviceBoxesChecked: Int = 0
    private var adviceCategories: ArrayList<String> = ArrayList(3)
    private var formatType: String = ""

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Initialize advice category selection checkboxes
        val advSkillDev = view.findViewById<CheckBox>(R.id.adv_skill_dev)
        val advPricing = view.findViewById<CheckBox>(R.id.adv_pricing)
        val advSales = view.findViewById<CheckBox>(R.id.adv_sales)
        val advPromote = view.findViewById<CheckBox>(R.id.adv_promote)
        val advProduct = view.findViewById<CheckBox>(R.id.adv_product)
        val advFindSupp = view.findViewById<CheckBox>(R.id.adv_find_supp)
        val advBudget = view.findViewById<CheckBox>(R.id.adv_budget)
        val advBusiness = view.findViewById<CheckBox>(R.id.adv_business)

        //Advice category onClickListener
        advSkillDev.setOnClickListener { onAdviceCheckbox(view,advSkillDev) }
        advPricing.setOnClickListener { onAdviceCheckbox(view,advPricing) }
        advSales.setOnClickListener { onAdviceCheckbox(view,advSales) }
        advPromote.setOnClickListener { onAdviceCheckbox(view,advPromote) }
        advProduct.setOnClickListener { onAdviceCheckbox(view,advProduct) }
        advFindSupp.setOnClickListener { onAdviceCheckbox(view,advFindSupp) }
        advBudget.setOnClickListener { onAdviceCheckbox(view,advBudget) }
        advBusiness.setOnClickListener { onAdviceCheckbox(view,advBusiness) }

        //Initialize advice detail EditText
        val adviceDetailEditText: EditText = view.findViewById(R.id.advice_det_edit_text)

        //Initialize format type to pdf file
        formatType = getString(R.string.fmt_pdf)

        //Initialize Format Type RadioButtons
        val formatPDF: RadioButton = view.findViewById(R.id.fmt_pdf)
        val formatJPEG: RadioButton = view.findViewById(R.id.fmt_jpeg)
        val formatPNG: RadioButton = view.findViewById(R.id.fmt_png)

        //Format Type RadioButton onCheckListeners
        formatPDF.setOnClickListener { formatType = getString(R.string.fmt_pdf) }
        formatJPEG.setOnClickListener { formatType = getString(R.string.fmt_jpeg) }
        formatPNG.setOnClickListener { formatType = getString(R.string.fmt_png) }

        val nextBtn = view.findViewById<Button>(R.id.uploadNextButton_adv)
        val saveBtn = view.findViewById<Button>(R.id.uploadSaveButton_adv)
        nextBtn.setOnClickListener {
            when {
                (adviceBoxesChecked <= 0) ->
                    Toast.makeText(view.context,getString(R.string.advice_type_required),Toast.LENGTH_SHORT).show()
                (TextUtils.isEmpty(adviceDetailEditText.text)) ->
                    Toast.makeText(view.context,getString(R.string.advice_detail_required),Toast.LENGTH_SHORT).show()
                else ->
                    {/*Navigate to review*/}
            }
        }
        saveBtn.setOnClickListener {
            //TODO: Save activity data
            activity?.finish()
        }
    }

    private fun onAdviceCheckbox(view: View, checkbox: CheckBox) {
        val checked: Boolean = checkbox.isChecked

        if (adviceBoxesChecked < 3 || !checked) {
            when (checkbox.id) {
                R.id.adv_skill_dev -> {
                    if (checked) {
                        adviceCategories.add(getString(R.string.adv_skill_dev))
                        adviceBoxesChecked += 1
                    }
                    else {
                        adviceCategories.remove(getString(R.string.adv_skill_dev))
                        adviceBoxesChecked -= 1
                    }
                }
                R.id.adv_pricing -> {
                    if (checked) {
                        adviceCategories.add(getString(R.string.adv_pricing))
                        adviceBoxesChecked += 1
                    }
                    else {
                        adviceCategories.remove(getString(R.string.adv_pricing))
                        adviceBoxesChecked -= 1
                    }
                }
                R.id.adv_sales -> {
                    if (checked) {
                        adviceCategories.add(getString(R.string.adv_sales))
                        adviceBoxesChecked += 1
                    }
                    else {
                        adviceCategories.remove(getString(R.string.adv_sales))
                        adviceBoxesChecked -= 1
                    }
                }
                R.id.adv_promote -> {
                    if (checked) {
                        adviceCategories.add(getString(R.string.adv_promote))
                        adviceBoxesChecked += 1
                    }
                    else {
                        adviceCategories.remove(getString(R.string.adv_promote))
                        adviceBoxesChecked -= 1
                    }
                }
                R.id.adv_product -> {
                    if (checked) {
                        adviceCategories.add(getString(R.string.adv_product))
                        adviceBoxesChecked += 1
                    }
                    else {
                        adviceCategories.remove(getString(R.string.adv_product))
                        adviceBoxesChecked -= 1
                    }
                }
                R.id.adv_find_supp -> {
                    if (checked) {
                        adviceCategories.add(getString(R.string.adv_find_supp))
                        adviceBoxesChecked += 1
                    }
                    else {
                        adviceCategories.remove(getString(R.string.adv_find_supp))
                        adviceBoxesChecked -= 1
                    }
                }
                R.id.adv_budget -> {
                    if (checked) {
                        adviceCategories.add(getString(R.string.adv_budget))
                        adviceBoxesChecked += 1
                    }
                    else {
                        adviceCategories.remove(getString(R.string.adv_budget))
                        adviceBoxesChecked -= 1
                    }
                }
                R.id.adv_business -> {
                    if (checked) {
                        adviceCategories.add(getString(R.string.adv_business))
                        adviceBoxesChecked += 1
                    }
                    else {
                        adviceCategories.remove(getString(R.string.adv_business))
                        adviceBoxesChecked -= 1
                    }
                }
            }
        }
        else {
            checkbox.toggle()
            Toast.makeText(view.context,getText(R.string.advice_selection_limit_reached),Toast.LENGTH_SHORT).show()
        }
    }

}