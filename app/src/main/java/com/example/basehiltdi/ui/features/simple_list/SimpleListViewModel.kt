package com.example.basehiltdi.ui.features.simple_list

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.basehiltdi.R
import com.example.basehiltdi.ui.features.simple_list.data.TitleModel
import com.example.basehiltdi.ui.features.simple_list.epoxy.EventSimpleList
import com.example.basehiltdi.ui.features.simple_list.epoxy.SimpleListEpoxyController
import com.example.basehiltdi.ui.presentation.base.list.vmList.ListViewModel
import com.example.basehiltdi.ui.presentation.data.models.Model
import com.example.basehiltdi.ui.presentation.data.models.SkeletonModel
import com.example.basehiltdi.ui.presentation.utils.ResourceManager
import com.example.basehiltdi.ui.presentation.utils.ResourceManager_Factory
import com.example.basehiltdi.ui.presentation.utils.epoxy.base.BaseEpoxyController
import com.example.basehiltdi.ui.presentation.utils.epoxy.base.EpoxyOnClickEvent
import com.example.basehiltdi.ui.presentation.utils.extensions.logv
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import javax.inject.Inject

@HiltViewModel
class SimpleListViewModel  @Inject constructor(
    override val listController: BaseEpoxyController,
    private val resource:ResourceManager
): ListViewModel() {

    override val listLiveData: LiveData<List<Model>> = liveData {
        val list: List<Model> = arrayListOf(
                TitleModel("T_01", "This"),
                TitleModel("T_02", "is"),
                TitleModel("T_03", "a"),
                TitleModel("T_04", "simple"),
                TitleModel("T_05", "example"),
                TitleModel("T_06", "epoxy"),
                TitleModel("T_07", "list")
        )
        delay(3000)
        emit(list)
    }

    override fun getSkeletons(): List<Model> {
        return listOf(SkeletonModel(viewLayout = R.layout.item_title, itemRepeat = 7))
    }

    fun setData(list:List<Model>){
        listController.setData(list)
    }

    override val event: (event: EpoxyOnClickEvent) -> Unit = { event ->
        when (event) {
            is EventSimpleList.showMessage -> "name ${event.name}".logv()
            else -> { "evento tipo $event".logv()
            }
        }
    }

}