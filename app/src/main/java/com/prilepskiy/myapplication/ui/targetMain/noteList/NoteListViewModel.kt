package com.prilepskiy.myapplication.ui.targetMain.noteList


import androidx.lifecycle.viewModelScope
import com.prilepskiy.myapplication.domain.interactors.note.DeleteNoteUseCase
import com.prilepskiy.myapplication.domain.interactors.note.GetNoteFromTargetUseCase
import com.prilepskiy.myapplication.domain.interactors.target.AddTargetUseCase
import com.prilepskiy.myapplication.domain.interactors.target.DeleteTargetUseCase
import com.prilepskiy.myapplication.domain.interactors.target.UpdateTargetUseCase
import com.prilepskiy.myapplication.domain.model.NoteModel
import com.prilepskiy.myapplication.domain.model.TargetModel
import com.prilepskiy.myapplication.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteListViewModel@Inject constructor(private val getNoteFromTargetUseCase: GetNoteFromTargetUseCase, private val addTargetUseCase: AddTargetUseCase,
                                           private val updateTargetUseCase: UpdateTargetUseCase): BaseViewModel() {
    private val _noteList: MutableStateFlow<List<NoteModel>?> by lazy {
        MutableStateFlow(
            null
        )
    }
    val noteList =_noteList.asStateFlow()

    fun getNotebyTargetList(id:Long){
        CoroutineScope(Dispatchers.IO).launch {
            val result= getNoteFromTargetUseCase(id)

            result.collectLatest {
                _noteList.value=it
            }
        }
    }
    fun addNewTarget(
        data: TargetModel
    ) {
        viewModelScope.launch {
            addTargetUseCase(
                data
            )
        }
    }

    fun modififation(date: TargetModel) {
        viewModelScope.launch {
            updateTargetUseCase(date)
        }
    }
}