package com.prilepskiy.myapplication.domain.model

import android.os.Parcelable
import com.prilepskiy.myapplication.core.BaseAdapterTypes
import com.prilepskiy.myapplication.data.database.target.TargetEntity
import kotlinx.parcelize.Parcelize

@Parcelize
data class TargetModel(
    override val id: Long=0,
    val title: String = "",
    val description: String = "",
    val revard: String = "",
    val date: String = "",
    val resId: String = "",
    val status: Boolean = true
) : BaseAdapterTypes() , Parcelable {
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
