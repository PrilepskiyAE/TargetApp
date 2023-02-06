package com.prilepskiy.myapplication.domain.model

import android.os.Parcelable
import com.prilepskiy.myapplication.core.BaseAdapterTypes
import com.prilepskiy.myapplication.data.database.note.NoteEntity
import com.prilepskiy.myapplication.data.database.step.StepEntity
import kotlinx.parcelize.Parcelize

@Parcelize
data class StepModel(
    override val id: Long,
    val title: String = "",
    val description: String = "",
    val idTarget:Long,
    val status: Boolean = true
) : BaseAdapterTypes(), Parcelable {
    companion object {
        fun from(data: StepEntity): StepModel = with(data) {
            StepModel(
                id = id,
                title = title,
                description = description,
                status = status,
                idTarget= idTarget
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