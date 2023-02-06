package com.prilepskiy.myapplication.data.database.step

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.prilepskiy.myapplication.core.BaseAdapterTypes
import com.prilepskiy.myapplication.domain.model.StepModel

@Entity(tableName = "step_table")
data class StepEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long=0,
    val title:String="",
    val description:String="",
    val idTarget:Long,
    val status:Boolean=true
){
    companion object{
        fun from(data:StepModel): StepEntity = with(data){
            StepEntity(
                title=title,
                description=description,
                status = status,
                idTarget=idTarget
            )
        }
    }}