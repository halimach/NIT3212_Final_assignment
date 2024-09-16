package com.vu.nit3212_final_assignment.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vu.nit3212_final_assignment.R
import com.vu.nit3212_final_assignment.data.Entity

// Activity class responsible for displaying the dashboard.
 //It shows a list of entities in a RecyclerView and handles navigation to the EntityScreen.

class DashboardActivity : AppCompatActivity() {
    // RecyclerView to display the list of entities
    private lateinit var recyclerView: RecyclerView
    // Adapter to manage and display the list of entities
    private lateinit var entityAdapter: EntityAdapter
    // ViewModel to handle dashboard data
    private lateinit var dashboardViewModel: DashboardViewModel

    //Called when the activity is created.
     //Initializes the UI components and sets up the RecyclerView and ViewModel.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dashboard)

        // Initialize RecyclerView and set its layout manager
        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Initialize the adapter with an empty list and set it to the RecyclerView
        entityAdapter = EntityAdapter(emptyList()) { entity -> onEntityClick(entity) }
        recyclerView.adapter = entityAdapter

        // Create an instance of DashboardViewModel using ViewModelProvider
        dashboardViewModel = ViewModelProvider(this).get(DashboardViewModel::class.java)

        // Retrieve the keypass from the intent
        val keypass = intent.getStringExtra("keypass")
        if (keypass != null) {
            // Fetch dashboard data if keypass is available
            fetchDashboardData(keypass)
        } else {
            // Show an error message if keypass is missing
            Toast.makeText(this, "Error: Keypass missing", Toast.LENGTH_SHORT).show()
        }
    }

    //Fetches dashboard data from the ViewModel and updates the RecyclerView adapter.
    // keypass: The keypass used to fetch the data.

    private fun fetchDashboardData(keypass: String) {
        // Request dashboard data from the ViewModel
        dashboardViewModel.getDashboardData(keypass)
        // Observe the LiveData for changes and update the adapter with new data
        dashboardViewModel.dashboardData.observe(this) { entities ->
            if (entities != null) {
                // Update the adapter with the fetched data
                entityAdapter.updateList(entities)
            } else {
                // Show an error message if data loading fails
                Toast.makeText(this, "Data unable to load", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Handles click events on entities in the RecyclerView.
    // Navigates to the EntityScreen with the selected entity details.
    // entity: The entity that was clicked.

    private fun onEntityClick(entity: Entity) {
        // Create an intent to navigate to the EntityScreen
        val intent = Intent(this, EntityScreen::class.java)
        // Pass the selected entity as an extra
        intent.putExtra("selectedEntity", entity)
        // Start the EntityScreen activity
        startActivity(intent)
    }
}

