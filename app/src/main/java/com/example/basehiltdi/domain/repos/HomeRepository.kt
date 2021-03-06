package com.example.basehiltdi.domain.repos

import com.example.basehiltdi.R
import com.example.basehiltdi.ui.presentation.utils.ResourceManager
import com.example.basehiltdi.ui.presentation.utils.extensions.logv
import javax.inject.Inject

// Created by Victor Hernandez on 25/8/21.
// Proyect BaseHiltDi
//contact victoralfonso920@gmail.com

class HomeRepository @Inject constructor(
    val manager: ResourceManager
){
    fun generateToast(){
        manager.resources.getString(R.string.app_name).logv()
    }
}