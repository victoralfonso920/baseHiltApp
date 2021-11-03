package com.example.basehiltdi.di.tools_provider

import android.content.Context
import com.example.basehiltdi.ui.presentation.utils.ResourceManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

// Created by Victor Hernandez on 2/11/21.
// Proyect BaseHiltDi
//contact victoralfonso920@gmail.com

@Module
@InstallIn(SingletonComponent::class)
object ToolsProvider {
    @Provides
    @Singleton
    fun provideResources(@ApplicationContext appContext: Context) : ResourceManager = ResourceManager(appContext)

}