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
        private val itemOne: TextView = itemView.findViewById(R.id.itemOne)
        private val itemTwo: TextView = itemView.findViewById(R.id.itemTwo)
        private val itemThree: TextView = itemView.findViewById(R.id.itemThree)
        private val itemFour: TextView = itemView.findViewById(R.id.itemFour)

        fun bind(entity: Entity, onItemClick: (Entity) -> Unit) {
            itemOne.text = entity.itemOne
            itemTwo.text = entity.itemTwo
            itemThree.text = entity.itemThree
            itemFour.text = entity.itemFour
            itemView.setOnClickListener { onItemClick(entity) }
        }
    }
}

