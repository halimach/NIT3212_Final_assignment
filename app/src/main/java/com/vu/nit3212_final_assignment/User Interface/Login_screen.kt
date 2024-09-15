package com.vu.nit3212_final_assignment.User

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.vu.nit3212_final_assignment.R
import com.vu.nit3212_final_assignment.network.RetrofitInstance
import com.vu.nit3212_final_assignment.repository.Login_Api
import com.vu.nit3212_final_assignment.viewmodel.LoginViewModelFactory
import com.vu.nit3212_final_assignment.user.Dashboard_Screen


class Login_screen : AppCompatActivity() {

    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_screen)

        // Manually instantiate Login_Api
        val loginApi = Login_Api(RetrofitInstance.apiService)

        // Use ViewModelFactory to create LoginViewModel
        val factory = LoginViewModelFactory(loginApi)
        loginViewModel = ViewModelProvider(this, factory).get(LoginViewModel::class.java)

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

        // Observe login result from the ViewModel
        loginViewModel.loginResult.observe(this) { loginResponse ->
            if (loginResponse != null) {
                val keypass = loginResponse.keypass
                Log.d("LoginActivity", "Login successful: keypass = $keypass")
                startDashboardActivity(keypass)
            } else {
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
