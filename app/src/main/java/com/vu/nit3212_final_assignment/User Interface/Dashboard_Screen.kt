package com.vu.nit3212_final_assignment.User
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.assessment2.R
import com.example.assessment2.data.Entity
import com.example.assessment2.viewmodel.DashboardViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class Dashboard_Screen : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var entityAdapter: EntityAdapter


    private val dashboardViewModel: DashboardViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)


        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)


        entityAdapter = EntityAdapter(emptyList()) { entity -> onEntityClick(entity) }
        recyclerView.adapter = entityAdapter

        val keypass = intent.getStringExtra("keypass")

        if (keypass != null) {
            fetchDashboardData(keypass)
        } else {
            Toast.makeText(this, "Error: Keypass missing", Toast.LENGTH_SHORT).show()
        }
    }

    private fun fetchDashboardData(keypass: String) {

        dashboardViewModel.getDashboardData(keypass)


        dashboardViewModel.dashboardData.observe(this) { dashboardResponse ->
            if (dashboardResponse != null) {

                entityAdapter.updateList(dashboardResponse.entities)
            } else {

                Toast.makeText(this, "Data unable to load", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun onEntityClick(entity: Entity) {
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra("selectedEntity", entity)  // Pass the Parcelable entity
        startActivity(intent)
    }
}