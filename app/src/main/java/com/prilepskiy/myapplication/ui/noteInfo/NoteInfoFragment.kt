package com.prilepskiy.myapplication.ui.noteInfo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.prilepskiy.myapplication.R
import com.prilepskiy.myapplication.databinding.FragmentMainBinding
import com.prilepskiy.myapplication.databinding.FragmentNoteInfoBinding
import com.prilepskiy.myapplication.ui.base.FragmentBaseMVVM
import com.prilepskiy.myapplication.ui.base.FragmentBaseNCMVVM
import com.prilepskiy.myapplication.ui.base.viewBinding
import com.prilepskiy.myapplication.ui.main.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NoteInfoFragment : FragmentBaseNCMVVM<NoteInfoViewModel, FragmentNoteInfoBinding>() {
    override val binding: FragmentNoteInfoBinding by viewBinding()
    override val viewModel:NoteInfoViewModel by viewModels()


}