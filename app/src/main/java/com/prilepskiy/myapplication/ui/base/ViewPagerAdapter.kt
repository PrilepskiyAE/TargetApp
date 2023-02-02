package com.prilepskiy.myapplication.ui.base

import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter



    class ViewPagerAdapter(fragment: Fragment, private val pages: List<Fragment>) :
        FragmentStateAdapter(fragment) {

        var bundle: Bundle? = null

        override fun getItemCount(): Int = pages.size

        override fun createFragment(position: Int): Fragment {
            val fragment = pages[position]

            if (bundle != null)
                fragment.arguments = bundle?.apply {
                    putInt(TAB_POSITION_NUMBER,position)
                }
            else
                fragment.arguments = bundleOf(TAB_POSITION_NUMBER to position)

            return fragment
        }
        companion object{
            const val TAB_POSITION_NUMBER = "position_num"
        }

    }
