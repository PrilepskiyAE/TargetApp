package com.prilepskiy.myapplication.data.repository

import com.prilepskiy.myapplication.data.database.TargetDataBase
import com.prilepskiy.myapplication.data.database.target.TargetEntity
import com.prilepskiy.myapplication.domain.model.TargetModel
import com.prilepskiy.myapplication.domain.repository.TargetRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TargetRepositoryImpl@Inject constructor(private val db: TargetDataBase): TargetRepository {
    override suspend fun addStep(data: TargetModel) {

    }

    override suspend fun updateStep(data: TargetModel) {
        TODO("Not yet implemented")
    }

    override suspend fun getAllTargets(): Flow<List<TargetEntity>> {
        TODO("Not yet implemented")
    }

    override suspend fun getTargetByTitle(data: String): Flow<List<TargetEntity>> {
        TODO("Not yet implemented")
    }

    override suspend fun getTargetById(id: Long): Flow<TargetEntity> {
        TODO("Not yet implemented")
    }

    override suspend fun deleteTarget(data: String) {
        TODO("Not yet implemented")
    }
}