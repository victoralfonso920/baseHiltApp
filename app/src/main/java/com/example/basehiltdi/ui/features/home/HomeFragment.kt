package com.example.basehiltdi.ui.features.home



import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.basehiltdi.R
import com.example.basehiltdi.databinding.HomeFragmentBinding
import com.example.basehiltdi.ui.presentation.base.fragment.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment(): BaseFragment<HomeFragmentBinding>() {

    override val viewLayout: Int = R.layout.home_fragment
    override val viewModel: HomeViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.name = "Home Fragment"

    }

}