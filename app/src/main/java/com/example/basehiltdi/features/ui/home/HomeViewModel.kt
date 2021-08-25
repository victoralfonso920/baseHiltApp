package com.example.basehiltdi.features.ui.home

import com.example.basehiltdi.domain.repos.HomeRepository
import com.example.basehiltdi.presentation.base.viewModel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import javax.inject.Singleton


@HiltViewModel
class HomeViewModel @Inject constructor(
    val repo:HomeRepository
) : BaseViewModel() {

   fun navigateToDetail(){
       navigateTo(HomeFragmentDirections.toDetailFragment())
   }
}