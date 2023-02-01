package com.prilepskiy.myapplication.domain.interactors.target

import com.prilepskiy.myapplication.domain.model.TargetModel
import kotlinx.coroutines.flow.Flow

interface GetAllTargetUseCase {
    suspend operator fun invoke(): Flow<List<TargetModel>>
}