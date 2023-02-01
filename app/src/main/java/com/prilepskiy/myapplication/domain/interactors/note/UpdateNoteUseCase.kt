package com.prilepskiy.myapplication.domain.interactors.note

import com.prilepskiy.myapplication.domain.model.NoteModel

interface UpdateNoteUseCase {
    suspend operator fun invoke(data: NoteModel)
}