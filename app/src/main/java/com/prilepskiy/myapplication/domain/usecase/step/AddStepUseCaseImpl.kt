package com.prilepskiy.myapplication.domain.usecase.step

import com.prilepskiy.myapplication.domain.interactors.step.AddStepUseCase
import com.prilepskiy.myapplication.domain.model.StepModel
import com.prilepskiy.myapplication.domain.repository.NoteRepository
import com.prilepskiy.myapplication.domain.repository.StepRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AddStepUseCaseImpl@Inject constructor(private val repo: StepRepository): AddStepUseCase {
    override suspend fun invoke(data: StepModel) = withContext(Dispatchers.IO) {
        repo.addStep(data)
    }
}