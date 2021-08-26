package com.example.basehiltdi.ui.features.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.basehiltdi.ui.base.viewModel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor() : BaseViewModel() {

    private val nameLiveData = MutableLiveData<String>()

    val name :LiveData<String>
    get() = nameLiveData

    fun setNameScreen(name:String){
        nameLiveData.value = name
    }
}