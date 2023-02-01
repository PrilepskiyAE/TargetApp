package com.prilepskiy.myapplication.domain.interactors.note

import com.prilepskiy.myapplication.domain.model.NoteModel

interface AddNoteUseCase {
    suspend operator fun invoke(data:NoteModel)
}