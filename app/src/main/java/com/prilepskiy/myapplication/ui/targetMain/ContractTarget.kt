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

object ContractTarget : DefaultLifecycleObserver {
    private var stat: Boolean? = true
    private var tvsave: TextView? = null
    private var target: TargetModel? = null
    private var registrylocal : ActivityResultRegistry?=null
    lateinit var getContent : ActivityResultLauncher<String>
    private var url:String?=null

    fun initData(statLocal: Boolean, tvsaveLocal: TextView, targetLocal: TargetModel? = null) {
        stat = statLocal
        tvsave = tvsaveLocal
        target = targetLocal
    }
    fun setRegistary(registry : ActivityResultRegistry){
        registrylocal=registry

    }
   fun getUrl():String?{
       return url
   }
    override fun onCreate(owner: LifecycleOwner) {
        getContent = registrylocal?.register("key", owner, ActivityResultContracts.GetContent()) { uri ->
            Log.d("TAG", "onCreate99: ${uri?.path} ")

                url= uri?.toString()

        } as ActivityResultLauncher<String>
    }

    fun selectImage() {
        getContent.launch("image/*")
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

}