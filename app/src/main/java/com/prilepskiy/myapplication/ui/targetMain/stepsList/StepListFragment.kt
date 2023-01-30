package com.prilepskiy.myapplication.ui.targetMain.stepsList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.prilepskiy.myapplication.R
import com.prilepskiy.myapplication.databinding.FragmentStepInfoBinding
import com.prilepskiy.myapplication.databinding.FragmentStepListBinding
import com.prilepskiy.myapplication.ui.base.FragmentBaseMVVM
import com.prilepskiy.myapplication.ui.base.viewBinding
import com.prilepskiy.myapplication.ui.stepInfo.StepInfoViewModel
import com.prilepskiy.myapplication.ui.targetMain.noteList.NoteListViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class StepListFragment : FragmentBaseMVVM<StepListViewModel, FragmentStepListBinding>() {
    override val binding: FragmentStepListBinding by viewBinding()
    override val viewModel: StepListViewModel by viewModels()


}