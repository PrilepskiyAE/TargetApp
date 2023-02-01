package com.prilepskiy.myapplication.domain.usecase.note

import com.prilepskiy.myapplication.domain.interactors.note.UpdateNoteUseCase
import com.prilepskiy.myapplication.domain.model.NoteModel
import com.prilepskiy.myapplication.domain.repository.NoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UpdateNoteUseCaseImpl @Inject constructor(private val repo: NoteRepository) :
    UpdateNoteUseCase {
    override suspend fun invoke(data: NoteModel) = withContext(Dispatchers.IO) {
        repo.updateNote(data)
    }
}