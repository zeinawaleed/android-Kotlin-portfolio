package com.example.myapplication


import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var emailField: EditText
    private lateinit var passwordField: EditText
    private lateinit var loginBtn: Button
    private lateinit var signupRedirect: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        emailField = findViewById(R.id.login_email)
        passwordField = findViewById(R.id.login_password)
        loginBtn = findViewById(R.id.login_button)
        signupRedirect = findViewById(R.id.signup_link)

        loginBtn.setOnClickListener {
            val email = emailField.text.toString().trim()
            val password = passwordField.text.toString().trim()

            val sharedPref = getSharedPreferences("FitnessApp", MODE_PRIVATE)
            val savedEmail = sharedPref.getString("email", null)
            val savedPassword = sharedPref.getString("password", null)

            if (email == savedEmail && password == savedPassword) {
                Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, HomeActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show()
            }
        }

        signupRedirect.setOnClickListener {
            startActivity(Intent(this, SignupActivity::class.java))
        }
    }
}
