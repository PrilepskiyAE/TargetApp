package com.prilepskiy.myapplication.ui.stepInfo


import android.content.Intent
import android.util.Log
import androidx.activity.result.ActivityResultLauncher
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController

import com.prilepskiy.myapplication.databinding.FragmentStepInfoBinding
import com.prilepskiy.myapplication.domain.model.NoteModel
import com.prilepskiy.myapplication.domain.model.StepModel
import com.prilepskiy.myapplication.domain.model.TargetModel
import com.prilepskiy.myapplication.ui.base.FragmentBaseNCMVVM
import com.prilepskiy.myapplication.ui.base.getUniqueId
import com.prilepskiy.myapplication.ui.base.viewBinding
import com.prilepskiy.myapplication.ui.targetMain.ContractTarget
import com.prilepskiy.myapplication.ui.targetMain.noteList.NoteListFragment
import com.prilepskiy.myapplication.ui.targetMain.stepsList.StepListFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class StepInfoFragment : FragmentBaseNCMVVM<StepInfoViewModel, FragmentStepInfoBinding>() {
    override val binding: FragmentStepInfoBinding by viewBinding()
    override val viewModel: StepInfoViewModel by viewModels()
    private var target: TargetModel? = ContractTarget.getDataTarget()
    private var idStep: Long = 0
    private var title: String = ""
    private var descriptor: String = ""
    private var idTagert: Long = 0

    override fun onView() {
        idStep = arguments?.takeIf { it.containsKey(StepListFragment.ID) }?.getLong(
            StepListFragment.ID
        ) ?: getUniqueId()
        title = arguments?.takeIf { it.containsKey(StepListFragment.TITLE) }?.getString(
            StepListFragment.TITLE
        ) ?: ""
        idTagert = arguments?.takeIf { it.containsKey(StepListFragment.IDTARGET) }?.getLong(
            StepListFragment.IDTARGET
        ) ?: target?.id ?: 0
        descriptor = arguments?.takeIf { it.containsKey(StepListFragment.DESC) }?.getString(
            StepListFragment.DESC
        ) ?: ""
        binding.etStep.setText(title)
        binding.etDescriptor.setText(descriptor)
    }
    override fun onViewClick() {
        binding.tvLabel.setOnClickListener {
            if (arguments == null) {
                viewModel.addStep(
                    StepModel(
                        idStep,
                        binding.etStep.text.toString(),
                        binding.etDescriptor.text.toString(),
                        idTagert
                    )
                )

            } else {
                viewModel.modification(
                    StepModel(
                        idStep,
                        binding.etStep.text.toString(),
                        binding.etDescriptor.text.toString(),
                        idTagert
                    )
                )
            }

            popBackStack()
        }
        binding.tvDelete.setOnClickListener {
            viewModel.delete(
                StepModel(
                    idStep,
                    binding.etStep.text.toString(),
                    binding.etDescriptor.text.toString(),
                    idTagert
                )
            )
            findNavController().popBackStack()
        }
        binding.btRevert.setOnClickListener { findNavController().popBackStack() }
    }

}