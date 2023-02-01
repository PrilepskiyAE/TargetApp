package com.prilepskiy.myapplication.domain.interactors.target

import com.prilepskiy.myapplication.domain.model.StepModel
import com.prilepskiy.myapplication.domain.model.TargetModel

interface AddTargetUseCase {
    suspend operator fun invoke(data: TargetModel)
}