package com.prilepskiy.myapplication.domain.usecase.step

import com.prilepskiy.myapplication.domain.interactors.step.DeleteStepUseCase
import com.prilepskiy.myapplication.domain.model.StepModel
import com.prilepskiy.myapplication.domain.repository.StepRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DeleteStepUseCaseImpl@Inject constructor(private val repo: StepRepository): DeleteStepUseCase {
    override suspend fun invoke(data: StepModel) = withContext(Dispatchers.IO) {
        repo.deleteStep(data.title)
    }
}