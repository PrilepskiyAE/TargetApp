package com.prilepskiy.myapplication.ui.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.prilepskiy.myapplication.R
import com.prilepskiy.myapplication.databinding.FragmentNoteInfoBinding
import com.prilepskiy.myapplication.databinding.FragmentProfileBinding
import com.prilepskiy.myapplication.ui.base.FragmentBaseMVVM
import com.prilepskiy.myapplication.ui.base.FragmentBaseNCMVVM
import com.prilepskiy.myapplication.ui.base.viewBinding
import com.prilepskiy.myapplication.ui.noteInfo.NoteInfoViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment  : FragmentBaseNCMVVM<ProfileViewModel, FragmentProfileBinding>() {
    override val binding: FragmentProfileBinding by viewBinding()
    override val viewModel: ProfileViewModel by viewModels()


}