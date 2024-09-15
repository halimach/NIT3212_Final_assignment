package com.vu.nit3212_final_assignment.User
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.assessment2.R
import com.example.assessment2.data.Entity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Entity_Screen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val selectedEntity = intent.getParcelableExtra<Entity>("selectedEntity")

        val itemOne = findViewById<TextView>(R.id.itemOne)
        val itemTwo = findViewById<TextView>(R.id.itemTwo)
        val itemThree = findViewById<TextView>(R.id.itemThree)
        val itemFour = findViewById<TextView>(R.id.itemFour)
        val itemFive = findViewById<TextView>(R.id.itemFive)

        selectedEntity?.let {
            itemOne.text = it.itemOne
            itemTwo.text = it.itemTwo
            itemThree.text = it.itemThree
            itemFour.text = it.itemFour
            itemFive.text = it.itemFive
        }
    }
}