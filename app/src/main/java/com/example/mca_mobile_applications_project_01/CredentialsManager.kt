// Put your package name here. Check your activity for reference.
package com.example.xyz

class CredentialsManager {
    fun isEmailValid(email: String): Boolean {
        if (email.isEmpty()) return false
        val emailRegex = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$"
        return Regex(emailRegex).matches(email)
    }

    fun isPasswordValid(password: String): Boolean {
        return password.isNotEmpty()
    }
}