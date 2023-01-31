package com.prilepskiy.myapplication.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.prilepskiy.myapplication.data.database.TargetDataBase.Companion.VERSION_SCHEMA
import com.prilepskiy.myapplication.data.database.note.NoteDao
import com.prilepskiy.myapplication.data.database.note.NoteEntity
import com.prilepskiy.myapplication.data.database.step.StepDao
import com.prilepskiy.myapplication.data.database.step.StepEntity
import com.prilepskiy.myapplication.data.database.target.TargetDao
import com.prilepskiy.myapplication.data.database.target.TargetEntity

@Database(
    entities = [NoteEntity::class, StepEntity::class, TargetEntity::class] ,
    version = VERSION_SCHEMA,
    exportSchema = true
)

abstract class TargetDataBase: RoomDatabase() {
    abstract val noteDao: NoteDao
    abstract val stepDao: StepDao
    abstract val targetDao: TargetDao
    companion object{
        const val VERSION_SCHEMA=1
    }
}