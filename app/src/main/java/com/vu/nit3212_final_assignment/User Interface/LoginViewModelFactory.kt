package com.vu.nit3212_final_assignment.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.vu.nit3212_final_assignment.repository.Login_Api
import com.vu.nit3212_final_assignment.user.Remodelling

//Factory class for creating instances of [Remodelling] ViewModel.
//loginApi The API service used for login operations.

class LoginViewModelFactory(private val loginApi: Login_Api) : ViewModelProvider.Factory {

    //Creates a new instance of the specified ViewModel class.
     //modelClass The class of the ViewModel to create.
    // return A new instance of the specified ViewModel class.
     //throws IllegalArgumentException If the ViewModel class is not supported.

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        // Check if the ViewModel class is of type Remodelling
        if (modelClass.isAssignableFrom(Remodelling::class.java)) {
            // Create and return an instance of Remodelling ViewModel
            return Remodelling(loginApi) as T
        }
        // Throw an exception if the ViewModel class is unknown
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

