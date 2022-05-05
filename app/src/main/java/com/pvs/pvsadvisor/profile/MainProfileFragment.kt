package com.pvs.pvsadvisor.profile

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.pvs.pvsadvisor.MainActivity
import com.pvs.pvsadvisor.R

class MainProfileFragment : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val settingsBtn = view.findViewById<Button>(R.id.settingsBtn)
        settingsBtn.setOnClickListener{
//            val intent = Intent(view.context, SettingsActivity::class.java)
//            startActivity(intent)
            startActivity(Intent(Settings.ACTION_SETTINGS))
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.main_profile_fragment, container, false)
    }


}