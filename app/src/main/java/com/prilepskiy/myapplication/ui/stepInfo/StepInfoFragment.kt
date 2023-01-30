package com.prilepskiy.myapplication.ui.stepInfo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.prilepskiy.myapplication.R
import com.prilepskiy.myapplication.databinding.FragmentProfileBinding
import com.prilepskiy.myapplication.databinding.FragmentStepInfoBinding
import com.prilepskiy.myapplication.ui.base.FragmentBaseMVVM
import com.prilepskiy.myapplication.ui.base.viewBinding
import com.prilepskiy.myapplication.ui.profile.ProfileViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class StepInfoFragment : FragmentBaseMVVM<StepInfoViewModel, FragmentStepInfoBinding>() {
    override val binding: FragmentStepInfoBinding by viewBinding()
    override val viewModel: StepInfoViewModel by viewModels()

}