package com.prilepskiy.myapplication.data.repository

import com.prilepskiy.myapplication.data.database.TargetDataBase
import com.prilepskiy.myapplication.data.database.note.NoteEntity
import com.prilepskiy.myapplication.domain.model.NoteModel
import com.prilepskiy.myapplication.domain.repository.NoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.withContext
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(private val db: TargetDataBase) : NoteRepository {
    override suspend fun addNote(data: NoteModel) {
        db.noteDao.insert(NoteEntity.from(data))
    }

    override suspend fun updateNote(data: NoteModel) {
        db.noteDao.update(NoteEntity.from(data))
    }

    override suspend fun getAllNote(): Flow<List<NoteModel>> {
        return db.noteDao.getAllNote().map {
                NoteModel.fromList(it)
            }

        }



    override suspend fun getNoteFromTarget(id: Long): Flow<List<NoteModel>> {
        return db.noteDao.getNoteFromTarget(id).map {
                NoteModel.fromList(it)
            }
        }


    override suspend fun getNoteByTitle(title: String): Flow<List<NoteModel>> {
        return db.noteDao.getNoteByTitle(title).map {
            NoteModel.fromList(it)
        }
    }


    override suspend fun getNoteById(id: Long): Flow<NoteModel> {
       return db.noteDao.getNoteById(id).map {
           NoteModel.from(it)
       }
    }

    override suspend fun deleteNote(title: String) {
        db.noteDao.deleteNote(title)
    }
    override suspend fun inT() {
        withContext(Dispatchers.IO) {
//            db.noteDao.insert(NoteEntity(title = "test"))
//            db.noteDao.insert(NoteEntity(title = "test2"))
//            db.noteDao.insert(NoteEntity(title = "test3"))
//            db.noteDao.insert(NoteEntity(title = "test4"))
//            db.noteDao.insert(NoteEntity(title = "test5"))
//            db.noteDao.insert(NoteEntity(title = "test6"))
//            db.noteDao.insert(NoteEntity(title = "test7"))
//            db.noteDao.insert(NoteEntity(title = "test8"))
//            db.noteDao.insert(NoteEntity(title = "test9"))
//            db.noteDao.insert(NoteEntity(title = "test10"))
        }
    }
}