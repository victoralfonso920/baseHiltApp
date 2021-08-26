package com.example.basehiltdi.ui.features.detail


import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.basehiltdi.R
import com.example.basehiltdi.databinding.DetailFragmentBinding
import com.example.basehiltdi.ui.base.ui.fragment.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : BaseFragment<DetailFragmentBinding>(DetailFragmentBinding::inflate) {

    private val arg:DetailFragmentArgs by navArgs()

    override val viewLayout: Int = R.layout.detail_fragment
    override val viewModel: DetailViewModel by viewModels()


    override fun setAdditionalObservers() {
       viewModel.setNameScreen(arg.nameLastScreen)
    }

}