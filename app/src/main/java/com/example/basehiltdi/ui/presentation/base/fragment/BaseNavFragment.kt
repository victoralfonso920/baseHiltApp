package com.example.basehiltdi.ui.presentation.base.fragment

import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.example.basehiltdi.ui.presentation.base.ObserverBase
import com.example.basehiltdi.ui.presentation.base.viewModel.BaseViewModel
import com.example.basehiltdi.ui.presentation.utils.extensions.hideKeyboard
import com.example.basehiltdi.ui.presentation.utils.extensions.liveDataObserver

// Created by Victor Hernandez on 25/8/21.
// Proyect BaseHiltDi
//contact victoralfonso920@gmail.com

abstract class BaseNavFragment : Fragment(), ObserverBase {

    protected abstract val viewModel: BaseViewModel


    protected val onClickPopBackStack: (View) -> Unit = {
        viewModel.popBackStack()
    }

    override fun setObservers() {
        setNavigationObserver()
    }

    private fun setNavigationObserver() {
        view?.hideKeyboard()

        liveDataObserver(viewModel.getNavigationLiveData()) { direction ->
            findNavController().navigate(direction)
        }

        liveDataObserver(viewModel.getNavigationId()) { model ->
            findNavController().navigate(model.id,model.data)
        }

        liveDataObserver(viewModel.getPopBackStackWithDirectionLiveData()) { direction ->
            findNavController().popBackStack(direction, true)
        }

        liveDataObserver(viewModel.getPopBackStackLiveData()) {
            setFragmentNavigationResult()
            findNavController().popBackStack()
        }

        liveDataObserver(viewModel.getNavigationHomeLiveData()) { direction ->
            findNavController().navigate(direction, null, NavOptions.Builder().setPopUpTo(direction, true).build())
        }
    }

    open fun setFragmentNavigationResult() {
    }

}