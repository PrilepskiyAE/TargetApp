package com.prilepskiy.myapplication.ui.targetMain

import android.widget.TextView
import com.prilepskiy.myapplication.domain.model.TargetModel

object ContractTarget {
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

}