package com.prilepskiy.myapplication.ui.targetMain.noteList


import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.annotation.RequiresApi
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
import com.prilepskiy.myapplication.ui.targetMain.TargetMainFragment

import dagger.hilt.android.AndroidEntryPoint



@AndroidEntryPoint
class NoteListFragment() : FragmentBaseMVVM<NoteListViewModel, FragmentNoteListBinding>() {
    override val binding: FragmentNoteListBinding by viewBinding()
    override val viewModel:NoteListViewModel by viewModels()
    private var stat:Boolean=false
    private var target:TargetModel=TargetModel()
    val nAdapter= NoteAdapter { it ->
         findNavController().navigate(R.id.noteInfoFragment, bundleOf(
             ID to  it.id,
             TITLE to it.title,
             RESID to it.resId,
             IDTARGET to it.idTarget,
             STAT to true
             ))

    }
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        stat=arguments?.takeIf { it.containsKey(TargetMainFragment.STAT) }
            ?.getBoolean(TargetMainFragment.STAT) ?:false
        target=arguments?.takeIf { it.containsKey(TargetMainFragment.TARGETL) }?.getParcelable<TargetModel>(
            TargetMainFragment.TARGETL
        ) as TargetModel
        Log.d("TAG", "onCreate: $target $stat")

    }
    override fun onEach() {
        onEach(viewModel.noteList){
            nAdapter.submitList(it)
        }
    }

    override fun onView() {
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
        binding.btAddNote.setOnClickListener {
            findNavController().navigate(R.id.noteInfoFragment, bundleOf(IDTARGET to target.id,
                STAT to false))
        }

    }
    private fun modification() {
        target?.let { it1 ->
            viewModel.modififation(
                it1
            )
        }
        findNavController().popBackStack()
    }

    private fun addTarget(data:TargetModel) {
        viewModel.addNewTarget(
            data
        )
        findNavController().popBackStack()
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
        const val STAT="stat"
    }
}