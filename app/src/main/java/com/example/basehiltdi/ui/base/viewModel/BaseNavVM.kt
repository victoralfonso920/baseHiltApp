package com.example.basehiltdi.ui.base.viewModel

import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import com.example.basehiltdi.ui.base.utils.SingleLiveEvent

// Created by Victor Hernandez on 25/8/21.
// Proyect BaseHiltDi
//contact victoralfonso920@gmail.com

abstract class BaseNavVM : ViewModel() {
    private val navigation: SingleLiveEvent<NavDirections> = SingleLiveEvent()
    private val navigationBackStackWithDirection: SingleLiveEvent<Int> = SingleLiveEvent()
    private val navigationBackStack: SingleLiveEvent<Boolean> = SingleLiveEvent()
    private val navigationHome: SingleLiveEvent<Int> = SingleLiveEvent()

    fun getNavigationLiveData(): SingleLiveEvent<NavDirections> = navigation
    fun getNavigationHomeLiveData(): SingleLiveEvent<Int> = navigationHome
    fun getPopBackStackWithDirectionLiveData(): SingleLiveEvent<Int> = navigationBackStackWithDirection
    fun getPopBackStackLiveData(): SingleLiveEvent<Boolean> = navigationBackStack

    fun navigateTo(direction: NavDirections) {
        navigation.postValue(direction)
    }
    fun navigateHome(direction: Int) {
        navigationHome.postValue(direction)
    }

    fun popBackStackWithDirection(direction: Int) {
        navigationBackStackWithDirection.postValue(direction)
    }

    fun popBackStack() {
        navigationBackStack.postValue(true)
    }
}
