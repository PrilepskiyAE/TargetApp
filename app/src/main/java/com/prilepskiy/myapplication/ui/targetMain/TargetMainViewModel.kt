package com.prilepskiy.myapplication.ui.targetMain

import androidx.lifecycle.viewModelScope
import com.prilepskiy.myapplication.domain.interactors.target.AddTargetUseCase
import com.prilepskiy.myapplication.domain.interactors.target.UpdateTargetUseCase
import com.prilepskiy.myapplication.domain.model.TargetModel
import com.prilepskiy.myapplication.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TargetMainViewModel @Inject constructor(

) : BaseViewModel() {

}