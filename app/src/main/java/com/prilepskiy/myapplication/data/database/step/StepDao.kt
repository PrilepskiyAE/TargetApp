package com.prilepskiy.myapplication.data.database.step

import androidx.room.Dao
import androidx.room.Query
import com.prilepskiy.myapplication.data.database.BaseDao
import com.prilepskiy.myapplication.data.database.target.TargetEntity
import kotlinx.coroutines.flow.Flow

@Dao
abstract class StepDao: BaseDao<StepEntity>() {

    @Query("SELECT * FROM step_table")
    abstract fun getAllSteps(): Flow<List<StepEntity>>

    @Query("SELECT * FROM step_table WHERE titleTarget=:titleTarget")
    abstract fun getStepFromTarget(titleTarget:String): Flow<List<StepEntity>>

    @Query("SELECT * FROM step_table WHERE title=:title")
    abstract fun getStep(title:String): Flow<List<StepEntity>>

    @Query("DELETE FROM step_table WHERE title=:title")
    abstract suspend fun deleteStep(title:String)

}