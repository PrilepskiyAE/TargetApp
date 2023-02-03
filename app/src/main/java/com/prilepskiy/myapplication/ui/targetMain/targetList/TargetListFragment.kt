package com.prilepskiy.myapplication.ui.targetMain.targetList

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.prilepskiy.myapplication.databinding.FragmentTargetListBinding

import com.prilepskiy.myapplication.ui.base.FragmentBaseMVVM
import com.prilepskiy.myapplication.ui.base.loadImage
import com.prilepskiy.myapplication.ui.base.viewBinding
import com.prilepskiy.myapplication.ui.targetMain.TargetMainFragmentArgs
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TargetListFragment( private val stat:Boolean) : FragmentBaseMVVM<TargetListViewModel, FragmentTargetListBinding>() {
    override val binding: FragmentTargetListBinding by viewBinding()
    override val viewModel: TargetListViewModel by viewModels()
    lateinit var activityResultLauncher: ActivityResultLauncher<Intent>
    private  var url:String="empty"



    override fun onView() {
        Log.d("TAG99", "onView: $stat ")
        if (!stat){
            binding.btEnd.visibility=View.INVISIBLE
            binding.btDelete.visibility=View.INVISIBLE
        }else{

        }

        activityResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            it.data?.apply {
                loadImage(binding.imgLogo, data.toString())
                url=data.toString()

            }
        }
    }
    override fun onViewClick() {
        binding.imgLogo.setOnClickListener {

            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "image/*"
            activityResultLauncher.launch(intent)
        }
        binding.btSaveTarget.setOnClickListener {
            viewModel.addNewTarget(
                binding.etTitle.text.toString(),
                binding.etDescription.text.toString(),
                binding.etReward.text.toString(),
                binding.etData.text.toString(),
                url
            )
            findNavController().popBackStack()
        }

    }


}