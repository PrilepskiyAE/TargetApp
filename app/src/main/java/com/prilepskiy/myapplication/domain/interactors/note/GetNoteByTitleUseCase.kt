package com.prilepskiy.myapplication.domain.interactors.note

import com.prilepskiy.myapplication.domain.model.NoteModel
import kotlinx.coroutines.flow.Flow

interface GetNoteByTitleUseCase {
    suspend operator fun invoke(title: String): Flow<List<NoteModel>>
}