package com.prilepskiy.myapplication.domain.usecase.step

import com.prilepskiy.myapplication.domain.interactors.step.GetStepFromTargetUseCase
import com.prilepskiy.myapplication.domain.model.StepModel
import com.prilepskiy.myapplication.domain.repository.StepRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetStepFromTargetUseCaseImpl@Inject constructor(private val repo: StepRepository): GetStepFromTargetUseCase {
    override suspend fun invoke(id:Long): Flow<List<StepModel>> = withContext(Dispatchers.IO) {
        return@withContext repo.getStepFromTarget(id)
    }
}