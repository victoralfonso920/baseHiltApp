package com.example.basehiltdi.ui.base.ui.fragment

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.example.basehiltdi.BR
import com.example.basehiltdi.R
import com.example.basehiltdi.ui.base.utils.liveDataObserver
import com.example.basehiltdi.ui.base.utils.snackbar

// Created by Victor Hernandez on 25/8/21.
// Proyect BaseHiltDi
//contact victoralfonso920@gmail.com

typealias Inflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T

abstract class BaseFragment<LB : ViewDataBinding>(
    private val inflate: Inflate<LB>
): BaseNavFragment() {

    private var _binding: LB? = null
    protected abstract val viewLayout: Int


    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater,viewLayout, container, false)
        setBindingVariables()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setSnackbarObserver()
        setBaseFunctions()
    }

    open fun setBaseFunctions() {
        setStatusBarColor()
        setObservers()
    }

    open fun setStatusBarColor(updateColor: Boolean = true, color: Int = R.color.white) { // Change by R.color.colorPrimary when all app is migrated a Single Activity
        if (updateColor) {
            with(requireActivity()) {
                window.statusBarColor = ContextCompat.getColor(
                    requireContext(),
                    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
                        color
                    } else {
                        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
                        color
                    }
                )
            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    open fun setBindingVariables() {
        binding.lifecycleOwner = viewLifecycleOwner
        binding.setVariable(BR.viewModel, viewModel)
    }

    private fun setSnackbarObserver() {
        liveDataObserver(viewModel?.snackbarErrorMessageLiveData) { message ->
            binding.root.snackbar(getString(message), true)
        }
        liveDataObserver(viewModel?.snackbarSuccessMessageLiveData) { message ->
            binding.root.snackbar(getString(message))
        }
    }

    override fun setObservers() {
        super.setObservers()
        setAdditionalObservers()
        setFragmentObservers()
        setSnackbarObserver()
    }



}