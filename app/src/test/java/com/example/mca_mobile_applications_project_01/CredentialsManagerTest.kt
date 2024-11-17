// Put your package name here. Check your activity for reference.
package com.example.xyz

import org.junit.Test
import org.junit.jupiter.api.Assertions.*

class CredentialsManagerTest {

    // Test empty email
    @Test
    fun givenEmptyEmail_thenReturnFalse() {
        val credentialsManager = CredentialsManager()

        val isEmailValid = credentialsManager.isEmailValid("")

        assertEquals(false, isEmailValid)
    }

    // Test wrong email format
    fun givenWrongFormatEmail_thenReturnFalse() {
        val credentialsManager = CredentialsManager()

        val isEmailValid = credentialsManager.isEmailValid("agubugugu")

        assertEquals(false, isEmailValid)
    }
    // Test proper email

    fun givenProperFormatEmail_thenReturnTrue() {
        val credentialsManager = CredentialsManager()

        val isEmailValid = credentialsManager.isEmailValid("abc@gmail.com")

        assertEquals(true, isEmailValid)
    }

    // Test empty password

    fun givenEmptyPassword_thenReturnFalse() {
        val credentialsManager = CredentialsManager()

        val isPasswordValid = credentialsManager.isPasswordValid("")

        assertEquals(false, isEmailValid)
    }
    // Test filled password

    fun givenProperPassword_thenReturnTrue() {
        val credentialsManager = CredentialsManager()

        val isPasswordValid = credentialsManager.isPasswordValid("abc123")

        assertEquals(true, isEmailValid)
    }
}