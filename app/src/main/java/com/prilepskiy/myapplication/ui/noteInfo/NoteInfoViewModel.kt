package com.prilepskiy.myapplication.ui.noteInfo

import androidx.lifecycle.viewModelScope
import com.prilepskiy.myapplication.domain.interactors.note.AddNoteUseCase
import com.prilepskiy.myapplication.domain.interactors.note.DeleteNoteUseCase
import com.prilepskiy.myapplication.domain.interactors.note.UpdateNoteUseCase
import com.prilepskiy.myapplication.domain.model.NoteModel
import com.prilepskiy.myapplication.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteInfoViewModel @Inject constructor(
    private val addNoteUseCase: AddNoteUseCase,
    private val updateNoteUseCase: UpdateNoteUseCase,
    private val deleteNoteUseCase: DeleteNoteUseCase
) : BaseViewModel() {

    fun addNewNote(
        data: NoteModel
    ) {
        viewModelScope.launch {
            addNoteUseCase(
                data
            )
        }
    }

    fun modification(date: NoteModel) {
        CoroutineScope(Dispatchers.IO).launch {
            updateNoteUseCase(date)
        }
    }

    fun delete(data: NoteModel) {
        viewModelScope.launch {
            deleteNoteUseCase(
                data
            )
        }
    }
}