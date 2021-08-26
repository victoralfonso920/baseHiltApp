package com.example.basehiltdi.ui.base.utils

import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData

// Created by Victor Hernandez on 25/8/21.
// Proyect BaseHiltDi
//contact victoralfonso920@gmail.com

inline fun <T> Fragment.liveDataObserver(liveData: LiveData<T>?, crossinline func: (T) -> (Unit)) {
    liveData?.observe(viewLifecycleOwner, { observer -> func(observer) })
}
