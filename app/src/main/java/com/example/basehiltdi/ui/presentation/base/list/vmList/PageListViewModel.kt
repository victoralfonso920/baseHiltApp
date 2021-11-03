package com.example.basehiltdi.ui.presentation.base.list.vmList

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.example.basehiltdi.ui.presentation.base.viewModel.EventListener
import com.example.basehiltdi.ui.presentation.data.models.Model
import com.example.basehiltdi.ui.presentation.utils.SingleLiveEvent


abstract class PageListViewModel : BaseListViewModel() {

    abstract val pageListLiveData: LiveData<PagedList<Model>>
    val isEndLoadedPageListLiveData = SingleLiveEvent<Boolean>()

    fun refresh() {
        callSkeletonLiveData.postValue(true)
        invalidateDataSource()
    }

    fun invalidateDataSource() {
        pageListLiveData.value?.dataSource?.invalidate()
    }
}

