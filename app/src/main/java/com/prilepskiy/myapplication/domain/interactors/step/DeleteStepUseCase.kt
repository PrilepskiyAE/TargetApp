package com.prilepskiy.myapplication.domain.interactors.step

import com.prilepskiy.myapplication.domain.model.StepModel

interface DeleteStepUseCase {
    suspend operator fun invoke(data: StepModel)
}