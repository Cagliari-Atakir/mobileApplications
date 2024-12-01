package com.example.mca_mobile_applications_project_01

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout
import com.google.android.material.textfield.TextInputEditText

class RegistryActivity : AppCompatActivity() {

    lateinit var credentialsManager: CredentialsManager
    lateinit var fullNameInput: TextInputEditText
    lateinit var emailInput: TextInputEditText
    lateinit var passwordInput: TextInputEditText
    lateinit var termsCheckBox: CheckBox
    lateinit var validationMessage: TextView
    lateinit var nextButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_account_page)


        credentialsManager = CredentialsManager()
        fullNameInput = findViewById<TextInputLayout>(R.id.textfieldFullName).editText as TextInputEditText
        emailInput = findViewById<TextInputLayout>(R.id.textfieldValidEmail).editText as TextInputEditText
        passwordInput = findViewById<TextInputLayout>(R.id.textfieldStrongPassword).editText as TextInputEditText
        termsCheckBox = findViewById<CheckBox>(R.id.checkBoxTermsAndConditions)
        validationMessage = findViewById<TextView>(R.id.validationMessage)
        nextButton = findViewById(R.id.buttonNext)


        val alreadyMemberTextView: TextView = findViewById(R.id.textAlreadyMember)

        alreadyMemberTextView.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        nextButton.setOnClickListener {
            handleRegistration()
        }
    }

    private fun handleRegistration() {
        val fullName = fullNameInput.text.toString()
        val email = emailInput.text.toString()
        val password = passwordInput.text.toString()

        // Clear previous validation message
        validationMessage.visibility = View.GONE

        // Validate email
        if (!credentialsManager.isEmailValid(email)) {
            validationMessage.text = "Please enter a valid email address."
            validationMessage.visibility = View.VISIBLE
            return
        }
        // Validate password
        if (!credentialsManager.isPasswordValid(password)) {
            validationMessage.text = "Password cannot be empty."
            validationMessage.visibility = View.VISIBLE
            return
        }

        // Ensure terms and conditions are accepted
        if (!termsCheckBox.isChecked) {
            validationMessage.text = "You must agree to the terms and conditions."
            validationMessage.visibility = View.VISIBLE
            return
        }

    }
}