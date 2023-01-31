package com.prilepskiy.myapplication.domain.repository

import androidx.room.Query
import com.prilepskiy.myapplication.data.database.target.TargetEntity
import com.prilepskiy.myapplication.domain.model.StepModel
import com.prilepskiy.myapplication.domain.model.TargetModel
import kotlinx.coroutines.flow.Flow

interface TargetRepository {
    suspend fun addStep(data: TargetModel)
    suspend fun updateStep(data: TargetModel)
    suspend fun getAllTargets():Flow<List<TargetModel>>
    suspend fun getTargetByTitle(data:String): Flow<List<TargetModel>>
    suspend fun getTargetById(id:Long): Flow<TargetModel>
    suspend fun deleteTarget(data:String)
}