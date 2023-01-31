package com.prilepskiy.myapplication.data.database.target

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.prilepskiy.myapplication.core.BaseAdapterTypes
import com.prilepskiy.myapplication.data.database.step.StepEntity

@Entity(tableName = "target_table")
data class TargetEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val title:String="",
    val description:String="",
    val revard:String="",
    val data:String="",
    val resId:String="",
    val status:Boolean=true
)


