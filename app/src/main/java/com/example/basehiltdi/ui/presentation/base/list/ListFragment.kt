package com.example.basehiltdi.ui.presentation.base.list

import androidx.databinding.ViewDataBinding
import com.example.basehiltdi.ui.presentation.base.fragment.BaseFragment
import com.example.basehiltdi.ui.presentation.base.list.vmList.ListViewModel
import com.example.basehiltdi.ui.presentation.utils.extensions.liveDataObserver


abstract class ListFragment<LB : ViewDataBinding>() : BaseFragment<LB>() {

    abstract override val viewModel: ListViewModel

    protected val lazyViewModel = lazy { viewModel }
    private var isShowPreviousSkeleton: Boolean = false

    override fun setBaseFunctions() {
        super.setBaseFunctions()
        if (!isShowPreviousSkeleton) showSkeleton()
    }

    override fun setRecyclerObserver() {
        setObserveList()
    }

    open fun setObserveList(isSnapshot: Boolean = false) {
        liveDataObserver(viewModel.callSkeletonLiveData) {
            isShowPreviousSkeleton = false
            showSkeleton()
        }
    }

    open fun showSkeleton() {
        isShowPreviousSkeleton = true
    }
}
