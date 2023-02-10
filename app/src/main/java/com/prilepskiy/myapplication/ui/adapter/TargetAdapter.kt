package com.prilepskiy.myapplication.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.prilepskiy.myapplication.R
import com.prilepskiy.myapplication.databinding.*
import com.prilepskiy.myapplication.domain.model.TargetModel
import com.prilepskiy.myapplication.ui.base.BaseAdapter
import com.prilepskiy.myapplication.ui.base.BaseViewHolder
import com.prilepskiy.myapplication.ui.base.loadImage

class TargetAdapter(private val click: (TargetModel) -> Unit) :
    BaseAdapter<ViewBinding, TargetModel, BaseViewHolder<TargetModel, ViewBinding>>() {
    override fun getItemViewType(position: Int): Int {
        val item = getItem(position)
        return if (item.status) {
            TargetType.ACTIVE.ordinal
        } else {
            TargetType.PASSIVE.ordinal
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<TargetModel, ViewBinding> {
        val binding = when (viewType) {
            TargetType.ACTIVE.ordinal -> {
                ItemTargetActiveBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            }
            TargetType.PASSIVE.ordinal -> {
                ItemTargetPassiveBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            }
            else -> {
                throw RuntimeException("Unknown view type: $viewType")
            }
        }
        return TargetViewHolder(binding)
    }

    inner class TargetViewHolder(
        private val binding: ViewBinding
    ) : BaseViewHolder<TargetModel, ViewBinding>(binding) {
        override fun bind(item: TargetModel, context: Context) {
            with(binding) {
                when (this) {
                    is ItemTargetActiveBinding -> {
                        tvTitle.text = item.title
                        if (item.date.isNotEmpty())
                        tvDataTime.text = "Выполнить до ${item.date}"
                        if (item.resId.equals("empty") || item.resId.isNullOrEmpty()) {
                            imgLogoMain.setImageResource(R.drawable.baseline_photo_24)
                        } else {
                            loadImage(imgLogoMain, item.resId)
                        }
                    }
                    is ItemTargetPassiveBinding -> {
                        tvTitle.text = item.title
                        if (item.date.isNotEmpty())
                        tvDataTime.text = "Выполнить до ${item.date}" // todo подумать
                        if (item.resId.equals("empty") || item.resId.isNullOrEmpty()) {
                            imgLogoMain.setImageResource(R.drawable.baseline_photo_24)
                        } else {
                            loadImage(imgLogoMain, item.resId)
                        }
                    }


                }
            }
        }

        override fun onItemClick(item: TargetModel) {
            super.onItemClick(item)
            click(item)
        }
    }
    enum class TargetType {
        ACTIVE,
        PASSIVE
    }

}


