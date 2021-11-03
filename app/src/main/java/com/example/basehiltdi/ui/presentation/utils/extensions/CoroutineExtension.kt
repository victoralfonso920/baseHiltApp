package com.example.basehiltdi.ui.presentation.utils.extensions

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.coroutineScope
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

fun ViewModel.launchRequest(action: suspend () -> Unit) {

    viewModelScope.launch {
        withContext(Dispatchers.IO) {
            action.invoke()
        }
    }
}

fun Fragment.launch(action: suspend () -> Unit) {

    viewLifecycleOwner.lifecycle.coroutineScope.launch {
        withContext(Dispatchers.Main) {
            action.invoke()
        }
    }
}
