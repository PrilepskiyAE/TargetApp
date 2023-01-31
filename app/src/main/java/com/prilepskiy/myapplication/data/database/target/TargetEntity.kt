package com.prilepskiy.myapplication.data.database.target

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.prilepskiy.myapplication.core.BaseAdapterTypes
import com.prilepskiy.myapplication.data.database.step.StepEntity
import com.prilepskiy.myapplication.domain.model.TargetModel

@Entity(tableName = "target_table")
data class TargetEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long=0,
    val title:String="",
    val description:String="",
    val revard:String="",
    val date:String="",
    val resId:String="",
    val status:Boolean=true
){
    companion object{
        fun from(data: TargetModel): TargetEntity = with(data) {
            TargetEntity(
                title = title,
                description = description,
                revard = revard,
                date = date,
                resId = resId,
                status = status
            )
        }
    }
}


