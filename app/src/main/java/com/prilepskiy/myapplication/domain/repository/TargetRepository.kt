package com.prilepskiy.myapplication.domain.repository

import androidx.room.Query
import com.prilepskiy.myapplication.data.database.target.TargetEntity
import com.prilepskiy.myapplication.domain.model.StepModel
import com.prilepskiy.myapplication.domain.model.TargetModel
import kotlinx.coroutines.flow.Flow

interface TargetRepository {
    suspend fun addStep(data: TargetModel)
    suspend fun updateStep(data: TargetModel)
    suspend fun getAllTargets():Flow<List<TargetEntity>>
    suspend fun getTargetByTitle(data:String): Flow<List<TargetEntity>>
    suspend fun getTargetById(id:Long): Flow<TargetEntity>
    suspend fun deleteTarget(data:String)
}