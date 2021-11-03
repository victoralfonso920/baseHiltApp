/*
 * Create by Byron Solorzano on 27/1/2020.
 *
 * Copyright (c) 2020 Byron Solorzano.
 * All rights reserved.
 */

package com.example.basehiltdi.ui.presentation.base.list.vmList

import com.example.basehiltdi.ui.presentation.base.viewModel.BaseViewModel
import com.example.basehiltdi.ui.presentation.base.viewModel.EventListener
import com.example.basehiltdi.ui.presentation.data.models.Model
import com.example.basehiltdi.ui.presentation.data.models.SkeletonModel
import com.example.basehiltdi.ui.presentation.utils.SingleLiveEvent
import com.example.basehiltdi.ui.presentation.utils.epoxy.base.EpoxyOnClickEvent


abstract class BaseListViewModel : BaseViewModel(), EventListener {

    val callSkeletonLiveData = SingleLiveEvent<Boolean>()

    open fun getSkeletons(): List<Model> = emptyList()

    protected fun getHorizontalSkeletonModel(
        viewLayout: Int,
        repeat: Int,
        startEndPadding: Int = 0,
        itemSpacing: Int = 0
    ) = SkeletonModel(
        viewLayout = viewLayout,
        itemRepeat = repeat,
        isVerticalOrientation = false,
        startEndPadding = startEndPadding,
        itemSpacing = itemSpacing
    )

    override val event: (event: EpoxyOnClickEvent) -> Unit = {
        throw IllegalArgumentException("Not Implemented")
    }
}
