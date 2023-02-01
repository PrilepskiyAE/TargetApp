package com.prilepskiy.myapplication.domain.interactors.step

import com.prilepskiy.myapplication.domain.model.StepModel
import kotlinx.coroutines.flow.Flow

interface GetStepByIdUseCase {
    suspend operator fun invoke(id:Long): Flow<StepModel>
}