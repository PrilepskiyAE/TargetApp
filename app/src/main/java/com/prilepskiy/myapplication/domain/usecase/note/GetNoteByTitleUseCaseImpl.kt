package com.prilepskiy.myapplication.domain.usecase.note

import com.prilepskiy.myapplication.domain.interactors.note.GetNoteByTitleUseCase
import com.prilepskiy.myapplication.domain.model.NoteModel
import com.prilepskiy.myapplication.domain.repository.NoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetNoteByTitleUseCaseImpl @Inject constructor(private val repo: NoteRepository) :
    GetNoteByTitleUseCase {
    override suspend fun invoke(title: String): Flow<List<NoteModel>> =
        withContext(Dispatchers.IO) {
            return@withContext repo.getNoteByTitle(title)
        }
}