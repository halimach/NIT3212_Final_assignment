package com.vu.nit3212_final_assignment.User

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.vu.nit3212_final_assignment.Data.LoginResponse
import com.vu.nit3212_final_assignment.R
import com.vu.nit3212_final_assignment.network.RetrofitInstance
import com.vu.nit3212_final_assignment.repository.Login_Api
import com.vu.nit3212_final_assignment.user.Remodelling
import com.vu.nit3212_final_assignment.viewmodel.LoginViewModelFactory

//Activity for user login. Handles user input, initiates login, and navigates to the dashboard upon successful login.

class Loginscreen : AppCompatActivity() {

    private lateinit var loginViewModel: Remodelling

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_screen)

        // Manually instantiate Login_Api with Retrofit API service
        val loginApi = Login_Api(RetrofitInstance.apiService)

        // Create a ViewModelFactory and initialize the ViewModel
        val factory = LoginViewModelFactory(loginApi)
        loginViewModel = ViewModelProvider(this, factory).get(Remodelling::class.java)

        // Get references to EditText fields for username and password
        val usernameEditText = findViewById<EditText>(R.id.username)
        val passwordEditText = findViewById<EditText>(R.id.password)

        // Set up the login button click listener
        findViewById<Button>(R.id.login_button).setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            // Check if username and password are not empty
            if (username.isNotEmpty() && password.isNotEmpty()) {
                // Trigger login in the ViewModel
                loginViewModel.login(username, password)
            } else {
                // Show a message if fields are empty
                Toast.makeText(this, "Please fill in both fields", Toast.LENGTH_SHORT).show()
            }
        }

        // Observe the login result from the ViewModel
        loginViewModel.loginResult.observe(this) { loginResponse: LoginResponse? ->
            if (loginResponse != null) {
                // On successful login, retrieve the keypass and navigate to the dashboard
                val keypass = loginResponse.keypass
                Log.d("LoginActivity", "Login successful: keypass = $keypass")
                startDashboardActivity(keypass)
            } else {
                // On failed login, log an error and show a message
                Log.e("LoginActivity", "Login failed")
                Toast.makeText(this, "Login failed", Toast.LENGTH_SHORT).show()
            }
        }
    }

    //Start the DashboardActivity with the provided keypass.
    //keypass The keypass obtained from a successful login.

    private fun startDashboardActivity(keypass: String) {
        val intent = Intent(this, DashboardActivity::class.java)
        intent.putExtra("keypass", keypass)
        startActivity(intent)
    }
}


