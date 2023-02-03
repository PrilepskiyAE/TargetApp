package com.prilepskiy.myapplication.ui.targetMain.targetList

import androidx.lifecycle.viewModelScope
import com.prilepskiy.myapplication.domain.interactors.target.AddTargetUseCase
import com.prilepskiy.myapplication.domain.interactors.target.UpdateTargetUseCase
import com.prilepskiy.myapplication.domain.model.TargetModel
import com.prilepskiy.myapplication.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TargetListViewModel@Inject constructor(private val addTargetUseCase: AddTargetUseCase,
                                             private val updateTargetUseCase: UpdateTargetUseCase
): BaseViewModel() {

 fun addNewTarget(
    title: String,
    description: String = "",
    revard: String = "",
    date: String = "",
    resId: String = "",
    status: Boolean = true
) {
    viewModelScope.launch {
        addTargetUseCase(
            TargetModel(
                title = title,
                description = description,
                revard = revard,
                date = date,
                resId = resId,
                status = status
            )
        )
    }
}

fun modififation(
    id: Long,
    title: String,
    description: String = "",
    revard: String = "",
    date: String = "",
    resId: String = "",
    status: Boolean = true
) {
    viewModelScope.launch {
        updateTargetUseCase(
            TargetModel(
                id,
                title,
                description,
                revard,
                date,
                resId,
                status
            )
        )
    }
}
}