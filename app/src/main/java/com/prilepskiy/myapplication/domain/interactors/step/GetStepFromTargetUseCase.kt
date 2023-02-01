package com.prilepskiy.myapplication.domain.interactors.step

import com.prilepskiy.myapplication.domain.model.StepModel
import kotlinx.coroutines.flow.Flow

interface GetStepFromTargetUseCase {
    suspend operator fun invoke(titleTarget:String): Flow<List<StepModel>>
}