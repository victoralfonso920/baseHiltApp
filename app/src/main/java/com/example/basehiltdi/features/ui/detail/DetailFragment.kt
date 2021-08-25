package com.example.basehiltdi.features.ui.detail


import androidx.fragment.app.viewModels
import com.example.basehiltdi.R
import com.example.basehiltdi.databinding.DetailFragmentBinding
import com.example.basehiltdi.presentation.base.ui.fragment.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : BaseFragment<DetailFragmentBinding>(DetailFragmentBinding::inflate) {

    override val viewLayout: Int = R.layout.detail_fragment
    override val viewModel: DetailViewModel by viewModels()

}