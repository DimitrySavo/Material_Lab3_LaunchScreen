package com.example.material_lab3_launchscreen

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.addTextChangedListener
import com.google.android.material.textfield.TextInputEditText

class AccountActivity : AppCompatActivity() {
    lateinit var nameOnImageTV: TextView
    lateinit var emailOnImageTV: TextView
    lateinit var accountNameTB: TextInputEditText
    lateinit var accountEmailTB: TextInputEditText
    lateinit var accountPasswordTB: TextInputEditText
    lateinit var exitButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_account)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        nameOnImageTV = findViewById<TextView?>(R.id.NameOnImageTV).also {
            if (intent.getStringExtra("name") != null) {
                it.text = intent.getStringExtra("name")
            }
        }
        emailOnImageTV = findViewById<TextView?>(R.id.EmailOnImageTV).also {
            if (intent.getStringExtra("email") != null) {
                it.text = intent.getStringExtra("email")
            }
        }
        accountNameTB = findViewById<TextInputEditText?>(R.id.TIEDnameAcc).also {
            if (intent.getStringExtra("name") != null) {
                it.setText(intent.getStringExtra("name"))
            }
        }
        accountEmailTB = findViewById<TextInputEditText?>(R.id.TIEDemailAcc).also {
            if (intent.getStringExtra("email") != null) {
                it.setText(intent.getStringExtra("email"))
            }
        }
        accountPasswordTB = findViewById<TextInputEditText?>(R.id.TIEDpasswordAcc).also {
            if (intent.getStringExtra("password") != null) {
                it.setText(intent.getStringExtra("password"))
            }
        }

        exitButton = findViewById(R.id.exitAccountButton)

        exitButton.setOnClickListener {
            Intent(this@AccountActivity, MainActivity::class.java).also {
                startActivity(it)
            }
        }

        accountEmailTB.addTextChangedListener {
            if (globalFunctions.checkEmail(it.toString())) {
                accountEmailTB.error = "Email not correct"
            }
        }


    }
}