package com.prilepskiy.myapplication.di

import android.content.Context
import androidx.room.Room
import com.prilepskiy.myapplication.data.database.TargetDataBase
import com.prilepskiy.myapplication.data.repository.NoteRepositoryImpl
import com.prilepskiy.myapplication.data.repository.StepRepositoryImpl
import com.prilepskiy.myapplication.data.repository.TargetRepositoryImpl
import com.prilepskiy.myapplication.domain.interactors.note.*
import com.prilepskiy.myapplication.domain.interactors.step.*
import com.prilepskiy.myapplication.domain.interactors.target.*
import com.prilepskiy.myapplication.domain.repository.NoteRepository
import com.prilepskiy.myapplication.domain.repository.StepRepository
import com.prilepskiy.myapplication.domain.repository.TargetRepository
import com.prilepskiy.myapplication.domain.usecase.note.*
import com.prilepskiy.myapplication.domain.usecase.step.*
import com.prilepskiy.myapplication.domain.usecase.target.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(ViewModelComponent::class)
class MessageDBModule {
    @Provides
    fun provideDB(@ApplicationContext context: Context): TargetDataBase = Room.databaseBuilder(
        context,
        TargetDataBase::class.java, "TargetDB"
    ).build()
}

@Module
@InstallIn(ViewModelComponent::class)
class RepositoryModule {
    @Provides
    fun provideNoteRepositoryModule(db: TargetDataBase): NoteRepository = NoteRepositoryImpl(db)

    @Provides
    fun provideStepRepositoryModule(db: TargetDataBase): StepRepository = StepRepositoryImpl(db)

    @Provides
    fun provideTargetRepositoryModule(db: TargetDataBase): TargetRepository =
        TargetRepositoryImpl(db)
}

@Module
@InstallIn(ViewModelComponent::class)
class NoteUseCaseModule {
    @Provides
    fun provideAddNoteUseCaseModule(repo: NoteRepository): AddNoteUseCase = AddNoteUseCaseImpl(repo)

    @Provides
    fun provideDeleteNoteUseCaseModule(repo: NoteRepository): DeleteNoteUseCase =
        DeleteNoteUseCaseImpl(repo)

    @Provides
    fun provideGetAllNoteUseCaseModule(repo: NoteRepository): GetAllNoteUseCase =
        GetAllNoteUseCaseImpl(repo)

    @Provides
    fun provideGetNoteByIdUseCaseModule(repo: NoteRepository): GetNoteByIdUseCase =
        GetNoteByIdUseCaseImpl(repo)

    @Provides
    fun provideGetNoteByTitleUseCaseModule(repo: NoteRepository): GetNoteByTitleUseCase =
        GetNoteByTitleUseCaseImpl(repo)

    @Provides
    fun provideGetNoteFromTargetUseCaseModule(repo: NoteRepository): GetNoteFromTargetUseCase =
        GetNoteFromTargetUseCaseImpl(repo)

    @Provides
    fun provideUpdateNoteUseCaseModule(repo: NoteRepository): UpdateNoteUseCase =
        UpdateNoteUseCaseImpl(repo)

}

@Module
@InstallIn(ViewModelComponent::class)
class StepUseCaseModule {
    @Provides
    fun provideAddStepUseCaseModule(repo: StepRepository): AddStepUseCase = AddStepUseCaseImpl(repo)

    @Provides
    fun provideDeleteStepUseCaseModule(repo: StepRepository): DeleteStepUseCase =
        DeleteStepUseCaseImpl(repo)

    @Provides
    fun provideGetAllStepUseCaseModule(repo: StepRepository): GetAllStepUseCase =
        GetAllStepUseCaseImpl(repo)

    @Provides
    fun provideGetStepByIdUseCaseModule(repo: StepRepository): GetStepByIdUseCase =
        GetStepByIdUseCaseImpl(repo)

    @Provides
    fun provideGetStepByTitleUseCaseModule(repo: StepRepository): GetStepByTitleUseCase =
        GetStepByTitleUseCaseImpl(repo)

    @Provides
    fun provideGetStepFromTargetUseCaseModule(repo: StepRepository): GetStepFromTargetUseCase =
        GetStepFromTargetUseCaseImpl(repo)

    @Provides
    fun provideUpdateStepUseCaseModule(repo: StepRepository): UpdateStepUseCase =
        UpdateStepUseCaseImpl(repo)

}

@Module
@InstallIn(ViewModelComponent::class)
class TargetUseCaseModule {
    @Provides
    fun provideAddTargetUseCaseModule(repo: TargetRepository): AddTargetUseCase =
        AddTargetUseCaseImpl(repo)

    @Provides
    fun provideDeleteTargetUseCaseModule(repo: TargetRepository): DeleteTargetUseCase =
        DeleteTargetUseCaseImpl(repo)

    @Provides
    fun provideGetAllTargetUseCaseModule(repo: TargetRepository): GetAllTargetUseCase =
        GetAllTargetUseCaseImpl(repo)

    @Provides
    fun provideGetTargetByIdUseCaseModule(repo: TargetRepository): GetTargetByIdUseCase =
        GetTargetByIdUseCaseImpl(repo)

    @Provides
    fun provideGetTargetByTitleUseCaseModule(repo: TargetRepository): GetTargetByTitleUseCase =
        GetTargetByTitleUseCaseImpl(repo)

    @Provides
    fun provideUpdateTargetUseCaseModule(repo: TargetRepository): UpdateTargetUseCase =
        UpdateTargetUseCaseImpl(repo)
}