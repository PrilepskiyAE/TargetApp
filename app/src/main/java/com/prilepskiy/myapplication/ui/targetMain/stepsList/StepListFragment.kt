package com.prilepskiy.myapplication.ui.targetMain.stepsList

import android.util.Log
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.prilepskiy.myapplication.R
import com.prilepskiy.myapplication.databinding.FragmentStepListBinding
import com.prilepskiy.myapplication.domain.model.TargetModel
import com.prilepskiy.myapplication.ui.adapter.NoteAdapter
import com.prilepskiy.myapplication.ui.adapter.StepAdapter
import com.prilepskiy.myapplication.ui.adapter.TargetAdapter
import com.prilepskiy.myapplication.ui.base.FragmentBaseMVVM
import com.prilepskiy.myapplication.ui.base.viewBinding
import com.prilepskiy.myapplication.ui.targetMain.ContractTarget
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class StepListFragment : FragmentBaseMVVM<StepListViewModel, FragmentStepListBinding>() {
    override val binding: FragmentStepListBinding by viewBinding()
    override val viewModel: StepListViewModel by viewModels()
    private var target: TargetModel? = ContractTarget.getDataTarget()
    private val stat:Boolean?= ContractTarget.getDataStat()
    val sAdapter= StepAdapter ({ it ->
        findNavController().navigate(R.id.stepInfoFragment, bundleOf(
            ID to  it.id,
            TITLE to it.title,
            DESC to it.description,
            IDTARGET to it.idTarget,
        )
        )
    },{ Log.d("TAG", "onItemLongClick88:${it} ")
        viewModel.modStatus(it)

    })
    override fun onEach() {
        onEach(viewModel.stepList){
            sAdapter.submitList(it)
        }
    }

    override fun onView() {
        super.onView()

        setAdapter()
    }
    private fun setAdapter() {
        binding.recyclerViewStep.apply {
            context?.let {
                layoutManager = LinearLayoutManager(it)
                adapter = sAdapter
            }
        }

    }

    override fun onViewClick() {
        Log.d("TAG", "onViewClick: $stat")
        Log.d("TAG", "onViewClick: $target")
        binding.btAddStep.setOnClickListener {
            findNavController().navigate(R.id.stepInfoFragment)
            //  findNavController().navigate(NoteListFragmentDirections.actionNoteListFragmentToNoteInfoFragment())
        }
        binding.tvSaveStep.setOnClickListener {
            if(stat==false)
                target?.let { it1 -> addTarget(it1) }
            else{
                modification()
            }
        }
    }
    private fun modification() {
        target?.let { it1 ->
            viewModel.modififation(
                it1
            )
        }
        findNavController().popBackStack()
    }

    private fun addTarget(data: TargetModel) {
        viewModel.addNewTarget(
            data
        )
        findNavController().popBackStack()
    }
    override fun onResume() {
        super.onResume()
        viewModel.getStepByTargetList(target?.id?:0)

    }
    companion object{
        const val ID  = "stepId"
        const val TITLE =   "stepTitle"
        const val DESC = "stepDesc"
        const val IDTARGET="stepIdTarget"
    }
}