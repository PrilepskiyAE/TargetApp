package com.prilepskiy.myapplication.domain.usecase.note

import com.prilepskiy.myapplication.domain.interactors.note.GetAllNoteUseCase
import com.prilepskiy.myapplication.domain.model.NoteModel
import com.prilepskiy.myapplication.domain.repository.NoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetAllNoteUseCaseImpl@Inject constructor(private val repo: NoteRepository): GetAllNoteUseCase {
    override suspend fun invoke(): Flow<List<NoteModel>>  = withContext(Dispatchers.IO){
        return@withContext repo.getAllNote()
    }
}