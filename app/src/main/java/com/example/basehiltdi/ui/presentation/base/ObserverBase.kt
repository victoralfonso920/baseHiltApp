package com.example.basehiltdi.ui.presentation.base

// Created by Victor Hernandez on 25/8/21.
// Proyect BaseHiltDi
//contact victoralfonso920@gmail.com

interface ObserverBase {
    fun setObservers() {}
    fun setAdditionalObservers() {}
    fun setFragmentObservers() {}
    fun setActivityObservers() {}
    fun setRecyclerObserver() {}

}