package com.example.basehiltdi.ui.presentation.utils.extensions


import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.example.basehiltdi.ui.presentation.base.viewModel.BaseViewModel
import com.example.basehiltdi.ui.presentation.data.models.Model

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map

fun <M : Model, F : Model> Flow<F>.mapNewModel(type: Class<M>): Flow<M> {
    return map { model ->
        model.asNewModel(type)
    }
}

fun <M : Model, F : Any> Flow<List<F>>.mapNewArrayModel(type: Class<Array<M>>): Flow<List<M>> {
    return map { model ->
        model.asNewArrayModel(type)
    }
}

fun <F : Any> Flow<F>.snackbarCatch(viewModel: BaseViewModel, message: Int ): Flow<F> {
    return catch {
        viewModel.setSnackbarMessage(message)
        viewModel.endLoadingRequest()
    }
}

suspend inline fun <F : Any> Flow<F>.safeCollect(crossinline func: suspend (value: F) -> Unit) {
    return catch { cause -> cause.message?.logv() }.collect { t -> func(t) }
}

fun <F : Any> Flow<F>.safeAsLiveData(): LiveData<F> {
    return catch { cause -> cause.message?.logv() }.asLiveData(Dispatchers.IO)
}


