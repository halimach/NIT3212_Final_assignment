package com.vu.nit3212_final_assignment.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.vu.nit3212_final_assignment.User.LoginViewModel
import com.vu.nit3212_final_assignment.repository.Login_Api

class LoginViewModelFactory(private val loginApi: Login_Api) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return LoginViewModel(loginApi) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
