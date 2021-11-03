package com.example.basehiltdi.ui.presentation.base.viewModel

import com.example.basehiltdi.ui.features.simple_list.epoxy.EventSimpleList
import com.example.basehiltdi.ui.presentation.utils.epoxy.base.EpoxyOnClickEvent
import com.example.basehiltdi.ui.presentation.utils.extensions.logv
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject

// Created by Victor Hernandez on 2/11/21.
// Proyect BaseHiltDi
//contact victoralfonso920@gmail.com
@Module
@InstallIn(SingletonComponent::class)
class EventListenerImpl @Inject constructor() : EventListener {
    override val event: (event: EpoxyOnClickEvent) -> Unit = { event ->
        when (event) {
            is EventSimpleList.showMessage -> "name ${event.name}".logv()
            else -> { "evento tipo $event".logv()
            }
        }
    }
}