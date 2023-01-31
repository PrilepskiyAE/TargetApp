package com.prilepskiy.myapplication.data.database.note

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.prilepskiy.myapplication.core.BaseAdapterTypes
@Entity(tableName = "note_table")
data class NoteEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val title:String,
    val description:String,
    val titleTarget:String,
    val resId:String,
    val data:String
)