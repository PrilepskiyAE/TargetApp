package com.prilepskiy.myapplication.domain.usecase.step

import com.prilepskiy.myapplication.domain.interactors.step.UpdateStepUseCase
import com.prilepskiy.myapplication.domain.model.StepModel
import com.prilepskiy.myapplication.domain.repository.StepRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UpdateStepUseCaseImpl@Inject constructor(private val repo: StepRepository):
    UpdateStepUseCase {
    override suspend fun invoke(data: StepModel) = withContext(Dispatchers.IO) {
        repo.updateStep(data)
    }
}