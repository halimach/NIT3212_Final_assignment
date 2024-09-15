package com.vu.nit3212_final_assignment.User

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.assessment2.R
import com.example.assessment2.viewmodel.LoginViewModel
import com.vu.nit3212_final_assignment.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Login_screen : AppCompatActivity() {


    private val loginViewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_screen)


        val usernameEditText = findViewById<EditText>(R.id.username)
        val passwordEditText = findViewById<EditText>(R.id.password)


        findViewById<Button>(R.id.login_button).setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()


            if (username.isNotEmpty() && password.isNotEmpty()) {
                loginViewModel.login(username, password)
            } else {
                Toast.makeText(this, "Please fill in both fields", Toast.LENGTH_SHORT).show()
            }
        }

        loginViewModel.loginResult.observe(this) { loginResponse ->
            if (loginResponse != null) {

                val keypass = loginResponse.keypass
                Log.d("LoginActivity", "Login successful: keypass = $keypass")
                startDashboardActivity(keypass)
            } else {
                // Login failed
                Log.e("LoginActivity", "Login failed")
                Toast.makeText(this, "Login failed", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun startDashboardActivity(keypass: String) {
        val intent = Intent(this, Dashboard_Screen::class.java)
        intent.putExtra("keypass", keypass)
        startActivity(intent)
    }
}