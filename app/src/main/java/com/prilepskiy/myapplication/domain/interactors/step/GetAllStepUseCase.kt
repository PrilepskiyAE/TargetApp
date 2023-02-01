package com.prilepskiy.myapplication.domain.interactors.step

import com.prilepskiy.myapplication.domain.model.StepModel
import com.prilepskiy.myapplication.domain.model.TargetModel
import kotlinx.coroutines.flow.Flow

interface GetAllStepUseCase {
    suspend operator fun invoke(): Flow<List<StepModel>>
}