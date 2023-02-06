package com.prilepskiy.myapplication.data.repository

import com.prilepskiy.myapplication.data.database.TargetDataBase
import com.prilepskiy.myapplication.data.database.step.StepEntity
import com.prilepskiy.myapplication.domain.model.StepModel
import com.prilepskiy.myapplication.domain.repository.StepRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class StepRepositoryImpl@Inject constructor(private val db: TargetDataBase): StepRepository {
    override suspend fun addStep(data: StepModel) {
        db.stepDao.insert(StepEntity.from(data))
    }

    override suspend fun updateStep(data: StepModel) {
        db.stepDao.update(StepEntity.from(data))
    }

    override suspend fun getAllSteps(): Flow<List<StepModel>> {
        return  db.stepDao.getAllSteps().map {
            StepModel.fromList(it)
        }
    }

    override suspend fun getStepFromTarget(id: Long): Flow<List<StepModel>> {
        return db.stepDao.getStepFromTarget(id).map {
            StepModel.fromList(it)
        }
    }

    override suspend fun getStepByTitle(title: String): Flow<List<StepModel>> {
        return db.stepDao.getStepByTitle(title).map {
            StepModel.fromList(it)
        }
    }

    override suspend fun getStepById(id: Long): Flow<StepModel> {
        return db.stepDao.getStepById(id).map {
            StepModel.from(it)
        }
    }

    override suspend fun deleteStep(title: String) {
        db.stepDao.deleteStep(title)
    }
}