package com.example.basehiltdi.ui.features.simple_list

import androidx.fragment.app.viewModels
import com.example.basehiltdi.R
import com.example.basehiltdi.databinding.FragmentSimpleListBinding
import com.example.basehiltdi.ui.presentation.base.list.BaseListFragment
import com.example.basehiltdi.ui.presentation.utils.extensions.liveDataObserver
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SimpleListFragment() : BaseListFragment<FragmentSimpleListBinding>() {

    override val viewLayout: Int = R.layout.fragment_simple_list

    override val viewModel: SimpleListViewModel by viewModels()


    override fun setFragmentObservers() {
        super.setFragmentObservers()
        observerDataList()
    }

    private fun observerDataList(){
        liveDataObserver(viewModel.listLiveData){
            viewModel.setData(it)
        }
    }

}