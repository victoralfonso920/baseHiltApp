package com.example.basehiltdi.ui.features.home

import android.os.Bundle
import com.example.basehiltdi.R
import com.example.basehiltdi.domain.repos.HomeRepository
import com.example.basehiltdi.ui.base.data.models.ModelNavigation
import com.example.basehiltdi.ui.base.viewModel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    val repo:HomeRepository
) : BaseViewModel() {

   fun navigateToDetail(name:String){
       val bundle = Bundle()
       bundle.putString("name",name)
      val model = ModelNavigation(
           R.id.to_detailFragment,
           bundle
       )
       navigateToID(model)

   }
}