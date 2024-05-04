package com.example.material_lab3_launchscreen

object globalFunctions {
    private val emailRegex = Regex("[a-z]+@[a-z]+\\.[a-z]{2,3}")
    private val MIN_LENGTH = 8
    fun checkEmail(email: String): Boolean {
        return !email.matches(emailRegex)
    }

    fun checkPasswordLength(password: String): Boolean {
        return password.length < MIN_LENGTH
    }
}