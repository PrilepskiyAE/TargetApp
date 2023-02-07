package com.prilepskiy.myapplication.ui.targetMain.targetList

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.prilepskiy.myapplication.databinding.FragmentTargetListBinding
import com.prilepskiy.myapplication.domain.model.TargetModel

import com.prilepskiy.myapplication.ui.base.FragmentBaseMVVM
import com.prilepskiy.myapplication.ui.base.loadImage
import com.prilepskiy.myapplication.ui.base.viewBinding
import com.prilepskiy.myapplication.ui.targetMain.ContractTarget
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TargetListFragment: FragmentBaseMVVM<TargetListViewModel, FragmentTargetListBinding>() {
    override val binding: FragmentTargetListBinding by viewBinding()
    override val viewModel: TargetListViewModel by viewModels()
  //  lateinit var activityResultLauncher: ActivityResultLauncher<Intent>
    private  var url:String="empty"

    private val stat:Boolean?=ContractTarget.getDataStat()
    private val tvsave:TextView?=ContractTarget.getDataTvsave()
    private var target: TargetModel?=ContractTarget.getDataTarget()



    override fun onView() {
        with(binding){
            if (stat==false){
                btEnd.visibility=View.INVISIBLE
                btDelete.visibility=View.INVISIBLE
            }else{
                if (target!=null){
                    etTitle.setText(target!!.title)
                    etDescription.setText(target!!.description)
                    etReward.setText(target!!.revard)
                    loadImage(imgLogo, target!!.resId)
                    etData.setText(target!!.date)
                    url= target!!.resId
                }
            }
            ContractTarget.getUrl()
            Log.d("TAG", "onCreate1: $url")

        }
    }
    override fun onViewClick() {

        loadImage(binding.imgLogo,"/document/image:11056")
        lifecycle.addObserver(ContractTarget)
        binding.btSaveTarget.setOnClickListener {
            if(stat==false)
                addTarget()
            else{
                modification()
            }
        }
        tvsave?.setOnClickListener {
            if(stat==false)
            addTarget()
            else{
                modification()
            }
        }
        binding.btDelete.setOnClickListener {
            if (target != null) {
                viewModel.deleteTarget(target!!)
                findNavController().popBackStack()
            }

        }
        binding.btEnd.setOnClickListener {
            target?.let { it1 -> viewModel.modififation(it1.copy(status = !it1.status)) }
            findNavController().popBackStack()
        }



    }

    override fun onResume() {
        super.onResume()
        binding.imgLogo.setOnClickListener {

            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "image/*"
           // activityResultLauncher.launch(intent)
            ContractTarget.selectImage()
            url= ContractTarget.getUrl()?:"empty"

            Log.d("TAG", "onResume99: $url")



        }
    }

    private fun modification() {
        Log.d("TAG", "onViewClick: $target")
        target?.let { it1 ->
            viewModel.modififation(
                it1.copy(
                    title = binding.etTitle.text.toString(),
                    description = binding.etDescription.text.toString(),
                    revard = binding.etReward.text.toString(),
                    date = binding.etData.text.toString(),
                    resId = url
                )
            )
        }
        findNavController().popBackStack()
    }

    private fun addTarget() {
        viewModel.addNewTarget(
            binding.etTitle.text.toString(),
            binding.etDescription.text.toString(),
            binding.etReward.text.toString(),
            binding.etData.text.toString(),
            url
        )
        findNavController().popBackStack()
    }

    override fun onPause() {
        super.onPause()
        if (stat==false){
        target = TargetModel(
            title = binding.etTitle.text.toString(),
            description = binding.etDescription.text.toString() ,
            revard =   binding.etReward.text.toString(),
            date =binding.etData.text.toString(),
            status = true,
            resId = url )
            if (tvsave != null) {
                ContractTarget.initData( stat,tvsave,target)
            }
    }
    }

}