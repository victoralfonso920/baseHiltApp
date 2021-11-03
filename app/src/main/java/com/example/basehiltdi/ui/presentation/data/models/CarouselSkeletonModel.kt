package com.example.basehiltdi.ui.presentation.data.models

data class CarouselSkeletonModel(
    override val id: String = "",
    override val startEndPadding: Int = 0,
    override val itemSpacing: Int = 0,
    override val topBottomPadding: Int = 0
): CarouselModel
