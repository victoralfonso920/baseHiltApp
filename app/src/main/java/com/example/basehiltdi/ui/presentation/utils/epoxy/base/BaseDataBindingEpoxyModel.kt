package com.example.basehiltdi.ui.presentation.utils.epoxy.base

import android.view.View
import androidx.databinding.ViewDataBinding
import com.airbnb.epoxy.DataBindingEpoxyModel
import com.airbnb.epoxy.EpoxyAttribute
import com.example.basehiltdi.BR

abstract class BaseDataBindingEpoxyModel : DataBindingEpoxyModel() {

    override fun shouldSaveViewState(): Boolean = true

    @EpoxyAttribute(EpoxyAttribute.Option.DoNotHash)
    var onClickListener: View.OnClickListener? = null

    override fun setDataBindingVariables(binding: ViewDataBinding?) {
        binding?.setVariable(BR.onClickListener, onClickListener)
    }
}
