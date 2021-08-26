package com.example.basehiltdi.ui.base.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import com.example.basehiltdi.R
import com.example.basehiltdi.ui.base.data.vo.Resource
import com.example.basehiltdi.ui.base.utils.SingleLiveEvent
import com.example.basehiltdi.ui.base.utils.logv
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect



// Created by Victor Hernandez on 25/8/21.
// Proyect BaseHiltDi
//contact victoralfonso920@gmail.com

abstract class BaseViewModel : BaseNavVM() {

    val snackbarErrorMessageLiveData = SingleLiveEvent<Int>()
    val snackbarSuccessMessageLiveData = SingleLiveEvent<Int>()

    private val loading = MutableLiveData<Boolean>()
    fun getLoading(): LiveData<Boolean> = loading

    init {
        loading.value = false
    }
    fun <T> safeApiCall(
        apiCall: suspend () -> Flow<T>
    ) = liveData {
        loading.value = true
        apiCall.invoke()
            .catch {
                loading.value = false
                it.message?.logv()
                emit(Resource.Error(it.message.orEmpty()))
            }
            .collect {
                loading.value = false
                emit(Resource.Success(it))
            }
    }

    fun setSnackbarMessage(message: Int = R.string.error_request, isError: Boolean = true) {
        if (isError) {
            snackbarErrorMessageLiveData.postValue(message)
            return
        }
        snackbarSuccessMessageLiveData.postValue(message)
    }
}
