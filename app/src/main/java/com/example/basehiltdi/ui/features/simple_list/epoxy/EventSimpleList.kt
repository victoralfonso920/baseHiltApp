package com.example.basehiltdi.ui.features.simple_list.epoxy

import com.example.basehiltdi.ui.presentation.utils.epoxy.base.EpoxyOnClickEvent

// Created by Victor Hernandez on 2/11/21.
// Proyect BaseHiltDi
//contact victoralfonso920@gmail.com

sealed class EventSimpleList : EpoxyOnClickEvent {
    data class showMessage(val name:String) : EventSimpleList()
}
