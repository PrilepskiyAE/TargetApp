package com.prilepskiy.myapplication.ui.base
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.prilepskiy.myapplication.ui.targetMain.CaledarDialog
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEach

abstract class FragmentBaseMVVM <ViewModel : BaseViewModel, ViewBind : ViewBinding> :
    Fragment() {

    abstract val viewModel: ViewModel
    abstract val binding: ViewBind

    private var calendarDialog: CaledarDialog? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onEach()
        onView()
        onViewClick()
    }

    fun showCalendarDialog( action: (i:String) -> Unit){
        calendarDialog = CaledarDialog()
        calendarDialog?.action={
            action(it)
            calendarDialog!!.dismiss()
        }
        calendarDialog?.onDismissAction={
            calendarDialog=null
        }

        try {
            if (!calendarDialog!!.isVisible && !calendarDialog!!.isAdded)
                calendarDialog!!.show(childFragmentManager, "CALENDAR_DIALOG_TAG")
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    protected open fun onView() {}

    protected open fun onViewClick() {}

    protected open fun onEach() {}



    protected inline fun <reified T> onEach(flow: Flow<T>, crossinline action: (T) -> Unit) = view?.run {
        if (!this@FragmentBaseMVVM.isAdded) return@run
        flow.onEach { action(it ?: return@onEach) }.observeInLifecycle(viewLifecycleOwner)
    }

}