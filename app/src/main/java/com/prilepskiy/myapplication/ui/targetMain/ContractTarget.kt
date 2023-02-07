package com.prilepskiy.myapplication.ui.targetMain

import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.ActivityResultRegistry
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import com.prilepskiy.myapplication.domain.model.TargetModel
import com.prilepskiy.myapplication.ui.base.loadImage

object ContractTarget  {
    private var stat: Boolean? = true
    private var tvsave: TextView? = null
    private var target: TargetModel? = null


    fun initData(statLocal: Boolean, tvsaveLocal: TextView, targetLocal: TargetModel? = null) {
        stat = statLocal
        tvsave = tvsaveLocal
        target = targetLocal
    }

    fun getDataStat(): Boolean? {
        return stat
    }

    fun getDataTvsave(): TextView? {
        return tvsave
    }

    fun getDataTarget(): TargetModel? {
        return target
    }

    fun setDataTarget(data:TargetModel): TargetModel {
       target= data
        return target?:data
    }

    fun setDataTvsave( data: TextView): TextView? {
        tvsave=data
        return tvsave
    }

}