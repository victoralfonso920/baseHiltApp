package com.example.basehiltdi.ui.presentation.utils.epoxy.models


import android.view.ViewGroup
import android.widget.*
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.forEach
import androidx.databinding.ViewDataBinding
import com.airbnb.epoxy.DataBindingEpoxyModel
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.example.basehiltdi.R
import com.example.basehiltdi.ui.presentation.utils.extensions.getResourceColor
import com.example.basehiltdi.ui.presentation.utils.extensions.getResourceDrawable
import com.google.android.material.imageview.ShapeableImageView
import de.hdodenhof.circleimageview.CircleImageView


@EpoxyModelClass
abstract class SkeletonModel : DataBindingEpoxyModel() {

    @EpoxyAttribute
    var viewLayout = 0

    private val texts = mutableMapOf<Any, String>()

    override fun getDefaultLayout(): Int = viewLayout

    override fun setDataBindingVariables(binding: ViewDataBinding?) = Unit

    override fun bind(holder: DataBindingHolder) {
        val view = holder.dataBinding.root
        val skeletonColor = R.color.silver

        if (view is ViewGroup) {
            setViewBackgroundColor(view, skeletonColor)
        }
    }

    override fun unbind(holder: DataBindingHolder) {
        val view = holder.dataBinding.root
        if (view is ViewGroup) {
            setViewBackgroundColor(view, null)
        }
    }

    private fun setViewBackgroundColor(viewGroup: ViewGroup, color: Int?) {
        val isEnabled = color == null
        viewGroup.isEnabled = isEnabled
        val resource = color ?: R.color.transparent
        viewGroup.forEach { view ->
            when (view) {
                is ConstraintLayout, is CardView, is FrameLayout, is LinearLayout, is RelativeLayout -> {
                    if(view is ViewGroup) setViewBackgroundColor(view, color)
                }
                is CircleImageView, is ShapeableImageView -> {
                    if (view is ImageView)
                        view.setImageDrawable(view.context.getResourceDrawable(resource))
                }
                else ->  {
                    view.setBackgroundColor(view.context.getResourceColor(resource))
                    if(view is TextView) {
                        if (color != null) {
                            texts[view.id] = view.text.toString()
                            view.text = ""
                        } else {
                            view.text = texts[view.id]
                        }
                    }
                }
            }
        }
    }
}
