package com.pvs.pvsadvisor

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.pvs.pvsadvisor.R
import com.pvs.pvsadvisor.upload.UploadMain
import com.ramotion.paperonboarding.PaperOnboardingFragment
import com.ramotion.paperonboarding.PaperOnboardingPage
import java.util.ArrayList

class OnboardActivity : AppCompatActivity() {
    lateinit var getStartedBTN : Button
    private var fragmentManager: FragmentManager? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboard)
        fragmentManager = supportFragmentManager

        // new instance is created and data is took from an
        // array list known as getDataonborading
        val paperOnboardingFragment = PaperOnboardingFragment.newInstance(
            dataforOnboarding
        )
        val fragmentTransaction = fragmentManager!!.beginTransaction()

        // fragmentTransaction method is used
        // do all the transactions or changes
        // between different fragments
        fragmentTransaction.add(R.id.frame_layout, paperOnboardingFragment)

        // all the changes are committed
        fragmentTransaction.commit()

        // If user is ready, then he/she can go on from on-boarding to login process.
        // Clears button sight and transitions overlay of fragment container.
        val buttonGetStarted : Button = findViewById(R.id.btnGetStarted)
        buttonGetStarted.setOnClickListener {
            val loginFragment = LoginFragment()
            val fragment : Fragment? = supportFragmentManager.findFragmentByTag(loginFragment::class.java.simpleName)
            if(fragment !is LoginFragment){
                buttonGetStarted.visibility = View.GONE;
                supportFragmentManager.beginTransaction().add(R.id.LinearFragment_Container, loginFragment, LoginFragment::class.java.simpleName).commit()
            }
        }

    }

    // the first string is to show the main title ,
    // second is to show the message below the
    // title, then color of background is passed ,
    // then the image to show on the screen is passed
    // and at last icon to navigate from one screen to other
    private val dataforOnboarding: ArrayList<PaperOnboardingPage>
        private get() {

            // the first string is to show the main title ,
            // second is to show the message below the
            // title, then color of background is passed ,
            // then the image to show on the screen is passed
            // and at last icon to navigate from one screen to other
            val source = PaperOnboardingPage(
                "Share Your Vision",
                "All examples rely on the best enlgish programmers.",
                Color.parseColor("#E0AEFF"),
                R.drawable.ic_dreameronboard,
                R.drawable.ic_baseline_search_24
            )
            val source1 = PaperOnboardingPage(
                "Advice from Professionals",
                "All examples rely on the best enlgish programmers.",
                Color.parseColor("#D3D3D3"),
                R.drawable.ic_workingremotelyonboard,
                R.drawable.ic_baseline_cell_tower_24
            )
            val source2 = PaperOnboardingPage(
                "The Dream is Now Reality",
                "All examples rely on the best enlgish programmers.",
                Color.parseColor("#221F20"),
                R.drawable.ic_teamcollabonboard,
                R.drawable.ic_baseline_checklist_24
            )
            // array list is used to store
            // data of onbaording screen
            val elements = ArrayList<PaperOnboardingPage>()
            // all the sources(data to show on screens)
            // are added to array list
            elements.add(source)
            elements.add(source1)
            elements.add(source2)
            return elements
        }
}