package com.prilepskiy.myapplication.data.database.target

import androidx.room.Dao
import androidx.room.Query
import com.prilepskiy.myapplication.data.database.BaseDao
import kotlinx.coroutines.flow.Flow

@Dao
abstract class TargetDao:BaseDao<TargetEntity>() {

    @Query("SELECT * FROM target_table")
    abstract fun getAllTargets(): Flow<List<TargetEntity>>
    @Query("SELECT * FROM target_table WHERE title=:data")
    abstract fun getTargetByTitle(data:String): Flow<List<TargetEntity>>

    @Query("SELECT * FROM target_table WHERE id=:id")
    abstract fun getTargetById(id:Long): Flow<TargetEntity>

    @Query("DELETE FROM target_table WHERE title=:data")
    abstract suspend fun deleteTarget(data:String)
}