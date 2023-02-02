package com.prilepskiy.myapplication.ui.targetMain.targetList

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.prilepskiy.myapplication.databinding.FragmentTargetListBinding
import com.prilepskiy.myapplication.ui.base.FragmentBaseMVVM
import com.prilepskiy.myapplication.ui.base.viewBinding
import com.prilepskiy.myapplication.ui.targetMain.TargetMainFragmentArgs
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TargetListFragment : FragmentBaseMVVM<TargetListViewModel, FragmentTargetListBinding>() {
    override val binding: FragmentTargetListBinding by viewBinding()
    override val viewModel: TargetListViewModel by viewModels()

    override fun onView() {

    }
    companion object {

        private const val SCREEN_MODE = "extra_mode"
        private const val ITEM_ID = "extra_shop_item_id"
        private const val MODE_EDIT = "mode_edit"
        private const val MODE_ADD = "mode_add"
        private const val MODE_UNKNOWN = ""
        fun newInstanceAddItem(): TargetListFragment {
            return TargetListFragment().apply {
                arguments = Bundle().apply {
                    putString(SCREEN_MODE, MODE_ADD)
                }
            }
        }
        fun newInstanceEditItem(Id: Long): TargetListFragment {
            return TargetListFragment().apply {
                arguments = Bundle().apply {
                    putString(SCREEN_MODE, MODE_EDIT)
                    putLong(ITEM_ID, Id)
                }
            }
        }
    }
}