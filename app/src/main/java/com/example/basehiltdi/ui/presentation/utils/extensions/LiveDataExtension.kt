package com.example.basehiltdi.ui.presentation.utils.extensions

import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

inline fun <T> Fragment.liveDataObserver(liveData: LiveData<T>?, crossinline func: (T) -> (Unit)) {
    liveData?.observe(viewLifecycleOwner, Observer { t -> func(t) })
}
