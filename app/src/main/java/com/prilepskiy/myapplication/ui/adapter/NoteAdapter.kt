package com.prilepskiy.myapplication.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.prilepskiy.myapplication.R
import com.prilepskiy.myapplication.databinding.ItemNoteBinding

import com.prilepskiy.myapplication.domain.model.NoteModel

import com.prilepskiy.myapplication.ui.base.BaseAdapter
import com.prilepskiy.myapplication.ui.base.BaseViewHolder
import com.prilepskiy.myapplication.ui.base.loadImage


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
            textView2.text=item.title
                textView3.text=item.date
                if (item.resId.equals("empty") || item.resId.isNullOrEmpty()){
                    imageView5.setImageResource(R.drawable.baseline_photo_24)
                }else{
                    loadImage(imageView5, item.resId)
                }
            }
        }
        override fun onItemClick(item: NoteModel){
            super.onItemClick(item)
            click(item)
        }
    }
}