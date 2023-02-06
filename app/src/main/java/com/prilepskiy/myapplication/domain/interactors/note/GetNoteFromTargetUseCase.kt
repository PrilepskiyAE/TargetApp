package com.prilepskiy.myapplication.domain.interactors.note

import com.prilepskiy.myapplication.domain.model.NoteModel
import kotlinx.coroutines.flow.Flow

interface GetNoteFromTargetUseCase {
    suspend operator fun invoke(id:Long): Flow<List<NoteModel>>
}