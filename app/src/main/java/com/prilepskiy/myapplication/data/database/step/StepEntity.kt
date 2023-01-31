package com.prilepskiy.myapplication.data.database.step

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.prilepskiy.myapplication.core.BaseAdapterTypes
@Entity(tableName = "step_table")
data class StepEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val title:String,
    val description:String,
    val titleTarget:String,
    val status:Boolean=true
)