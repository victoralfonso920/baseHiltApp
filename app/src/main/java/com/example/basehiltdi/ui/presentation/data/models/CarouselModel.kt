package com.example.basehiltdi.ui.presentation.data.models

interface CarouselModel: Model {
    override val id: String
    val startEndPadding: Int
    val itemSpacing: Int
    val topBottomPadding: Int
}