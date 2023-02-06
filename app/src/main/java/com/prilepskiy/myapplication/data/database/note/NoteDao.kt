package com.prilepskiy.myapplication.data.database.note

import androidx.room.Dao
import androidx.room.Query
import com.prilepskiy.myapplication.data.database.BaseDao
import com.prilepskiy.myapplication.data.database.step.StepEntity
import kotlinx.coroutines.flow.Flow

@Dao
abstract class NoteDao : BaseDao<NoteEntity>(){

    @Query("SELECT * FROM note_table")
    abstract fun getAllNote(): Flow<List<NoteEntity>>

    @Query("SELECT * FROM note_table WHERE idTarget=:id")
    abstract fun getNoteFromTarget(id:Long): Flow<List<NoteEntity>>

    @Query("SELECT * FROM note_table WHERE title=:title")
    abstract  fun getNoteByTitle(title:String): Flow<List<NoteEntity>>
    @Query("SELECT * FROM note_table WHERE id=:id")
    abstract  fun getNoteById(id:Long): Flow<NoteEntity>
    @Query("DELETE FROM note_table WHERE title=:title")
    abstract suspend fun deleteNote(title:String)

}