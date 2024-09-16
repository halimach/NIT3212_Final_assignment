package com.vu.nit3212_final_assignment.user

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vu.nit3212_final_assignment.Data.LoginResponse
import com.vu.nit3212_final_assignment.repository.Login_Api
import kotlinx.coroutines.launch

//ViewModel for handling user login operations.
// loginApi: The API service for performing login operations.

class Remodelling(private val loginApi: Login_Api) : ViewModel() {

    // LiveData to hold the login result
    private val _loginResult = MutableLiveData<LoginResponse?>()
    val loginResult: LiveData<LoginResponse?> = _loginResult

    // Initiates a login request using the provided username and password.
    // username: The username input for login.
    // password: The password input for login.

    fun login(username: String, password: String) {
        viewModelScope.launch {
            try {
                // Perform login via the API service
                val response = loginApi.login(username, password)
                if (response.isSuccessful) {
                    // Update LiveData with the successful response body
                    _loginResult.value = response.body()
                } else {
                    // Update LiveData to null if the login fails
                    _loginResult.value = null
                }
            } catch (e: Exception) {
                // Update LiveData to null if an error occurs
                _loginResult.value = null
            }
        }
    }
}

