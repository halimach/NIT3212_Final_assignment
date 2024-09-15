package com.vu.nit3212_final_assignment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vu.nit3212_final_assignment.Respositoryimport.dashboard_api
import com.vu.nit3212_final_assignment.data.Entity
import kotlinx.coroutines.launch

class DashboardViewModel : ViewModel() {

    private val _dashboardData = MutableLiveData<List<Entity>>()
    val dashboardData: LiveData<List<Entity>> = _dashboardData

    fun getDashboardData(keypass: String) {
        viewModelScope.launch {
            try {
                val response = dashboard_api.getDashboardData(keypass)
                _dashboardData.value = response.body()?.entities ?: emptyList() // Handle null
            } catch (e: Exception) {
                _dashboardData.value = emptyList() // Set empty list on error
            }
        }
    }
}
