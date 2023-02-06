package com.prilepskiy.myapplication.domain.repository

import androidx.room.Query
import com.prilepskiy.myapplication.data.database.note.NoteEntity
import com.prilepskiy.myapplication.domain.model.NoteModel
import kotlinx.coroutines.flow.Flow

interface NoteRepository {

    suspend fun addNote(data:NoteModel)
    suspend fun updateNote(data:NoteModel)
    suspend fun getAllNote(): Flow<List<NoteModel>>
    suspend fun getNoteFromTarget(id:Long): Flow<List<NoteModel>>
    suspend fun getNoteByTitle(title:String): Flow<List<NoteModel>>
    suspend fun getNoteById(id:Long): Flow<NoteModel>
    suspend fun deleteNote(title:String)

    suspend fun inT()
}