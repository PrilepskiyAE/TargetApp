package com.prilepskiy.myapplication.ui.noteInfo


import android.util.Log
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController

import com.prilepskiy.myapplication.databinding.FragmentNoteInfoBinding
import com.prilepskiy.myapplication.domain.model.TargetModel

import com.prilepskiy.myapplication.ui.base.FragmentBaseNCMVVM
import com.prilepskiy.myapplication.ui.base.viewBinding
import com.prilepskiy.myapplication.ui.targetMain.ContractTarget

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NoteInfoFragment : FragmentBaseNCMVVM<NoteInfoViewModel, FragmentNoteInfoBinding>() {
    override val binding: FragmentNoteInfoBinding by viewBinding()
    override val viewModel:NoteInfoViewModel by viewModels()
    private var target: TargetModel? = ContractTarget.getDataTarget()
    override fun onView() {
//        Log.d("TAG", "onView: $target")
//        target = arguments?.get("note") as TargetModel?
//        binding.etNote.setText(target?.title?:"")
    }

    override fun onResume() {
        super.onResume()
        Log.d("TAG", "onView11: $target")

    }
    override fun onViewClick() {
        binding.tvLabel.setOnClickListener{
            target?.id?.let { it1 -> viewModel.addNewNote(binding.etNote.text.toString(),"", it1) }
            popBackStack()
        }
        binding.btRevert.setOnClickListener { findNavController().popBackStack() }
    }

}