package com.prilepskiy.myapplication.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import androidx.viewbinding.ViewBinding
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEach


abstract class FragmentBaseMVVM<ViewModel : BaseViewModel, ViewBind : ViewBinding> :
    Fragment() {

    abstract val viewModel: ViewModel
    abstract val binding: ViewBind

    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        navController = Navigation.findNavController(view)
        super.onViewCreated(view, savedInstanceState)
        onEach()
        onView()
        onViewClick()
    }



    protected open fun onView() {}

    protected open fun onViewClick() {}

    protected open fun onEach() {}
    protected fun popBackStack() {
        navController.popBackStack()
    }

    protected fun popBackStack(destinationId: Int) {
        navController.popBackStack(destinationId,true)
    }

    protected fun navigateFragment(destinationId: Int, arg: Bundle? = null) {
        navController.navigate(destinationId, arg)
    }

    protected fun navigateFragment(destinations: NavDirections) {
        navController.navigate(destinations)
    }

    protected inline fun <reified T> onEach(flow: Flow<T>, crossinline action: (T) -> Unit) = view?.run {
        if (!this@FragmentBaseMVVM.isAdded) return@run
        flow.onEach { action(it ?: return@onEach) }.observeInLifecycle(viewLifecycleOwner)
    }

}