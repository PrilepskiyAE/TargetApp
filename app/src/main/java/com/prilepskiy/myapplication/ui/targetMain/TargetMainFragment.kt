package com.prilepskiy.myapplication.ui.targetMain


import android.content.Intent
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.material.tabs.TabLayoutMediator

import com.prilepskiy.myapplication.databinding.FragmentTargetMainBinding
import com.prilepskiy.myapplication.ui.base.*
import com.prilepskiy.myapplication.ui.targetMain.noteList.NoteListFragment
import com.prilepskiy.myapplication.ui.targetMain.stepsList.StepListFragment
import com.prilepskiy.myapplication.ui.targetMain.targetList.TargetListFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TargetMainFragment : FragmentBaseNCMVVM<TargetMainViewModel, FragmentTargetMainBinding>() {
    override val binding: FragmentTargetMainBinding by viewBinding()
    override val viewModel: TargetMainViewModel by viewModels()
    val args: TargetMainFragmentArgs by navArgs()
    private var pagerAdapter: ViewPagerAdapter? = null
    private var targetCurrentTab = 0
    override fun onView() {

        ContractTarget.initData(args.ismode, args.target)
        //saveData?.saveData( args.ismode,binding.btSave,args.target)
        // val targetFragment=if (args.ismode){TargetListFragment(true)}else{TargetListFragment()}
        with(binding) {
            val tabTitles: List<String> = listOf("Цель", "Шаги", "Заметки")
            if (pagerAdapter == null) {
                pagerAdapter = ViewPagerAdapter(
                    this@TargetMainFragment,
                    listOf(
                        TargetListFragment(
                            // args.ismode,

                            // args.target
                        ),
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
            viewPager.adapter = pagerAdapter
            viewPager.isSaveEnabled = false
            viewPager.isUserInputEnabled = false
            TabLayoutMediator(
                tabLayout,
                viewPager
            ) { tab, position ->
                tab.text = tabTitles[position]
            }.attach()
            for (i in 0 until tabLayout.tabCount) {
                val tab: View = (tabLayout.getChildAt(0) as ViewGroup).getChildAt(i)
                tab.setMargins(24, 0, 0, 0)
                tab.requestLayout()
            }
        }

    }

    override fun onResume() {
        super.onResume()
        binding.viewPager.adapter = pagerAdapter
        binding.viewPager.setCurrentItem(targetCurrentTab, false)
    }

    override fun onPause() {
        super.onPause()
        targetCurrentTab = binding.viewPager.currentItem
        binding.viewPager.adapter = null
    }


    override fun onViewClick() {
        binding.btRevert.setOnClickListener {
            findNavController().popBackStack()
        }


    }
}

