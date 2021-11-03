package com.example.basehiltdi.ui.features.simple_list.epoxy

import com.example.basehiltdi.title
import com.example.basehiltdi.ui.features.simple_list.data.TitleModel
import com.example.basehiltdi.ui.presentation.base.viewModel.EventListener
import com.example.basehiltdi.ui.presentation.data.models.Model
import com.example.basehiltdi.ui.presentation.utils.epoxy.base.BaseEpoxyController

import javax.inject.Inject


class SimpleListEpoxyController
@Inject constructor(
    override val eventListener: EventListener
) : BaseEpoxyController() {
    override fun buildModel(position: Int, model: Model) {

        when(model){
            is TitleModel -> {
                title {
                    id(model.id)
                    model(model)
                    onClickListener { model, _, _, _ ->
                        this@SimpleListEpoxyController.launchEvent(EventSimpleList.showMessage(model.model().title))
                    }
                }
            }
        }


    }
}