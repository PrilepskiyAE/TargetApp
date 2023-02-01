package com.prilepskiy.myapplication.domain.interactors.step

import com.prilepskiy.myapplication.domain.model.NoteModel
import com.prilepskiy.myapplication.domain.model.StepModel

interface AddStepUseCase {
    suspend operator fun invoke(data: StepModel)
}