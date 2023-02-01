package com.prilepskiy.myapplication.domain.interactors.target

import com.prilepskiy.myapplication.domain.model.TargetModel
import kotlinx.coroutines.flow.Flow

interface GetTargetByTitleUseCase {
    suspend operator fun invoke(data:String): Flow<List<TargetModel>>
}