package com.prilepskiy.myapplication.ui.targetMain.stepsList

import androidx.fragment.app.viewModels
import com.prilepskiy.myapplication.databinding.FragmentStepListBinding
import com.prilepskiy.myapplication.ui.base.FragmentBaseMVVM
import com.prilepskiy.myapplication.ui.base.viewBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class StepListFragment : FragmentBaseMVVM<StepListViewModel, FragmentStepListBinding>() {
    override val binding: FragmentStepListBinding by viewBinding()
    override val viewModel: StepListViewModel by viewModels()


}