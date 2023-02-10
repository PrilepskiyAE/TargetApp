package com.prilepskiy.myapplication.ui.targetMain

import android.content.DialogInterface
import android.util.Log
import com.prilepskiy.myapplication.databinding.DialogCalendarBinding
import com.prilepskiy.myapplication.ui.base.BaseDialog
import com.prilepskiy.myapplication.ui.base.viewBinding
import java.text.DateFormat
import java.util.*

class CaledarDialog() : BaseDialog<DialogCalendarBinding>() {
    override val binding: DialogCalendarBinding by viewBinding()
    var onDismissAction: () -> Unit = {}
    var onCancelAction: () -> Unit = {}
    var action: (i:String) -> Unit = {}

    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)
        onDismissAction()
    }

    override fun onCancel(dialog: DialogInterface) {
        super.onCancel(dialog)
        onCancelAction()
    }

    override fun onViewClick() {

        binding.btCalendarCansel.setOnClickListener {
            dismiss()
        }
        binding.btCalendarOk.setOnClickListener {
            val selectedDate = binding.calendarView.date
            val calendar = Calendar.getInstance()
            calendar.timeInMillis = selectedDate
            val dateFormatter = DateFormat.getDateInstance(DateFormat.MEDIUM)
            action(dateFormatter.format(calendar.time))
            dismiss()
        }
    }

}
