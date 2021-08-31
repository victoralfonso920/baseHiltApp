package com.example.basehiltdi.ui.features.home



import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.basehiltdi.R
import com.example.basehiltdi.databinding.HomeFragmentBinding
import com.example.basehiltdi.ui.base.ui.fragment.BaseFragment
import com.example.basehiltdi.ui.base.utils.logv
import com.example.basehiltdi.ui.features.detail.DetailFragmentArgs
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment(): BaseFragment<HomeFragmentBinding>(HomeFragmentBinding::inflate) {

    override val viewLayout: Int = R.layout.home_fragment
    override val viewModel: HomeViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.name = "Home Fragment"

    }

}