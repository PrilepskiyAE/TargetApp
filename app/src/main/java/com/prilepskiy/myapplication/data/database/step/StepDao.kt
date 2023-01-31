package com.prilepskiy.myapplication.data.database.step

import androidx.room.Dao
import com.prilepskiy.myapplication.data.database.BaseDao
import com.prilepskiy.myapplication.data.database.target.TargetEntity
@Dao
abstract class StepDao: BaseDao<StepEntity>() {
}