package com.prilepskiy.myapplication.data.database.note

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.prilepskiy.myapplication.core.BaseAdapterTypes
import com.prilepskiy.myapplication.domain.model.NoteModel

@Entity(tableName = "note_table")
data class NoteEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long=0,
    val title:String="",
    val description:String="",
    val idTarget:Long,
    val resId:String="",
    val date:String=""
){
    companion object{
        fun from(data:NoteModel): NoteEntity = with(data){
            NoteEntity(
                title=title,
                description=description,
                resId=resId,
                date=date ,
                idTarget=idTarget
            )
        }
    }
}