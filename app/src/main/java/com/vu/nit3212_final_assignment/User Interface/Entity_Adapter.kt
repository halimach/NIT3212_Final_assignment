package com.vu.nit3212_final_assignment.user

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.vu.nit3212_final_assignment.R
import com.vu.nit3212_final_assignment.data.Entity

class EntityAdapter(
    private var entityList: List<Entity>,
    private val onItemClick: (Entity) -> Unit
) : RecyclerView.Adapter<EntityAdapter.EntityViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EntityViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.entity_list, parent, false)
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
        private val sportName: TextView = itemView.findViewById(R.id.sportName)
        private val playerCount: TextView = itemView.findViewById(R.id.playerCount)
        private val fieldType: TextView = itemView.findViewById(R.id.fieldType)
        private val olympicSport: TextView = itemView.findViewById(R.id.olympicSport)

        fun bind(entity: Entity, onItemClick: (Entity) -> Unit) {
            sportName.text = entity.sportName
            playerCount.text = entity.playerCount
            fieldType.text = entity.fieldType
            olympicSport.text = entity.olympicSport
            itemView.setOnClickListener { onItemClick(entity) }
        }
    }
}

