package com.prilepskiy.myapplication.domain.model

import com.prilepskiy.myapplication.core.BaseAdapterTypes
import com.prilepskiy.myapplication.data.database.note.NoteEntity
import com.prilepskiy.myapplication.data.database.step.StepEntity

data class StepModel(
    override val id: Long,
    val title: String = "",
    val description: String = "",
    val titleTarget: String = "",
    val status: Boolean = true
) : BaseAdapterTypes() {
    companion object {
        fun from(data: StepEntity): StepModel = with(data) {
            StepModel(
                id = id,
                title = title,
                description = description,
                titleTarget = titleTarget,
                status = status
            )
        }
        fun fromList(list: List<StepEntity>): List<StepModel> {
            val temp: MutableList<StepModel> = mutableListOf()
            list.forEach {
                temp.add(from(it))
            }
            return temp
        }
    }
}