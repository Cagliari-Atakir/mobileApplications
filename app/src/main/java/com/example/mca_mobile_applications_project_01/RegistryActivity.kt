package com.example.mca_mobile_applications_project_01

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.xyz.CredentialsManager

class RegistryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_account_page) // Link to the correct XML layout

        val alreadyMemberTextView: TextView = findViewById(R.id.textAlreadyMember)

        // Set a click listener
        alreadyMemberTextView.setOnClickListener {
            // Navigate to MainActivity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}