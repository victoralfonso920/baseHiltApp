package com.example.basehiltdi.ui.presentation.utils.epoxy.base

sealed class EpoxyCommonEvents : EpoxyOnClickEvent {
    data class FilterEvent(
        val id: String,
        val currentSelected: Boolean
    ) : EpoxyCommonEvents()
    data class PillEvent(
        val id: String,
        val value: String,
        val currentSelected: Boolean
    ) : EpoxyCommonEvents()
    object GeneralButton : EpoxyCommonEvents()
    data class SelectOptionTitle(val type: String) : EpoxyCommonEvents()
}
