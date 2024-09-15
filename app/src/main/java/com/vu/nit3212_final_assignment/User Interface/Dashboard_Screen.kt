
package com.vu.nit3212_final_assignment.user

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vu.nit3212_final_assignment.DashboardViewModel
import com.vu.nit3212_final_assignment.R
import com.vu.nit3212_final_assignment.User.Entity_Screen
import com.vu.nit3212_final_assignment.data.Entity

class Dashboard_Screen :AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var Entity_Adapter: EntityAdapter
    private lateinit var dashboardViewModel: DashboardViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dashboard)

        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        Entity_Adapter = EntityAdapter(emptyList()) { entity -> onEntityClick(entity) }
        recyclerView.adapter = Entity_Adapter

        dashboardViewModel = DashboardViewModel() // Initialize manually

        val keypass = intent.getStringExtra("keypass")
        if (keypass != null) {
            fetchDashboardData(keypass)
        } else {
            Toast.makeText(this, "Error: Keypass missing", Toast.LENGTH_SHORT).show()
        }
    }

    private fun fetchDashboardData(keypass: String) {
        dashboardViewModel.getDashboardData(keypass)
        dashboardViewModel.dashboardData.observe(this) { dashboardOutput ->
            if (dashboardOutput != null) {
                Entity_Adapter.updateList(dashboardOutput)
            } else {
                Toast.makeText(this, "Data unable to load", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun onEntityClick(entity: Entity) {
        val intent = Intent(this, Entity_Screen::class.java)
        intent.putExtra("selectedEntity", entity)
        startActivity(intent)
    }
}