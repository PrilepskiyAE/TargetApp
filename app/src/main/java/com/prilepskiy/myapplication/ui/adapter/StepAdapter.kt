package com.prilepskiy.myapplication.ui.adapter

import android.content.Context

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.prilepskiy.myapplication.databinding.ItemStepActiveBinding

import com.prilepskiy.myapplication.databinding.ItemStepPasiveBinding
import com.prilepskiy.myapplication.domain.model.StepModel
import com.prilepskiy.myapplication.ui.base.BaseAdapter
import com.prilepskiy.myapplication.ui.base.BaseViewHolder

class StepAdapter(
    private val click: (StepModel) -> Unit,
    private val clickLong: (StepModel) -> Unit
) : BaseAdapter<ViewBinding, StepModel, BaseViewHolder<StepModel, ViewBinding>>() {
    override fun getItemViewType(position: Int): Int {
        val item = getItem(position)
        return if (item.status) {
            StepType.ACTIVE.ordinal
        } else {
            StepType.PASSIVE.ordinal
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<StepModel, ViewBinding> {
        val binding = when (viewType) {
            StepType.ACTIVE.ordinal -> {
                ItemStepActiveBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            }
            StepType.PASSIVE.ordinal -> {
                ItemStepPasiveBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            }
            else -> {
                throw RuntimeException("Unknown view type: $viewType")
            }
        }

        return StepViewHolder(binding)
    }

    inner class StepViewHolder(
        private val binding: ViewBinding
    ) : BaseViewHolder<StepModel, ViewBinding>(binding) {
        override fun bind(item: StepModel, context: Context) {

            with(binding) {
                when (this) {
                    is ItemStepActiveBinding -> {

                       textView2.text = item.title
                       textView3.text = item.description
                    }
                    is ItemStepPasiveBinding -> {
                        textView2.text = item.title
                        textView3.text = item.description
                    }
                }
            }
        }

        override fun onItemClick(item: StepModel) {
            super.onItemClick(item)
            click(item)
        }

        override fun onItemLongClick(item: StepModel) {
            super.onItemLongClick(item)
            clickLong(item)
        }
    }

    enum class StepType {
        ACTIVE,
        PASSIVE
    }
}