package com.example.basehiltdi.ui.presentation.base.list.vmList

import androidx.lifecycle.LiveData
import com.example.basehiltdi.ui.presentation.base.viewModel.EventListener
import com.example.basehiltdi.ui.presentation.data.models.Model
import com.example.basehiltdi.ui.presentation.utils.epoxy.base.BaseEpoxyController

abstract class ListViewModel : BaseListViewModel(), EventListener {
    abstract val listLiveData: LiveData<List<Model>>
    abstract val listController: BaseEpoxyController

}
