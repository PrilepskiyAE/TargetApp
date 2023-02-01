package com.prilepskiy.myapplication.domain.interactors.step

import com.prilepskiy.myapplication.domain.model.StepModel
import kotlinx.coroutines.flow.Flow

interface GetStepByTitleUseCase {
    suspend operator fun invoke(title: String): Flow<List<StepModel>>
}