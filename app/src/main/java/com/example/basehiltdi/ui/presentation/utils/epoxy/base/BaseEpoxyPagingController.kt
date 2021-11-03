package com.example.basehiltdi.ui.presentation.utils.epoxy.base

import androidx.paging.PagedList
import com.airbnb.epoxy.EpoxyModel
import com.airbnb.epoxy.paging.PagedListEpoxyController
import com.example.basehiltdi.LoadingBindingModel_
import com.example.basehiltdi.ui.presentation.base.viewModel.EventListener
import com.example.basehiltdi.ui.presentation.data.models.Model
import com.example.basehiltdi.ui.presentation.data.models.SkeletonModel
import com.example.basehiltdi.ui.presentation.utils.epoxy.addSkeletonModels


abstract class BaseEpoxyPagingController: PagedListEpoxyController<Model>() {

    abstract val eventListener: EventListener
    private var isShowLoading = false
    private var skeletons: List<SkeletonModel>? = null
    private var isShowPreviousSkeleton: Boolean = false

    override fun setFilterDuplicates(filterDuplicates: Boolean) {
        super.setFilterDuplicates(true)
    }

    override fun addModels(models: List<EpoxyModel<*>>) {
        val isAvailableShowSkeleton = models.isNullOrEmpty() && !isShowPreviousSkeleton

        if (isAvailableShowSkeleton) {
            addSkeletonModels(skeletons)
            isShowPreviousSkeleton = true
            return
        }
        super.addModels(models.distinct())
        LoadingBindingModel_()
            .id("loading")
            .addIf(!isShowLoading, this)
    }

    fun customSubmitList(pagedList: PagedList<Model>?) {
        skeletons = pagedList?.filterIsInstance<SkeletonModel>()
        submitList(pagedList)
    }

    @Suppress("UNCHECKED_CAST")
    fun setSkeletons(list: List<Model>) {
        if (list.isNotEmpty()) skeletons = list as List<SkeletonModel>
        isShowPreviousSkeleton = false
    }

    fun endReached(isEndReached: Boolean) {
        this.isShowLoading = isEndReached
        requestModelBuild()
    }

    fun <T : EpoxyOnClickEvent> launchEvent(event: T) = eventListener.event.invoke(event)
}