package com.prilepskiy.myapplication.ui.targetMain

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.google.android.material.tabs.TabLayoutMediator
import com.prilepskiy.myapplication.R
import com.prilepskiy.myapplication.databinding.FragmentStepInfoBinding
import com.prilepskiy.myapplication.databinding.FragmentTargetMainBinding
import com.prilepskiy.myapplication.ui.base.*
import com.prilepskiy.myapplication.ui.stepInfo.StepInfoViewModel
import com.prilepskiy.myapplication.ui.targetMain.noteList.NoteListFragment
import com.prilepskiy.myapplication.ui.targetMain.stepsList.StepListFragment
import com.prilepskiy.myapplication.ui.targetMain.targetList.TargetListFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TargetMainFragment : FragmentBaseNCMVVM<TargetMainViewModel, FragmentTargetMainBinding>() {
    override val binding: FragmentTargetMainBinding by viewBinding()
    override val viewModel: TargetMainViewModel by viewModels()
    val args:TargetMainFragmentArgs by navArgs()
    override fun onView() {
        Log.d("TAG99", "onView:${args.ismode} ")
        val targetFragment=if (args.ismode){TargetListFragment.newInstanceEditItem(0)}else{TargetListFragment.newInstanceAddItem()}
        with(binding) {
            val tabTitles :List<String> = listOf("Цель","Шаги","Заметки")
        val pagerAdapter = ViewPagerAdapter(
            this@TargetMainFragment,
            listOf(
                targetFragment,
                StepListFragment(),
                NoteListFragment()
            )
        ).apply {
            viewPager.adapter = this
            viewPager.isSaveEnabled = false
            TabLayoutMediator(
                tabLayout,
                viewPager
            ) { tab, position ->
                tab.text = tabTitles[position]
            }.attach()
        }
    }
    }
}