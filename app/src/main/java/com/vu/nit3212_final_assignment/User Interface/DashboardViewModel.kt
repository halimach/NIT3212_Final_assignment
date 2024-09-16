package com.vu.nit3212_final_assignment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vu.nit3212_final_assignment.Respositoryimport.dashboard_api
import com.vu.nit3212_final_assignment.data.Entity
import kotlinx.coroutines.launch

//ViewModel class responsible for fetching and managing dashboard data.

class DashboardViewModel : ViewModel() {

    // MutableLiveData to hold the list of entities for the dashboard
    private val _dashboardData = MutableLiveData<List<Entity>>()
    // Exposed LiveData to observe changes to the dashboard data
    val dashboardData: LiveData<List<Entity>> get() = _dashboardData

    // Fetches dashboard data from the repository and updates the LiveData.
     //keypass The keypass used to fetch the data.

    fun getDashboardData(keypass: String) {
        // Launch a coroutine in the ViewModel's scope
        viewModelScope.launch {
            try {
                // Request dashboard data from the repository
                val response = dashboard_api.getDashboardData(keypass)
                // Update LiveData with the fetched entities or an empty list if null
                _dashboardData.value = response.body()?.entities ?: emptyList()
            } catch (e: Exception) {
                // Set LiveData to an empty list in case of an error
                _dashboardData.value = emptyList()
            }
        }
    }
}

