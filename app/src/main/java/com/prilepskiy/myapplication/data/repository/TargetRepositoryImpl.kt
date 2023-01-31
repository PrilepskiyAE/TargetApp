package com.prilepskiy.myapplication.data.repository

import com.prilepskiy.myapplication.data.database.TargetDataBase
import com.prilepskiy.myapplication.data.database.target.TargetEntity
import com.prilepskiy.myapplication.domain.model.TargetModel
import com.prilepskiy.myapplication.domain.repository.TargetRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TargetRepositoryImpl@Inject constructor(private val db: TargetDataBase): TargetRepository {
    override suspend fun addStep(data: TargetModel) {
        db.targetDao.insert(TargetEntity.from(data))
    }

    override suspend fun updateStep(data: TargetModel) {
        db.targetDao.update(TargetEntity.from(data))
    }

    override suspend fun getAllTargets(): Flow<List<TargetModel>> {
        return db.targetDao.getAllTargets().map {
            TargetModel.fromList(it)
        }
    }

    override suspend fun getTargetByTitle(data: String): Flow<List<TargetModel>> {
        return db.targetDao.getTargetByTitle(data).map {
            TargetModel.fromList(it)
        }
    }

    override suspend fun getTargetById(id: Long): Flow<TargetModel> {
        return db.targetDao.getTargetById(id).map {
            TargetModel.from(it)
        }
    }

    override suspend fun deleteTarget(data: String) {
        db.targetDao.deleteTarget(data)
    }
}