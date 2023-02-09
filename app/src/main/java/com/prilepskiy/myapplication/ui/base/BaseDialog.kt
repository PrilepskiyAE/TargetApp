package com.prilepskiy.myapplication.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.fragment.app.DialogFragment
import androidx.viewbinding.ViewBinding
import com.prilepskiy.myapplication.R


abstract class BaseDialog<ViewBind : ViewBinding> :
    DialogFragment() {


    abstract val binding: ViewBind


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onEach()
        onView()
        onViewClick()
    }


    protected open fun onView() {}

    protected open fun onViewClick() {}

    protected open fun onEach() {}

}