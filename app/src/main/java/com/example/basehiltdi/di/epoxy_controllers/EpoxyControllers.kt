package com.example.basehiltdi.di.epoxy_controllers

import com.example.basehiltdi.ui.features.simple_list.epoxy.SimpleListEpoxyController
import com.example.basehiltdi.ui.presentation.base.viewModel.EventListenerImpl
import com.example.basehiltdi.ui.presentation.base.viewModel.EventListener
import com.example.basehiltdi.ui.presentation.utils.epoxy.base.BaseEpoxyController
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

// Created by Victor Hernandez on 2/11/21.
// Proyect BaseHiltDi
//contact victoralfonso920@gmail.com

@Module
@InstallIn(SingletonComponent::class)
object EpoxyControllers {
    @Provides
    @Singleton
    fun provideEventListener() : EventListener{
        return EventListenerImpl()
    }

    @Provides
    @Singleton
    fun provideSimpleListEpoxyController(event:EventListener) : BaseEpoxyController =
         SimpleListEpoxyController(event)


}