package com.prilepskiy.myapplication.ui.stepInfo

import androidx.lifecycle.viewModelScope
import com.prilepskiy.myapplication.domain.interactors.note.AddNoteUseCase
import com.prilepskiy.myapplication.domain.interactors.note.DeleteNoteUseCase
import com.prilepskiy.myapplication.domain.interactors.note.UpdateNoteUseCase
import com.prilepskiy.myapplication.domain.interactors.step.AddStepUseCase
import com.prilepskiy.myapplication.domain.interactors.step.DeleteStepUseCase
import com.prilepskiy.myapplication.domain.interactors.step.UpdateStepUseCase
import com.prilepskiy.myapplication.domain.model.NoteModel
import com.prilepskiy.myapplication.domain.model.StepModel
import com.prilepskiy.myapplication.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StepInfoViewModel@Inject constructor(
    private val addStepUseCase: AddStepUseCase,
    private val updateStepUseCase: UpdateStepUseCase,
    private val deleteStepUseCase: DeleteStepUseCase
) : BaseViewModel() {

    fun addStep(
        data: StepModel
    ) {
        viewModelScope.launch {
            addStepUseCase(
                data
            )
        }
    }

    fun modification(date: StepModel) {
        CoroutineScope(Dispatchers.IO).launch {
            updateStepUseCase(date)
        }
    }

    fun delete(data: StepModel) {
        viewModelScope.launch {
            deleteStepUseCase(
                data
            )
        }
    }
}