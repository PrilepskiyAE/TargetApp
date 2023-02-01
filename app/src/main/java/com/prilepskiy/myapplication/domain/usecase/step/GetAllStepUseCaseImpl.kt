package com.prilepskiy.myapplication.domain.usecase.step

import com.prilepskiy.myapplication.domain.interactors.step.GetAllStepUseCase
import com.prilepskiy.myapplication.domain.model.StepModel
import com.prilepskiy.myapplication.domain.repository.StepRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetAllStepUseCaseImpl@Inject constructor(private val repo: StepRepository): GetAllStepUseCase {
    override suspend fun invoke(): Flow<List<StepModel>> = withContext(Dispatchers.IO) {
        return@withContext repo.getAllSteps()
    }
}