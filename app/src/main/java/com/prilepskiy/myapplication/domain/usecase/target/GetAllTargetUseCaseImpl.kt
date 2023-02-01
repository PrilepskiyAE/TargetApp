package com.prilepskiy.myapplication.domain.usecase.target

import com.prilepskiy.myapplication.domain.interactors.target.GetAllTargetUseCase
import com.prilepskiy.myapplication.domain.model.TargetModel
import com.prilepskiy.myapplication.domain.repository.TargetRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetAllTargetUseCaseImpl@Inject constructor(private val repo: TargetRepository): GetAllTargetUseCase {
    override suspend fun invoke(): Flow<List<TargetModel>> = withContext(Dispatchers.IO) {
        return@withContext repo.getAllTargets()
    }
}