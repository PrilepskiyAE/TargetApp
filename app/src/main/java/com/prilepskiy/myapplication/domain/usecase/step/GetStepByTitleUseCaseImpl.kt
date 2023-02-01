package com.prilepskiy.myapplication.domain.usecase.step

import com.prilepskiy.myapplication.domain.interactors.step.GetStepByTitleUseCase
import com.prilepskiy.myapplication.domain.model.StepModel
import com.prilepskiy.myapplication.domain.repository.StepRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetStepByTitleUseCaseImpl@Inject constructor(private val repo: StepRepository): GetStepByTitleUseCase {
    override suspend fun invoke(title: String): Flow<List<StepModel>> = withContext(Dispatchers.IO) {
        return@withContext repo.getStepByTitle(title)
    }
}