package com.prilepskiy.myapplication.ui.targetMain.stepsList

import androidx.lifecycle.viewModelScope
import com.prilepskiy.myapplication.domain.interactors.note.GetNoteFromTargetUseCase
import com.prilepskiy.myapplication.domain.interactors.step.GetStepFromTargetUseCase
import com.prilepskiy.myapplication.domain.model.NoteModel
import com.prilepskiy.myapplication.domain.model.StepModel
import com.prilepskiy.myapplication.domain.model.TargetModel
import com.prilepskiy.myapplication.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StepListViewModel@Inject constructor(
    private val getStepFromTargetUseCase: GetStepFromTargetUseCase
): BaseViewModel() {
    private val _stepList: MutableStateFlow<List<StepModel>?> by lazy {
        MutableStateFlow(
            null
        )
    }
    val noteList =_stepList.asStateFlow()

    fun getStepByTargetList(target:TargetModel){
        viewModelScope.launch {
            val result= getStepFromTargetUseCase(target.id)

            result.collectLatest {
                _stepList.value=it
            }
        }
    }
}