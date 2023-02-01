package com.prilepskiy.myapplication.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.prilepskiy.myapplication.databinding.ItemTargetBinding
import com.prilepskiy.myapplication.domain.model.TargetModel
import com.prilepskiy.myapplication.ui.base.BaseAdapter
import com.prilepskiy.myapplication.ui.base.BaseViewHolder

class TargetAdapter( private val click: (TargetModel) -> Unit): BaseAdapter<ViewBinding, TargetModel, BaseViewHolder<TargetModel, ViewBinding>>()
{
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<TargetModel, ViewBinding> {
        return TargetViewHolder(ItemTargetBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    inner class TargetViewHolder(
        private val binding: ItemTargetBinding
    ) : BaseViewHolder<TargetModel, ViewBinding>(binding) {
        override fun bind(item: TargetModel, context: Context) {
            with(binding) {

            }
        }
        override fun onItemClick(item: TargetModel){
            super.onItemClick(item)
            click(item)
        }
    }
}