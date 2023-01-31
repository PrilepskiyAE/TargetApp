package com.prilepskiy.myapplication.data.repository

import com.prilepskiy.myapplication.data.database.TargetDataBase
import com.prilepskiy.myapplication.domain.repository.NoteRepository
import javax.inject.Inject

class NoteRepositoryImpl@Inject constructor(db: TargetDataBase): NoteRepository {
}