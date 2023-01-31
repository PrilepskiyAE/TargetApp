package com.prilepskiy.myapplication.data.database.note

import androidx.room.Dao
import com.prilepskiy.myapplication.data.database.BaseDao
import com.prilepskiy.myapplication.data.database.step.StepEntity

@Dao
abstract class NoteDao : BaseDao<StepEntity>(){

}