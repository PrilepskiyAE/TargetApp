package com.prilepskiy.myapplication.domain.interactors.target

import com.prilepskiy.myapplication.domain.model.TargetModel
import kotlinx.coroutines.flow.Flow

interface GetTargetByIdUseCase {
    suspend operator fun invoke(id:Long): Flow<TargetModel>
}