package com.prilepskiy.myapplication.ui.targetMain

import android.content.DialogInterface
import android.util.Log
import com.prilepskiy.myapplication.databinding.DialogCalendarBinding
import com.prilepskiy.myapplication.ui.base.BaseDialog
import com.prilepskiy.myapplication.ui.base.viewBinding

class CaledarDialog() : BaseDialog<DialogCalendarBinding>() {
    override val binding: DialogCalendarBinding by viewBinding()
    var onDismissAction: () -> Unit = {}
    var onCancelAction: () -> Unit = {}
    var action: (i:Long) -> Unit = {}

    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)
        onDismissAction()
    }

    override fun onCancel(dialog: DialogInterface) {
        super.onCancel(dialog)
        onCancelAction()
    }

    override fun onViewClick() {
        binding.calendarView.setOnDateChangeListener { calendarView, i, i2, i3 ->
            Log.d("TAG", "onViewClick: ${calendarView.date}")
            Log.d("TAG", "onViewClick: $i")
            Log.d("TAG", "onViewClick: $i2")
            Log.d("TAG", "onViewClick: $i3")
            action(calendarView.date)
            dismiss()
        }
    }
}
