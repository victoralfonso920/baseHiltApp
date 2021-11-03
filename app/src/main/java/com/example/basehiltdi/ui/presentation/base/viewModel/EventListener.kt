package com.example.basehiltdi.ui.presentation.base.viewModel

import com.example.basehiltdi.ui.presentation.utils.epoxy.base.EpoxyOnClickEvent

interface EventListener {
    val event: (event: EpoxyOnClickEvent) -> Unit
}
