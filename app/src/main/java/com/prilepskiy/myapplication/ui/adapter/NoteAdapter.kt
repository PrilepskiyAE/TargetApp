package com.prilepskiy.myapplication.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.prilepskiy.myapplication.databinding.ItemNoteBinding
import com.prilepskiy.myapplication.databinding.ItemStepBinding
import com.prilepskiy.myapplication.domain.model.NoteModel
import com.prilepskiy.myapplication.domain.model.StepModel
import com.prilepskiy.myapplication.ui.base.BaseAdapter
import com.prilepskiy.myapplication.ui.base.BaseViewHolder


class NoteAdapter( private val click: (NoteModel) -> Unit): BaseAdapter<ViewBinding, NoteModel, BaseViewHolder<NoteModel, ViewBinding>>()
{
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<NoteModel, ViewBinding> {
        return NoteViewHolder(ItemNoteBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }
    inner class NoteViewHolder(
        private val binding: ItemNoteBinding
    ) : BaseViewHolder<NoteModel, ViewBinding>(binding) {
        override fun bind(item: NoteModel, context: Context) {
            with(binding) {

            }
        }
        override fun onItemClick(item: NoteModel){
            super.onItemClick(item)
            click(item)
        }
    }
}