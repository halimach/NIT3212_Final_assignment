package com.vu.nit3212_final_assignment.ui

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.vu.nit3212_final_assignment.R
import com.vu.nit3212_final_assignment.data.Entity
// Activity to display detailed information about an Entity.

class EntityScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Set the content view to the layout for entity details

        setContentView(R.layout.entity_details)
        // Retrieve the Entity object passed via the intent

        val selectedEntity: Entity? = intent.getParcelableExtra("selectedEntity")
        // Get references to the TextView elements from the layout

        val sportNameTextView = findViewById<TextView>(R.id.sportName)
        val playerCountTextView = findViewById<TextView>(R.id.playerCount)
        val fieldTypeTextView = findViewById<TextView>(R.id.fieldType)
        val olympicSportTextView = findViewById<TextView>(R.id.olympicSport)
        val descriptionTextView = findViewById<TextView>(R.id.description)
        // If the selectedEntity is not null, populate the TextViews with its data

        selectedEntity?.let {
            sportNameTextView.text = it.sportName
            playerCountTextView.text = it.playerCount.toString()
            fieldTypeTextView.text = it.fieldType
            olympicSportTextView.text = if (it.olympicSport) "Yes" else "No"
            descriptionTextView.text = it.description
        }
    }
}