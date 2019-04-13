package com.alorma.animals.animalslist.ui.viewholder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.alorma.animals.animalslist.presentation.model.AnimalViewModel

class AnimalTypeHeaderViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bind(header: AnimalViewModel.HeaderViewModel) {
        itemView.findViewById<TextView>(android.R.id.text1).text = header.title
    }

    companion object {
        fun build(parent: ViewGroup): AnimalTypeHeaderViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(android.R.layout.simple_list_item_1, parent, false)

            return AnimalTypeHeaderViewHolder(view)
        }
    }

}