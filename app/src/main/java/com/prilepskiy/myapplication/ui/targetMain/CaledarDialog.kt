package com.prilepskiy.myapplication.ui.targetMain

import android.content.DialogInterface
import android.util.Log
import androidx.core.view.get
import com.prilepskiy.myapplication.databinding.DialogCalendarBinding
import com.prilepskiy.myapplication.ui.base.BaseDialog
import com.prilepskiy.myapplication.ui.base.viewBinding
import java.text.DateFormat
import java.util.*

class CaledarDialog() : BaseDialog<DialogCalendarBinding>() {
    override val binding: DialogCalendarBinding by viewBinding()
    var onDismissAction: () -> Unit = {}
    var onCancelAction: () -> Unit = {}
    var action: (i: String) -> Unit = {}

    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)
        onDismissAction()
    }

    override fun onCancel(dialog: DialogInterface) {
        super.onCancel(dialog)
        onCancelAction()
    }

    override fun onViewClick() {
        var d:String=""
        var m:String=""
        var y:String=""

        //var selectedDate //= binding.calendarView.date
        binding.calendarView.setOnDateChangeListener { calendarView, i, i2, i3 ->
            Log.d("TAG", "onViewClick:$i ")
            Log.d("TAG", "onViewClick:$i2 ")
            Log.d("TAG", "onViewClick:$i3")
            Log.d("TAG", "onViewClick:${calendarView.dateTextAppearance}")
            y=i.toString()

            m = (if (i2+1>9)(i2+1).toString() else{"0${(i2+1)}"})

            d=i3.toString()

        }
        binding.btCalendarCansel.setOnClickListener {
            dismiss()
        }
        binding.btCalendarOk.setOnClickListener {

            if(d.isNotEmpty() && m.isNotEmpty() && y.isNotEmpty())
            action("$d.$m.$y")
            else{
                val selectedDate = binding.calendarView.date
                val calendar = Calendar.getInstance()
                calendar.timeInMillis = selectedDate
                val dateFormatter = DateFormat.getDateInstance(DateFormat.DATE_FIELD)
                action(dateFormatter.format(calendar.time))
            }
            dismiss()
        }
    }

}
