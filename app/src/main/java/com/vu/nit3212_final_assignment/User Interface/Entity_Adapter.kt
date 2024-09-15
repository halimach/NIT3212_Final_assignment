package com.vu.nit3212_final_assignment.User

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.assessment2.R
import com.example.assessment2.data.Entity

class Entity_Adapter(
    private var entityList: List<Entity>,
    private val onItemClick: (Entity) -> Unit
) : RecyclerView.Adapter<EntityAdapter.EntityViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EntityViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_plant, parent, false)
        return EntityViewHolder(view)
    }

    override fun onBindViewHolder(holder: EntityViewHolder, position: Int) {
        val entity = entityList[position]
        holder.bind(entity, onItemClick)
    }

    override fun getItemCount(): Int = entityList.size


    fun updateList(newList: List<Entity>) {
        entityList = newList
        notifyDataSetChanged()
    }

    class EntityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val itemOne: TextView = itemView.findViewById(R.id.tv_scientific_name)
        private val itemTwo: TextView = itemView.findViewById(R.id.tv_common_name)
        private val itemThree: TextView = itemView.findViewById(R.id.tv_care_level)
        private val itemFour: TextView = itemView.findViewById(R.id.tv_light_requirement)

        fun bind(entity: Entity, onItemClick: (Entity) -> Unit) {
            itemOne.text = entity.scientificName
            itemTwo.text = entity.commonName
            itemThree.text = entity.careLevel
            itemFour.text = entity.lightRequirement
            itemView.setOnClickListener { onItemClick(entity) }
        }
    }
}