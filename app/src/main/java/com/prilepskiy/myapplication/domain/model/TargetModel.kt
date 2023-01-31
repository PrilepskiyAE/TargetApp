package com.prilepskiy.myapplication.domain.model

import com.prilepskiy.myapplication.core.BaseAdapterTypes
import com.prilepskiy.myapplication.data.database.step.StepEntity
import com.prilepskiy.myapplication.data.database.target.TargetEntity

data class TargetModel(
    override val id: Long,
    val title: String = "",
    val description: String = "",
    val revard: String = "",
    val date: String = "",
    val resId: String = "",
    val status: Boolean = true
) : BaseAdapterTypes() {
    companion object {
        fun from(data: TargetEntity): TargetModel = with(data) {
            TargetModel(
                id = id,
                title = title,
                description = description,
                revard = revard,
                date = date,
                resId = resId,
                status = status
            )
        }
        fun fromList(list: List<TargetEntity>): List<TargetModel> {
            val temp: MutableList<TargetModel> = mutableListOf()
            list.forEach {
                temp.add(from(it))
            }
            return temp
        }
    }
}
