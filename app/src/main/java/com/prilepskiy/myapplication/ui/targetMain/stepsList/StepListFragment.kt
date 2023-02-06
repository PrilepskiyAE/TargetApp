package com.prilepskiy.myapplication.ui.targetMain.stepsList

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.prilepskiy.myapplication.R
import com.prilepskiy.myapplication.databinding.FragmentStepListBinding
import com.prilepskiy.myapplication.ui.adapter.StepAdapter
import com.prilepskiy.myapplication.ui.adapter.TargetAdapter
import com.prilepskiy.myapplication.ui.base.FragmentBaseMVVM
import com.prilepskiy.myapplication.ui.base.viewBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class StepListFragment : FragmentBaseMVVM<StepListViewModel, FragmentStepListBinding>() {
    override val binding: FragmentStepListBinding by viewBinding()
    override val viewModel: StepListViewModel by viewModels()
    val sAdapter= StepAdapter {

    }
    override fun onViewClick() {
        binding.btAddStep.setOnClickListener {
            findNavController().navigate(R.id.stepInfoFragment)
        }

    }


}