package com.example.basehiltdi.ui.features.detail


import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.basehiltdi.R
import com.example.basehiltdi.databinding.DetailFragmentBinding
import com.example.basehiltdi.ui.presentation.base.fragment.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment() : BaseFragment<DetailFragmentBinding>() {



    override val viewLayout: Int = R.layout.detail_fragment
    override val viewModel:  DetailViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

            viewModel.setNameScreen("Detalle")

    }


}