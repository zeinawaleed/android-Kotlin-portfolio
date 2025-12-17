package com.example.myapplication


import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class SignupActivity : AppCompatActivity() {
    private lateinit var emailField: EditText
    private lateinit var passwordField: EditText
    private lateinit var confirmPasswordField: EditText
    private lateinit var signUpBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        emailField = findViewById(R.id.signup_email)
        passwordField = findViewById(R.id.signup_password)
        confirmPasswordField = findViewById(R.id.signup_confirm_password)
        signUpBtn = findViewById(R.id.signup_button)

        signUpBtn.setOnClickListener {
            val email = emailField.text.toString().trim()
            val password = passwordField.text.toString().trim()
            val confirmPassword = confirmPasswordField.text.toString().trim()

            if (email.isEmpty() || !email.contains("@")) {
                emailField.error = "Enter valid email"
                return@setOnClickListener
            }

            if (password.length < 6) {
                passwordField.error = "Password must be at least 6 characters"
                return@setOnClickListener
            }

            if (password != confirmPassword) {
                confirmPasswordField.error = "Passwords do not match"
                return@setOnClickListener
            }

            val sharedPref = getSharedPreferences("FitnessApp", MODE_PRIVATE)
            val editor = sharedPref.edit()
            editor.putString("email", email)
            editor.putString("password", password)
            editor.apply()

            Toast.makeText(this, "Signup Successful", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}
