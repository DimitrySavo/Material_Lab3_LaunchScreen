package com.example.material_lab3_launchscreen

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    lateinit var signInButton: Button
    lateinit var signUpButton: Button
    lateinit var emailTV: TextInputEditText
    lateinit var passwordTV: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        signInButton = findViewById(R.id.SingInButton)
        signUpButton = findViewById(R.id.SingUpButton)
        emailTV = findViewById(R.id.TIEDemailMain)
        passwordTV = findViewById(R.id.TIEDpasswordMain)

        signInButton.setOnClickListener {
            Intent(this@MainActivity, AccountActivity::class.java).also {
                if (globalFunctions.checkEmail(emailTV.text.toString())) {
                    emailTV.error = "Email incorrect"
                    return@also
                }

                if (globalFunctions.checkPasswordLength(passwordTV.text.toString())) {
                    passwordTV.error = "Password should be more than 8 symbols"
                    return@also
                }

                it.putExtra("email", emailTV.text.toString())
                it.putExtra("password", passwordTV.text.toString())
                startActivity(it)
            }
        }

        signUpButton.setOnClickListener {
            Intent(this@MainActivity, RegistrationActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}