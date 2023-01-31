package com.prilepskiy.myapplication.data.repository

import com.prilepskiy.myapplication.data.database.TargetDataBase
import com.prilepskiy.myapplication.domain.model.StepModel
import com.prilepskiy.myapplication.domain.repository.StepRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class StepRepositoryImpl@Inject constructor(private val db: TargetDataBase): StepRepository {
    override suspend fun addStep(data: StepModel) {
        TODO("Not yet implemented")
    }

    override suspend fun updateStep(data: StepModel) {
        TODO("Not yet implemented")
    }

    override suspend fun getAllSteps(): Flow<List<StepModel>> {
        TODO("Not yet implemented")
    }

    override suspend fun getStepFromTarget(titleTarget: String): Flow<List<StepModel>> {
        TODO("Not yet implemented")
    }

    override suspend fun getStepByTitle(title: String): Flow<List<StepModel>> {
        TODO("Not yet implemented")
    }

    override suspend fun getStepById(id: Long): Flow<StepModel> {
        TODO("Not yet implemented")
    }

    override suspend fun deleteStep(title: String) {
        TODO("Not yet implemented")
    }
}