package com.prilepskiy.myapplication.ui.stepInfo


import androidx.fragment.app.viewModels

import com.prilepskiy.myapplication.databinding.FragmentStepInfoBinding
import com.prilepskiy.myapplication.ui.base.FragmentBaseNCMVVM
import com.prilepskiy.myapplication.ui.base.viewBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class StepInfoFragment : FragmentBaseNCMVVM<StepInfoViewModel, FragmentStepInfoBinding>() {
    override val binding: FragmentStepInfoBinding by viewBinding()
    override val viewModel: StepInfoViewModel by viewModels()

}