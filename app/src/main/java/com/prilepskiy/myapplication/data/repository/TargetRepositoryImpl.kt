package com.prilepskiy.myapplication.data.repository

import com.prilepskiy.myapplication.data.database.TargetDataBase
import com.prilepskiy.myapplication.domain.repository.TargetRepository
import javax.inject.Inject

class TargetRepositoryImpl@Inject constructor(db: TargetDataBase): TargetRepository {
}