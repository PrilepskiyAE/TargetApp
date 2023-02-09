package com.prilepskiy.myapplication.ui.base

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.viewbinding.ViewBinding
import com.prilepskiy.myapplication.core.DiffUtilModel

abstract class BaseAdapter<ItemViewBinding : ViewBinding, Item : DiffUtilModel<*>, ViewHolder : BaseViewHolder<Item, ItemViewBinding>> :
    ListAdapter<Item, ViewHolder>(EventsDiffCallback()) {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            getItem(position)?.let { item ->
                bind(item, itemView.context)
                itemView.setOnClickListener {
                    if (position <= itemCount - 1)
                        onItemClick(item)
                }
                itemView.setOnLongClickListener {
                    onItemLongClick(item)
                    true
                }
            }
        }
    }

    class EventsDiffCallback<Item : DiffUtilModel<*>> : DiffUtil.ItemCallback<Item>() {
        override fun areItemsTheSame(oldItem: Item, newItem: Item) =
            (oldItem as DiffUtilModel<*>).id == (newItem as DiffUtilModel<*>).id

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean =
            oldItem == newItem
    }

}