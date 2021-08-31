package com.example.basehiltdi.ui.features.detail


import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.basehiltdi.R
import com.example.basehiltdi.databinding.DetailFragmentBinding
import com.example.basehiltdi.ui.base.ui.fragment.BaseFragment
import com.example.basehiltdi.ui.base.utils.logv
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : BaseFragment<DetailFragmentBinding>(DetailFragmentBinding::inflate) {

    val args:DetailFragmentArgs by navArgs()

    override val viewLayout: Int = R.layout.detail_fragment
    override val viewModel: DetailViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        args.toString().logv()
        args.name?.let {
            viewModel.setNameScreen(it)
        }

    }


}