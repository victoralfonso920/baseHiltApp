package com.example.basehiltdi.ui.presentation.utils.epoxy.base

import com.airbnb.epoxy.TypedEpoxyController
import com.example.basehiltdi.title
import com.example.basehiltdi.ui.features.simple_list.data.TitleModel
import com.example.basehiltdi.ui.features.simple_list.epoxy.EventSimpleList
import com.example.basehiltdi.ui.presentation.base.viewModel.EventListener
import com.example.basehiltdi.ui.presentation.data.models.Model
import com.example.basehiltdi.ui.presentation.data.models.SkeletonModel
import com.example.basehiltdi.ui.presentation.utils.epoxy.addSkeletonModels


abstract class BaseEpoxyController : TypedEpoxyController<List<Model>>() {

    abstract val eventListener: EventListener
    abstract fun buildModel(position: Int, model: Model)

    override fun buildModels(data: List<Model>?) {
        addSkeletonModels(data?.filterIsInstance<SkeletonModel>())
        mappingCommonModels(data)
    }

    override fun setFilterDuplicates(filterDuplicates: Boolean) {
        super.setFilterDuplicates(true)
    }

    private fun mappingCommonModels(data: List<Model>?) {
        data?.mapIndexed { index, model ->
            val id = if (model.id.isNotEmpty()) model.id else index.toString()
            when (model) {

                else -> buildModel(index, model)
            }
        }
    }

    fun <T : EpoxyOnClickEvent> launchEvent(event: T) = eventListener.event.invoke(event)
}