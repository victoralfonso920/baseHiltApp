package com.example.basehiltdi.ui.features.home

import com.example.basehiltdi.domain.repos.HomeRepository
import com.example.basehiltdi.ui.base.viewModel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    val repo:HomeRepository
) : BaseViewModel() {

   fun navigateToDetail(name:String){
       navigateTo(HomeFragmentDirections.toDetailFragment(name))
   }
}