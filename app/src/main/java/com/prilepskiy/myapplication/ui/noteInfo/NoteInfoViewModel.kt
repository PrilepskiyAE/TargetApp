package com.prilepskiy.myapplication.ui.noteInfo

import androidx.lifecycle.viewModelScope
import com.prilepskiy.myapplication.domain.interactors.note.AddNoteUseCase
import com.prilepskiy.myapplication.domain.interactors.note.UpdateNoteUseCase
import com.prilepskiy.myapplication.domain.model.NoteModel
import com.prilepskiy.myapplication.domain.model.TargetModel
import com.prilepskiy.myapplication.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteInfoViewModel @Inject constructor(
    private val addNoteUseCase: AddNoteUseCase,
    private val updateNoteUseCase: UpdateNoteUseCase
) : BaseViewModel() {

    fun addNewNote(
        title: String = "",
        description: String = "",
        idTarget: Long,
        resId: String = "",
        date: String = ""
    ) {
        viewModelScope.launch {
            addNoteUseCase(
                NoteModel(

                    title = title,
                    description = description,
                    idTarget = idTarget,
                    resId = resId,
                    date = date
                )
            )
        }
    }

    fun modififation(date: NoteModel) {
        viewModelScope.launch {
            updateNoteUseCase(date)
        }
    }


}