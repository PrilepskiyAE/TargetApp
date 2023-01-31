package com.prilepskiy.myapplication.di

import android.content.Context
import androidx.room.Room
import com.prilepskiy.myapplication.data.database.TargetDataBase
import com.prilepskiy.myapplication.data.repository.NoteRepositoryImpl
import com.prilepskiy.myapplication.data.repository.StepRepositoryImpl
import com.prilepskiy.myapplication.data.repository.TargetRepositoryImpl
import com.prilepskiy.myapplication.domain.repository.NoteRepository
import com.prilepskiy.myapplication.domain.repository.StepRepository
import com.prilepskiy.myapplication.domain.repository.TargetRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(ViewModelComponent::class)
class MessageDBModule {
    @Provides
    fun provideDB(@ApplicationContext context: Context):TargetDataBase = Room.databaseBuilder(context,
        TargetDataBase::class.java,"TargetDB").build()
}
@Module
@InstallIn(ViewModelComponent::class)
class RepositoryModule {
    @Provides
    fun provideNoteRepositoryModule(db: TargetDataBase): NoteRepository = NoteRepositoryImpl(db)

    @Provides
    fun provideStepRepositoryModule(db: TargetDataBase): StepRepository = StepRepositoryImpl(db)

    @Provides
    fun provideTargetRepositoryModule(db: TargetDataBase): TargetRepository = TargetRepositoryImpl(db)
}