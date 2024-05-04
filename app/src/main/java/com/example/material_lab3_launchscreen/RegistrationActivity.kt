package com.example.material_lab3_launchscreen

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class RegistrationActivity : AppCompatActivity() {
    lateinit var nameRegistrationTB : TextInputEditText
    lateinit var emailRegistrationTB : TextInputEditText
    lateinit var passwordRegistrationTB : TextInputEditText
    lateinit var passwordRepeatRegistrationTB : TextInputEditText
    lateinit var singUpButton: Button
    lateinit var cancelButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        nameRegistrationTB = findViewById(R.id.TIEDnameReg)
        emailRegistrationTB = findViewById(R.id.TIEDemailReg)
        passwordRegistrationTB = findViewById(R.id.TIEDpasswordReg)
        passwordRepeatRegistrationTB = findViewById(R.id.TIEDpasswordRepeatReg)
        singUpButton = findViewById(R.id.SingUpButtonRegister)
        cancelButton = findViewById(R.id.cancel_button)


        cancelButton.setOnClickListener {
            Intent(this@RegistrationActivity, MainActivity::class.java).also {
                startActivity(it)
            }
        }

        singUpButton.setOnClickListener {
            Intent(this@RegistrationActivity, AccountActivity::class.java).also {

                if (globalFunctions.checkEmail(emailRegistrationTB.text.toString())) {
                    emailRegistrationTB.error = "Email incorrect"
                    return@also
                }

                if (globalFunctions.checkPasswordLength(passwordRegistrationTB.text.toString())) {
                    passwordRegistrationTB.error = "Password should be more than 8 symbols"
                    return@also
                }

                if (passwordRegistrationTB.text.toString() == passwordRepeatRegistrationTB.text.toString()) {
                    it.putExtra("name", nameRegistrationTB.text.toString())
                    it.putExtra("email", emailRegistrationTB.text.toString())
                    it.putExtra("password", passwordRegistrationTB.text.toString())
                    startActivity(it)
                } else {
                    passwordRegistrationTB.error = "Passwords isnt equal"
                    passwordRepeatRegistrationTB.error = "Passwords isnt equal"
                    return@also
                }
            }
        }
    }
}