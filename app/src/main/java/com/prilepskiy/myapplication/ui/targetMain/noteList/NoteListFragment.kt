package com.prilepskiy.myapplication.ui.targetMain.noteList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.prilepskiy.myapplication.R
import com.prilepskiy.myapplication.databinding.FragmentNoteListBinding
import com.prilepskiy.myapplication.databinding.FragmentStepInfoBinding
import com.prilepskiy.myapplication.ui.base.FragmentBaseMVVM
import com.prilepskiy.myapplication.ui.base.viewBinding
import com.prilepskiy.myapplication.ui.stepInfo.StepInfoViewModel
import dagger.hilt.android.AndroidEntryPoint



@AndroidEntryPoint
class NoteListFragment : FragmentBaseMVVM<NoteListViewModel, FragmentNoteListBinding>() {
    override val binding: FragmentNoteListBinding by viewBinding()
    override val viewModel:NoteListViewModel by viewModels()


}