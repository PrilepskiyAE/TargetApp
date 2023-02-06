package com.prilepskiy.myapplication.domain.interactors.step

import com.prilepskiy.myapplication.domain.model.StepModel
import kotlinx.coroutines.flow.Flow

interface GetStepFromTargetUseCase {
    suspend operator fun invoke(id:Long): Flow<List<StepModel>>
}