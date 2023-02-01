package com.prilepskiy.myapplication.domain.usecase.note

import com.prilepskiy.myapplication.domain.interactors.note.GetNoteByIdUseCase
import com.prilepskiy.myapplication.domain.model.NoteModel
import com.prilepskiy.myapplication.domain.repository.NoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetNoteByIdUseCaseImpl @Inject constructor(private val repo: NoteRepository) :
    GetNoteByIdUseCase {
    override suspend fun invoke(id: Long): Flow<NoteModel> = withContext(Dispatchers.IO) {
        return@withContext repo.getNoteById(id)
    }
}