package com.alorma.animals.animalslist.ui

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.alorma.animals.animalslist.presentation.model.AnimalViewModel
import com.alorma.animals.animalslist.ui.viewholder.AnimalItemViewHolder
import com.alorma.animals.animalslist.ui.viewholder.AnimalTypeHeaderViewHolder

class AnimalsAdapter : ListAdapter<AnimalViewModel, RecyclerView.ViewHolder>(DIFF) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType) {
            TYPE_HEADER -> AnimalTypeHeaderViewHolder.build(parent)
            TYPE_ITEM -> AnimalItemViewHolder.build(parent)
            else -> EmptyViewHolder.build(parent)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is AnimalTypeHeaderViewHolder -> holder.bind(getItem(position) as AnimalViewModel.HeaderViewModel)
            is AnimalItemViewHolder -> holder.bind(getItem(position) as AnimalViewModel.AnimalItemViewModel)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when(getItem(position)) {
            is AnimalViewModel.HeaderViewModel -> TYPE_HEADER
            is AnimalViewModel.AnimalItemViewModel -> TYPE_ITEM
        }
    }

    companion object {
        private val DIFF = object : DiffUtil.ItemCallback<AnimalViewModel>() {
            override fun areItemsTheSame(oldItem: AnimalViewModel, newItem: AnimalViewModel): Boolean =
                oldItem == newItem

            override fun areContentsTheSame(oldItem: AnimalViewModel, newItem: AnimalViewModel): Boolean =
                if (oldItem is AnimalViewModel.HeaderViewModel && newItem is AnimalViewModel.HeaderViewModel) {
                    oldItem.title == newItem.title
                } else if (oldItem is AnimalViewModel.AnimalItemViewModel && newItem is AnimalViewModel.AnimalItemViewModel) {
                    oldItem.id == newItem.id && oldItem.name == newItem.name && oldItem.createdDate == newItem.createdDate
                } else {
                    false
                }
        }
        private const val TYPE_HEADER = 1
        private const val TYPE_ITEM = 2
    }

}