package com.prilepskiy.myapplication.ui.main


import android.util.Log
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.prilepskiy.myapplication.databinding.FragmentMainBinding
import com.prilepskiy.myapplication.ui.adapter.TargetAdapter
import com.prilepskiy.myapplication.ui.base.FragmentBaseNCMVVM
import com.prilepskiy.myapplication.ui.base.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import java.time.LocalDateTime
import java.util.*
import java.util.concurrent.TimeUnit

@AndroidEntryPoint
class MainFragment : FragmentBaseNCMVVM<MainViewModel, FragmentMainBinding>() {
    override val binding: FragmentMainBinding by viewBinding()
    override val viewModel: MainViewModel by viewModels()
    val tAdapter=TargetAdapter {
        navigateFragment(
            MainFragmentDirections.actionMainFragmentToTargetMainFragment(
                true,it
            )
        )
    }

    override fun onView() {
        setAdapter()
       viewModel.getTargetList()


        val current = LocalDateTime.now()
        Log.d("TAG55", "onView:${current} ")
        val day = TimeUnit.MILLISECONDS.toDays(current.second.toLong())
        Log.d("TAG55", "onView:${day} ")
    }
    private fun setAdapter() {
        binding.recyclerViewTarget.apply {
            context?.let {
                layoutManager = LinearLayoutManager(it)
                adapter = tAdapter
            }
        }

    }
    override fun onEach() {
        onEach(viewModel.targetList){
            tAdapter.submitList(it)

        }
    }

    override fun onViewClick() {
        binding.btAddTarget.setOnClickListener {
            navigateFragment(MainFragmentDirections.actionMainFragmentToTargetMainFragment(
                false,null
            ))
        }
    }

}