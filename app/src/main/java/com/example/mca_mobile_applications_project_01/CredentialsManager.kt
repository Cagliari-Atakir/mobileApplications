package com.example.mca_mobile_applications_project_01

class CredentialsManager {
    // Store email and password pairs in a mutable map (case insensitive)
    private val credentialsMap = mutableMapOf<String, String>()

    // Validate email format using regex
    fun isEmailValid(email: String): Boolean {
        if (email.isEmpty()) return false
        val emailRegex = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$"
        return Regex(emailRegex).matches(email)
    }

    // Validate password (can be expanded as needed)
    fun isPasswordValid(password: String): Boolean {
        return password.isNotEmpty()
    }

    // Register a new account (returns true if successful, false if email is already taken)
    fun register(email: String, password: String): Boolean {
        // Check if email is already registered (case insensitive)
        if (credentialsMap.containsKey(email.lowercase())) {
            return false
        }
        // Store the new email and password
        credentialsMap[email.lowercase()] = password
        return true
    }

    // Authenticate an account
    fun authenticate(email: String, password: String): Boolean {
        return credentialsMap[email.lowercase()] == password
    }
}
