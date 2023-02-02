package com.prilepskiy.myapplication.ui.targetMain.noteList


import androidx.fragment.app.viewModels

import com.prilepskiy.myapplication.databinding.FragmentNoteListBinding

import com.prilepskiy.myapplication.ui.base.FragmentBaseMVVM

import com.prilepskiy.myapplication.ui.base.viewBinding

import dagger.hilt.android.AndroidEntryPoint



@AndroidEntryPoint
class NoteListFragment : FragmentBaseMVVM<NoteListViewModel, FragmentNoteListBinding>() {
    override val binding: FragmentNoteListBinding by viewBinding()
    override val viewModel:NoteListViewModel by viewModels()


}