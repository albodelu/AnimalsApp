package com.alorma.animals.animalslist.ui.viewholder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.alorma.animals.animalslist.presentation.model.AnimalViewModel

class AnimalItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bind(animal: AnimalViewModel.AnimalItemViewModel) {
        itemView.findViewById<TextView>(android.R.id.text1).text = animal.name
        itemView.findViewById<TextView>(android.R.id.text2).text = animal.createdDate
    }

    companion object {
        fun build(parent: ViewGroup): AnimalItemViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(android.R.layout.simple_list_item_2, parent, false)

            return AnimalItemViewHolder(view)
        }
    }

}