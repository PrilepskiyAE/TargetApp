package com.prilepskiy.myapplication.domain.interactors.target

import com.prilepskiy.myapplication.domain.model.TargetModel

interface UpdateTargetUseCase {
    suspend operator fun invoke(data: TargetModel)
}