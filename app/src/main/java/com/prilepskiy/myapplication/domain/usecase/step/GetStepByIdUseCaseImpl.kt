package com.prilepskiy.myapplication.domain.usecase.step

import com.prilepskiy.myapplication.domain.interactors.step.GetStepByIdUseCase
import com.prilepskiy.myapplication.domain.model.StepModel
import com.prilepskiy.myapplication.domain.repository.StepRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetStepByIdUseCaseImpl@Inject constructor(private val repo: StepRepository): GetStepByIdUseCase {
    override suspend fun invoke(id: Long): Flow<StepModel> = withContext(Dispatchers.IO) {
        return@withContext repo.getStepById(id)
    }
}