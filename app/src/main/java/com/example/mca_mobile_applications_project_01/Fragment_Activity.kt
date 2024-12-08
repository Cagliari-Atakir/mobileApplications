package com.example.mca_mobile_applications_project_01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class Fragment_Activity : AppCompatActivity() {

    // Track which fragment is currently displayed
    private var showingFragmentA = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_)

        // Initially load FragmentA
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, FragmentA())
            .commit()

        // Set up the button to toggle between fragments
        val toggleButton: Button = findViewById(R.id.ButtonSwitchFragment)
        toggleButton.setOnClickListener {
            if (showingFragmentA) {
                // Show FragmentB
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, FragmentB())
                    .commit()
            } else {
                // Show FragmentA
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, FragmentA())
                    .commit()
            }
            // Toggle the state
            showingFragmentA = !showingFragmentA
        }
    }
}
