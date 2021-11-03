package com.example.basehiltdi.ui.features.home

import android.os.Bundle
import androidx.lifecycle.LiveData
import com.example.basehiltdi.R
import com.example.basehiltdi.domain.repos.HomeRepository
import com.example.basehiltdi.ui.presentation.data.models.ModelNavigation
import com.example.basehiltdi.ui.presentation.base.viewModel.BaseViewModel
import com.example.basehiltdi.ui.presentation.data.models.Model
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    val repo:HomeRepository
) : BaseViewModel() {

   fun navigateToDetail(){
       navigateTo(HomeFragmentDirections.toDetailFragment())
   }

    fun navigateToList(){
        navigateTo(HomeFragmentDirections.toSimpleListFragment())
    }
}