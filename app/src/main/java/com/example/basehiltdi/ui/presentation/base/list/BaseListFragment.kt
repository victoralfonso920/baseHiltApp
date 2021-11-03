/*
 * Create by Byron Solorzano on 27/1/2020.
 *
 * Copyright (c) 2020 Byron Solorzano.
 * All rights reserved.
 */

package com.example.basehiltdi.ui.presentation.base.list

import androidx.databinding.ViewDataBinding
import com.example.basehiltdi.BR
import com.example.basehiltdi.ui.presentation.base.list.vmList.ListViewModel
import com.example.basehiltdi.ui.presentation.data.models.Model
import com.example.basehiltdi.ui.presentation.utils.extensions.liveDataObserver


abstract class BaseListFragment<LB : ViewDataBinding>(): ListFragment<LB>() {

    abstract override val viewModel: ListViewModel



    override fun setBindingVariables() {
        super.setBindingVariables()
        binding.setVariable(BR.recyclerController, viewModel.listController)
    }

    override fun setObserveList(isSnapshot: Boolean) {
        super.setObserveList(isSnapshot)
        liveDataObserver(viewModel.listLiveData) { models ->
            setList(models)
        }
    }

    override fun showSkeleton() {
        super.showSkeleton()
        setList(viewModel.getSkeletons())
    }

    private fun setList(list: List<Model>) {
        viewModel.listController.setData(list)
    }
}
