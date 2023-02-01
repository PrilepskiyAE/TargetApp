package com.prilepskiy.myapplication.domain.interactors.note

import com.prilepskiy.myapplication.domain.model.NoteModel
import com.prilepskiy.myapplication.domain.model.TargetModel
import kotlinx.coroutines.flow.Flow

interface GetAllNoteUseCase {
    suspend operator fun invoke(): Flow<List<NoteModel>>
}