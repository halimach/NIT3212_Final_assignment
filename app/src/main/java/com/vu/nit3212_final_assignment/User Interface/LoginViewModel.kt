package com.vu.nit3212_final_assignment.User

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vu.nit3212_final_assignment.Data.Login_Output
import com.vu.nit3212_final_assignment.repository.Login_Api
import kotlinx.coroutines.launch

class LoginViewModel(private val loginApi: Login_Api) : ViewModel() {

    private val _loginResult = MutableLiveData<Login_Output?>()
    val loginResult: LiveData<Login_Output?> = _loginResult

    fun login(username: String, password: String) {
        viewModelScope.launch {
            try {
                val response = loginApi.login(username, password)
                if (response.isSuccessful) {
                    _loginResult.value = response.body()
                } else {
                    _loginResult.value = null // Login failed
                }
            } catch (e: Exception) {
                _loginResult.value = null // Handle error
            }
        }
    }
}
