package com.example.basehiltdi.features.ui.home



import androidx.fragment.app.viewModels
import com.example.basehiltdi.R
import com.example.basehiltdi.databinding.HomeFragmentBinding
import com.example.basehiltdi.presentation.base.ui.fragment.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment(): BaseFragment<HomeFragmentBinding>(HomeFragmentBinding::inflate) {


    override val viewLayout: Int = R.layout.home_fragment
    override val viewModel: HomeViewModel by viewModels()

}