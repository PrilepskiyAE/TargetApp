package com.prilepskiy.myapplication.ui.main


import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.prilepskiy.myapplication.databinding.FragmentMainBinding
import com.prilepskiy.myapplication.ui.adapter.TargetAdapter
import com.prilepskiy.myapplication.ui.base.FragmentBaseNCMVVM
import com.prilepskiy.myapplication.ui.base.viewBinding
import dagger.hilt.android.AndroidEntryPoint

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