package com.prilepskiy.myapplication.ui.targetMain.noteList


import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.prilepskiy.myapplication.R

import com.prilepskiy.myapplication.databinding.FragmentNoteListBinding
import com.prilepskiy.myapplication.ui.adapter.NoteAdapter
import com.prilepskiy.myapplication.ui.adapter.TargetAdapter

import com.prilepskiy.myapplication.ui.base.FragmentBaseMVVM

import com.prilepskiy.myapplication.ui.base.viewBinding
import com.prilepskiy.myapplication.ui.main.MainFragmentDirections
import com.prilepskiy.myapplication.ui.targetMain.ContractTarget

import dagger.hilt.android.AndroidEntryPoint



@AndroidEntryPoint
class NoteListFragment : FragmentBaseMVVM<NoteListViewModel, FragmentNoteListBinding>() {
    override val binding: FragmentNoteListBinding by viewBinding()
    override val viewModel:NoteListViewModel by viewModels()
    val nAdapter= NoteAdapter {
        findNavController().navigate(R.id.noteInfoFragment, bundleOf(
            "note" to it
        )
        )
    }
    override fun onEach() {
        onEach(viewModel.noteList){
            nAdapter.submitList(it)
        }
    }
    override fun onView() {
        setAdapter()
        ContractTarget.getDataTarget()?.let { viewModel.getNotebyTargetList(it.id) }

    }
    private fun setAdapter() {
        binding.recyclerViewNote.apply {
            context?.let {
                layoutManager = LinearLayoutManager(it)
                adapter = nAdapter
            }
        }

    }

    override fun onViewClick() {
        binding.btAddNote.setOnClickListener {
            findNavController().navigate(R.id.noteInfoFragment,bundleOf(
                "note" to ContractTarget.getDataTarget()
            ))
        }
    }
}