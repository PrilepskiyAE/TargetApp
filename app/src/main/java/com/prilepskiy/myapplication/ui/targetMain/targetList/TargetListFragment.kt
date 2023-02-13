package com.prilepskiy.myapplication.ui.targetMain.targetList

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.ActivityResultRegistry
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.fragment.app.viewModels
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.fragment.findNavController
import com.prilepskiy.myapplication.databinding.FragmentTargetListBinding
import com.prilepskiy.myapplication.domain.model.TargetModel
import com.prilepskiy.myapplication.ui.base.*
import com.prilepskiy.myapplication.ui.targetMain.TargetMainFragment.Companion.STAT
import com.prilepskiy.myapplication.ui.targetMain.TargetMainFragment.Companion.TARGETL


import dagger.hilt.android.AndroidEntryPoint
import java.time.LocalDateTime


@AndroidEntryPoint
class TargetListFragment(): FragmentBaseMVVM<TargetListViewModel, FragmentTargetListBinding>() {
    override val binding: FragmentTargetListBinding by viewBinding()
    override val viewModel: TargetListViewModel by viewModels()
    private  var url:String="empty"
    private  var date:String=""
    private var stat:Boolean=false
    private var target:TargetModel=TargetModel()
    private lateinit var getObserver : GetContentLifecycleObserver



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        stat=arguments?.takeIf { it.containsKey(STAT) }
            ?.getBoolean(STAT) ?:false
        target=arguments?.takeIf { it.containsKey(TARGETL) }?.getParcelable<TargetModel>(TARGETL) as TargetModel
        Log.d("TAG", "onCreate: $target $stat")

    }

    override fun onView() {
        with(binding){
            if (stat==false){
                btEnd.visibility=View.INVISIBLE
                btDelete.visibility=View.INVISIBLE
            }else{
                    etTitle.setText(target.title)
                    etDescription.setText(target.description)
                    etReward.setText(target.revard)
                    loadImage(imgLogo, target.resId)
                    etData.setText(target.date)
                    url= target.resId
            }

            getObserver = GetContentLifecycleObserver(requireActivity().activityResultRegistry)
            lifecycle.addObserver(getObserver)
        }
        if (!target.status){
            binding.btEnd.text="Начать"
        }
    }
    override fun onViewClick() {
    with(binding){
        imgLogo.setOnClickListener {
            getObserver.selectImage()


        }
        btSaveTarget.setOnClickListener {
            if(stat==false)
                addTarget(
                    target.copy(
                        title= binding.etTitle.text.toString(),
                        description= binding.etDescription.text.toString(),
                        revard= binding.etReward.text.toString(),
                        date=date.toString(),
                        resId = url
                ))
            else{
                modification()
            }
        }
        etData.setOnClickListener {

            showCalendarDialog {
               date=it
            }

        }

        btDelete.setOnClickListener {

                viewModel.deleteTarget(target)
                findNavController().popBackStack()


        }
        btEnd.setOnClickListener {
            viewModel.modififation(target.copy(status = !target.status))
            findNavController().popBackStack()
        }

    }

    }


    private fun modification() {
        Log.d("TAG", "onViewClick: $target")
        target.let { it1 ->
            viewModel.modififation(
                it1.copy(
                    title = binding.etTitle.text.toString(),
                    description = binding.etDescription.text.toString(),
                    revard = binding.etReward.text.toString(),
                    date =date.toString(),
                    resId = url
                )
            )
        }
        findNavController().popBackStack()
    }

    private fun addTarget(data:TargetModel) {
        viewModel.addNewTarget(
            data
//            binding.etTitle.text.toString(),
//            binding.etDescription.text.toString(),
//            binding.etReward.text.toString(),
//            binding.etData.text.toString(),
//            url
        )
        findNavController().popBackStack()
    }

    inner class GetContentLifecycleObserver(private val registry : ActivityResultRegistry)
        : DefaultLifecycleObserver {
        lateinit var getContent : ActivityResultLauncher<String>

        override fun onCreate(owner: LifecycleOwner) {
            getContent = registry.register("key", owner, ActivityResultContracts.GetContent()) { uri ->
                url= uri.toString()
                loadImage(binding.imgLogo,uri.toString())
            }
        }

        fun selectImage() {
            getContent.launch("image/*")
        }
    }

}