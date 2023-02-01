package com.prilepskiy.myapplication.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.prilepskiy.myapplication.databinding.ItemStepBinding
import com.prilepskiy.myapplication.domain.model.StepModel
import com.prilepskiy.myapplication.ui.base.BaseAdapter
import com.prilepskiy.myapplication.ui.base.BaseViewHolder

class StepAdapter( private val click: (StepModel) -> Unit): BaseAdapter<ViewBinding, StepModel, BaseViewHolder<StepModel, ViewBinding>>()
{
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<StepModel, ViewBinding> {
        return StepViewHolder(ItemStepBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    inner class StepViewHolder(
        private val binding: ItemStepBinding
    ) : BaseViewHolder<StepModel, ViewBinding>(binding) {
        override fun bind(item: StepModel, context: Context) {
            with(binding) {

            }
        }
        override fun onItemClick(item: StepModel){
            super.onItemClick(item)
            click(item)
        }
    }
}