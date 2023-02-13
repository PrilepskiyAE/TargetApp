package com.prilepskiy.myapplication.ui.targetMain.stepsList

import androidx.lifecycle.viewModelScope
import com.prilepskiy.myapplication.domain.interactors.note.GetNoteFromTargetUseCase
import com.prilepskiy.myapplication.domain.interactors.step.GetStepFromTargetUseCase
import com.prilepskiy.myapplication.domain.interactors.step.UpdateStepUseCase
import com.prilepskiy.myapplication.domain.interactors.target.AddTargetUseCase
import com.prilepskiy.myapplication.domain.interactors.target.UpdateTargetUseCase
import com.prilepskiy.myapplication.domain.model.NoteModel
import com.prilepskiy.myapplication.domain.model.StepModel
import com.prilepskiy.myapplication.domain.model.TargetModel
import com.prilepskiy.myapplication.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StepListViewModel@Inject constructor(
    private val getStepFromTargetUseCase: GetStepFromTargetUseCase,  private val updateStepUseCase: UpdateStepUseCase,
): BaseViewModel() {
    private val _stepList: MutableStateFlow<List<StepModel>?> by lazy {
        MutableStateFlow(
            null
        )
    }
    val stepList =_stepList.asStateFlow()

    fun getStepByTargetList(id:Long){
        CoroutineScope(Dispatchers.IO).launch {
            val result= getStepFromTargetUseCase(id)

            result.collectLatest {
                _stepList.value=it
            }
        }
    }

    fun modStatus(date: StepModel ) {
        CoroutineScope(Dispatchers.IO).launch {
            var stationItems = _stepList.value
            var updatedItem = stationItems?.find { it.id == date.id }
            val index = stationItems?.indexOf(updatedItem)?:0
            updatedItem=updatedItem?.copy(status = !date.status)
            if (index == -1) {
                Throwable("Error: Index Error")
            }
            stationItems = stationItems?.toMutableList().apply {
                if (updatedItem != null) {
                    this?.set(index, updatedItem)
                    updateStepUseCase(updatedItem)
                }
            }
            _stepList.emit(stationItems)

        }
    }
}