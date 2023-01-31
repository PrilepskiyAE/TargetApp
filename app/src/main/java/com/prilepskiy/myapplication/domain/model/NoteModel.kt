package com.prilepskiy.myapplication.domain.model

import com.prilepskiy.myapplication.core.BaseAdapterTypes
import com.prilepskiy.myapplication.data.database.note.NoteEntity

data class NoteModel (
    override val id: Long,
    val title:String="",
    val description:String="",
    val titleTarget:String="",
    val resId:String="",
    val date:String=""
): BaseAdapterTypes(){
    companion object{
        fun from(data:NoteEntity):NoteModel= with(data){
            NoteModel(
                id=id,
                title=title,
                description=description,
                titleTarget=titleTarget,
                resId=resId,
                date=date
            )
        }
        fun fromList(list: List<NoteEntity>):List<NoteModel>{
            val temp:MutableList<NoteModel> = mutableListOf()
            list.forEach {
                temp.add(from(it))
            }
           return temp
        }
    }}