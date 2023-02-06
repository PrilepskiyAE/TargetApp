package com.prilepskiy.myapplication.domain.model

import android.os.Parcelable
import com.prilepskiy.myapplication.core.BaseAdapterTypes
import com.prilepskiy.myapplication.data.database.note.NoteEntity
import kotlinx.parcelize.Parcelize

@Parcelize
data class NoteModel (
    override val id: Long=0,
    val title:String="",
    val description:String="",
    val idTarget:Long,
    val resId:String="",
    val date:String=""
): BaseAdapterTypes(), Parcelable {
    companion object{
        fun from(data:NoteEntity):NoteModel= with(data){
            NoteModel(
                id=id,
                title=title,
                description=description,
                resId=resId,
                date=date,
                idTarget=idTarget
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