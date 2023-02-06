package com.prilepskiy.myapplication.domain.repository

import androidx.room.Query
import com.prilepskiy.myapplication.data.database.step.StepEntity
import com.prilepskiy.myapplication.domain.model.NoteModel
import com.prilepskiy.myapplication.domain.model.StepModel
import kotlinx.coroutines.flow.Flow

interface StepRepository {

    suspend fun addStep(data: StepModel)
    suspend fun updateStep(data: StepModel)

   suspend fun getAllSteps(): Flow<List<StepModel>>

   suspend fun getStepFromTarget(id: Long): Flow<List<StepModel>>

   suspend fun getStepByTitle(title:String): Flow<List<StepModel>>
    suspend fun getStepById(id:Long): Flow<StepModel>
    suspend fun deleteStep(title:String)

}