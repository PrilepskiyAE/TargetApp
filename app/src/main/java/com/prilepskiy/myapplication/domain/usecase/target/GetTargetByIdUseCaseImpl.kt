package com.prilepskiy.myapplication.domain.usecase.target

import com.prilepskiy.myapplication.domain.interactors.target.GetTargetByIdUseCase
import com.prilepskiy.myapplication.domain.model.TargetModel
import com.prilepskiy.myapplication.domain.repository.TargetRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetTargetByIdUseCaseImpl@Inject constructor(private val repo: TargetRepository): GetTargetByIdUseCase {
    override suspend fun invoke(id: Long): Flow<TargetModel> = withContext(Dispatchers.IO) {
        return@withContext repo.getTargetById(id)
    }
}