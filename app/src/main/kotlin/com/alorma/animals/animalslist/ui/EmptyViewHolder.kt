package com.alorma.animals.animalslist.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class EmptyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    companion object {
        fun build(parent: ViewGroup): EmptyViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(android.R.layout.simple_list_item_1, parent, false)

            return EmptyViewHolder(view)
        }
    }

}