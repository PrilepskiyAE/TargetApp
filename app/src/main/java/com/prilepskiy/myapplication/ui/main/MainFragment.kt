package com.prilepskiy.myapplication.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.prilepskiy.myapplication.R
import com.prilepskiy.myapplication.databinding.FragmentMainBinding
import com.prilepskiy.myapplication.ui.base.FragmentBaseMVVM
import com.prilepskiy.myapplication.ui.base.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : FragmentBaseMVVM<MainViewModel, FragmentMainBinding>() {
    override val binding: FragmentMainBinding by viewBinding()
    override val viewModel: MainViewModel by viewModels()
    override fun onView() {
       // viewModel.testGet()
    }

    override fun onEach() {
//        onEach(viewModel.test){
//            Log.d("TAG99", "onEach:$it ")
//
//        }
    }

}