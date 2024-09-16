package com.vu.nit3212_final_assignment.User

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.vu.nit3212_final_assignment.R
import com.vu.nit3212_final_assignment.data.Entity

//Activity class for displaying details of a selected entity.

class EntityScreen : AppCompatActivity() {

    //Called when the activity is first created.
     // savedInstanceState The saved state of the activity, if any.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.entity_details)

        // Retrieve the selected entity passed via intent
        val selectedEntity: Entity? = intent.getParcelableExtra("selectedEntity")

        // Find the TextViews in the layout
        val sportNameTextView = findViewById<TextView>(R.id.sportName)
        val playerCountTextView = findViewById<TextView>(R.id.playerCount)
        val fieldTypeTextView = findViewById<TextView>(R.id.fieldType)
        val olympicSportTextView = findViewById<TextView>(R.id.olympicSport)
        val descriptionTextView = findViewById<TextView>(R.id.description)

        // Populate the TextViews with entity data if an entity is selected
        selectedEntity?.let {
            sportNameTextView.text = it.sportName
            playerCountTextView.text = it.playerCount
            fieldTypeTextView.text = it.fieldType
            olympicSportTextView.text = it.olympicSport
            descriptionTextView.text = it.description
        }
    }
}
