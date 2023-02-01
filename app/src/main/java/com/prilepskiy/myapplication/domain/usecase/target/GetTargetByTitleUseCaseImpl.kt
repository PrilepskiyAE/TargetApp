package com.prilepskiy.myapplication.domain.usecase.target

import com.prilepskiy.myapplication.domain.interactors.target.GetTargetByTitleUseCase
import com.prilepskiy.myapplication.domain.model.TargetModel
import com.prilepskiy.myapplication.domain.repository.TargetRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetTargetByTitleUseCaseImpl@Inject constructor(private val repo: TargetRepository): GetTargetByTitleUseCase {
    override suspend fun invoke(data: String): Flow<List<TargetModel>> = withContext(Dispatchers.IO) {
        return@withContext repo.getTargetByTitle(data)
    }
}