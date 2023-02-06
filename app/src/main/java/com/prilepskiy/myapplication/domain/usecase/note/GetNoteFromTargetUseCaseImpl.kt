package com.prilepskiy.myapplication.domain.usecase.note

import com.prilepskiy.myapplication.domain.interactors.note.GetNoteFromTargetUseCase
import com.prilepskiy.myapplication.domain.model.NoteModel
import com.prilepskiy.myapplication.domain.repository.NoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetNoteFromTargetUseCaseImpl @Inject constructor(private val repo: NoteRepository) :
    GetNoteFromTargetUseCase {
    override suspend fun invoke(id: Long): Flow<List<NoteModel>> =
        withContext(Dispatchers.IO) {
            return@withContext repo.getNoteFromTarget(id)
        }
}