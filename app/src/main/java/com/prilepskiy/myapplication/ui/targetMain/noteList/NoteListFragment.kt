package com.prilepskiy.myapplication.ui.targetMain.noteList


import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.prilepskiy.myapplication.R

import com.prilepskiy.myapplication.databinding.FragmentNoteListBinding
import com.prilepskiy.myapplication.domain.model.TargetModel
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
    private var target: TargetModel? = ContractTarget.getDataTarget()
    val nAdapter= NoteAdapter { it ->
         findNavController().navigate(R.id.noteInfoFragment, bundleOf(
             ID to  it.id,
             TITLE to it.title,
             RESID to it.resId,
             IDTARGET to it.idTarget,
             ))
       // findNavController().navigate(NoteListFragmentDirections.actionNoteListFragmentToNoteInfoFragment().setNode(it))

    }
    override fun onEach() {
        onEach(viewModel.noteList){
            Log.d("TAG", "onEach: ${it?.size}")
            nAdapter.submitList(it)
        }
    }

    override fun onView() {
        super.onView()

        setAdapter()
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
        Log.d("TAG", "onViewClick: $target")
        binding.btAddNote.setOnClickListener {
            findNavController().navigate(R.id.noteInfoFragment)
          //  findNavController().navigate(NoteListFragmentDirections.actionNoteListFragmentToNoteInfoFragment())
        }
    }

    override fun onResume() {
        super.onResume()
       viewModel.getNotebyTargetList(target?.id?:0)

    }
    companion object{
      const val ID  = "noteId"
        const val TITLE =   "noteTitle"
        const val RESID = "noteResId"
        const val IDTARGET="noteidTarget"
    }
}