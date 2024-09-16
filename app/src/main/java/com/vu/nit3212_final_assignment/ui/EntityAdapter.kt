package com.vu.nit3212_final_assignment.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.vu.nit3212_final_assignment.R
import com.vu.nit3212_final_assignment.data.Entity

// Adapter class for displaying a list of entities in a RecyclerView.
// entityList: The initial list of entities to display.
// onItemClick: A callback function to handle item clicks.
class EntityAdapter(
    private var entityList: List<Entity>,
    private val onItemClick: (Entity) -> Unit
) : RecyclerView.Adapter<EntityAdapter.EntityViewHolder>() {

    // Creates a new ViewHolder for the RecyclerView.
    // parent: The parent ViewGroup where the new View will be added.
    // viewType: The view type of the new View.
    // Return: A new instance of EntityViewHolder.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EntityViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.entity_list, parent, false)
        return EntityViewHolder(view)
    }

    // Binds the data to the specified ViewHolder.
    // holder: The ViewHolder to bind data to.
    // position: The position of the item within the adapter's data set.
    override fun onBindViewHolder(holder: EntityViewHolder, position: Int) {
        val entity = entityList[position]
        holder.bind(entity, onItemClick)
    }

    // Returns the number of items in the data set.
    // Return: The number of items in the adapter's data set.
    override fun getItemCount(): Int = entityList.size

    // Updates the list of entities and notifies the adapter of the changes.
    // newList: The new list of entities to display.
    fun updateList(newList: List<Entity>) {
        entityList = newList
        notifyDataSetChanged()
    }

    // ViewHolder class for holding and binding entity item views.
    // itemView: The view for an individual item in the RecyclerView.
    class EntityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val sportName: TextView = itemView.findViewById(R.id.sportName)
        private val playerCount: TextView = itemView.findViewById(R.id.playerCount)
        private val fieldType: TextView = itemView.findViewById(R.id.fieldType)
        private val olympicSport: TextView = itemView.findViewById(R.id.olympicSport)

        // Binds the entity data to the views and sets up click handling.
        // entity: The entity data to display.
        // onItemClick: The callback function for handling item clicks.
        fun bind(entity: Entity, onItemClick: (Entity) -> Unit) {
            sportName.text = entity.sportName
            playerCount.text = entity.playerCount.toString() // Convert Int to String
            fieldType.text = entity.fieldType
            olympicSport.text = if (entity.olympicSport) "Yes" else "No" // Convert Boolean to String
            itemView.setOnClickListener { onItemClick(entity) }
        }
    }
}



