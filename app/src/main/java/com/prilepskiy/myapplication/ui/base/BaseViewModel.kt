package com.prilepskiy.myapplication.ui.base

import androidx.lifecycle.ViewModel
import com.prilepskiy.myapplication.domain.model.StepModel
import com.prilepskiy.myapplication.domain.model.TargetModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel(){
//    private val _target: MutableStateFlow<TargetModel?> by lazy {
//        MutableStateFlow(
//            null
//        )
//    }
//    val target = _target.asStateFlow()
//
//   fun setTarget(target:TargetModel){
//       CoroutineScope(Dispatchers.IO).launch {
//           _target.emit(target)
//       }
//   }

}