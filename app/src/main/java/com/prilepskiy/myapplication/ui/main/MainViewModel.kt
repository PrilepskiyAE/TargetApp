package com.prilepskiy.myapplication.ui.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.prilepskiy.myapplication.domain.model.NoteModel
import com.prilepskiy.myapplication.domain.repository.NoteRepository
import com.prilepskiy.myapplication.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    //private val  nt:NoteRepository
    ) : BaseViewModel() {
//    init {
//       //testInit()
//    }
//    private val _test: MutableStateFlow<List<NoteModel>?> by lazy {
//        MutableStateFlow(
//            null
//        )
//    }
//    val test = _test.asStateFlow()
//    fun testInit(){
//        viewModelScope.launch {
//            nt.inT()
//            Log.d("TAG99", "init")
//        }
//    }
//    fun testGet(){
//        viewModelScope.launch {
//           val result= nt.getAllNote()
//            Log.d("TAG99", "testGet: ${result}")
//            result.collectLatest {
//                _test.value=it
//            }
//        }
//    }
}