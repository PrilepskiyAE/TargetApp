package com.prilepskiy.myapplication.ui.targetMain

import androidx.lifecycle.viewModelScope
import com.prilepskiy.myapplication.domain.interactors.target.AddTargetUseCase
import com.prilepskiy.myapplication.domain.interactors.target.UpdateTargetUseCase
import com.prilepskiy.myapplication.domain.model.StepModel
import com.prilepskiy.myapplication.domain.model.TargetModel
import com.prilepskiy.myapplication.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TargetMainViewModel @Inject constructor(
    private val addTargetUseCase: AddTargetUseCase,
    private val updateTargetUseCase: UpdateTargetUseCase,
) : BaseViewModel() {

//    fun addNewTarget(
//        data: TargetModel
//    ) {
//        CoroutineScope(Dispatchers.IO).launch {
//            addTargetUseCase(
//                data
//            )
//        }
//    }
//
//    fun modififation(date: TargetModel) {
//        viewModelScope.launch {
//            updateTargetUseCase(date)
//        }
//    }
}