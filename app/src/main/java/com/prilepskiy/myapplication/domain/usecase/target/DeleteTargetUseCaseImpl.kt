package com.prilepskiy.myapplication.domain.usecase.target

import com.prilepskiy.myapplication.domain.interactors.target.DeleteTargetUseCase
import com.prilepskiy.myapplication.domain.model.TargetModel
import com.prilepskiy.myapplication.domain.repository.TargetRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DeleteTargetUseCaseImpl@Inject constructor(private val repo: TargetRepository): DeleteTargetUseCase {
    override suspend fun invoke(data: TargetModel) = withContext(Dispatchers.IO) {
        repo.deleteTarget(data.title)
    }
}