package com.prilepskiy.myapplication.ui.main


import androidx.lifecycle.viewModelScope
import com.prilepskiy.myapplication.domain.interactors.target.GetAllTargetUseCase

import com.prilepskiy.myapplication.domain.model.TargetModel

import com.prilepskiy.myapplication.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val  getAllTargetUseCase: GetAllTargetUseCase
    ) : BaseViewModel() {
    init {

    }

    private val _targetList: MutableStateFlow<List<TargetModel>?> by lazy {
        MutableStateFlow(
            null
        )
    }
   val targetList =_targetList.asStateFlow()
//    fun testInit(){
//        viewModelScope.launch {
//            nt.inT()
//            Log.d("TAG99", "init")
//        }
//    }
    fun getTargetList(){
        viewModelScope.launch {
           val result= getAllTargetUseCase()

            result.collectLatest {
                _targetList.value=it
            }
        }
    }
}