package com.prilepskiy.myapplication.domain.usecase.note

import com.prilepskiy.myapplication.domain.interactors.note.DeleteNoteUseCase
import com.prilepskiy.myapplication.domain.model.NoteModel
import com.prilepskiy.myapplication.domain.repository.NoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DeleteNoteUseCaseImpl @Inject constructor(private val repo: NoteRepository) :
    DeleteNoteUseCase {
    override suspend fun invoke(data: NoteModel) = withContext(Dispatchers.IO) {
        repo.deleteNote(data.title)
    }
}