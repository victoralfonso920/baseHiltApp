package com.example.basehiltdi.ui.presentation.utils.bindingAdapters

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.content.res.TypedArray
import android.graphics.Color
import android.graphics.drawable.LayerDrawable
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.RoundRectShape
import android.os.Build
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import androidx.annotation.Dimension
import androidx.annotation.DrawableRes
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.navigation.findNavController
import com.example.basehiltdi.R
import com.example.basehiltdi.ui.presentation.data.models.CornerRadius
import com.example.basehiltdi.ui.presentation.data.models.ShadowModel
import com.example.basehiltdi.ui.presentation.utils.extensions.getResourceColor
import com.example.basehiltdi.ui.presentation.utils.extensions.makeGone
import com.example.basehiltdi.ui.presentation.utils.extensions.makeInvisible
import com.example.basehiltdi.ui.presentation.utils.extensions.makeVisible


@BindingAdapter("isVisible")
fun View.setIsVisible(isVisible: Boolean) {
    if (isVisible) makeVisible() else makeGone()
}

@BindingAdapter("isInvisible")
fun View.setIsInVisible(isInvisible: Boolean) {
    if (isInvisible) makeInvisible() else makeVisible()
}

@BindingAdapter("android:layout_height")
fun View.setLayoutHeight(@Dimension height: Int) {
    val params = layoutParams
    params.height = height
    layoutParams = params
}

@BindingAdapter("android:layout_width")
fun View.setLayoutWidth(@Dimension width: Int) {
    val params = layoutParams
    layoutParams.width = width
    layoutParams = params
}

@BindingAdapter(
    "android:layout_marginStart",
    "android:layout_marginEnd",
    "android:layout_marginTop",
    "android:layout_marginBottom"
)
fun View.setMargins(
    @Dimension start: Int,
    @Dimension end: Int,
    @Dimension top: Int,
    @Dimension bottom: Int
) {
    val params = layoutParams as ConstraintLayout.LayoutParams
    params.setMargins(start, top, end, bottom)
    layoutParams = params
}

@BindingAdapter("backgroundTint")
fun View.backgroundTint(tintId: Int) {
    backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(context, tintId))
}

@SuppressLint("ResourceType")
@BindingAdapter("setShadow")
fun View.setShadow(shadowProperties: TypedArray) {
    val shadowModel: ShadowModel

    with(shadowProperties) {
        shadowModel = ShadowModel(
            shadowColor = Color.argb(
                getInt(0, 0),
                getInt(1, 0),
                getInt(2, 0),
                getInt(3, 0)
            ),
            blur = getFloat(4, 0f),
            Dx = getFloat(5, 0f),
            Dy = getFloat(6, 0f),
            cornerRadius = CornerRadius(
                getDimension(7, 0f),
                getDimension(8, 0f),
                getDimension(9, 0f),
                getDimension(10, 0f)
            ),
            backgroundColor = getColor(11, R.color.transparent),
            layerInsetStart = getInt(12, 0),
            layerInsetEnd = getInt(13, 0),
            layerInsetBottom = getInt(14, 0),
            layerInsetTop = getInt(15, 0)
        )
        recycle()
    }

    val firstLayer = 0
    val outerRadius = FloatArray(8)

    outerRadius[0] = shadowModel.cornerRadius.topLeft
    outerRadius[1] = shadowModel.cornerRadius.topLeft
    outerRadius[2] = shadowModel.cornerRadius.topRight
    outerRadius[3] = shadowModel.cornerRadius.topRight
    outerRadius[4] = shadowModel.cornerRadius.bottomLeft
    outerRadius[5] = shadowModel.cornerRadius.bottomLeft
    outerRadius[6] = shadowModel.cornerRadius.bottomRight
    outerRadius[7] = shadowModel.cornerRadius.bottomRight

    val shapeDrawable = ShapeDrawable()
    shapeDrawable.paint.color = shadowModel.backgroundColor
    shapeDrawable.paint.setShadowLayer(
        shadowModel.blur,
        shadowModel.Dx,
        shadowModel.Dy,
        shadowModel.shadowColor
    )
    shapeDrawable.shape = RoundRectShape(outerRadius, null, null)

    when (Build.VERSION.SDK_INT) {
        in Build.VERSION_CODES.BASE..Build.VERSION_CODES.O_MR1 -> setLayerType(
            View.LAYER_TYPE_SOFTWARE,
            shapeDrawable.paint
        )
    }

    val drawable = LayerDrawable(arrayOf(shapeDrawable))
    drawable.setLayerInset(
        firstLayer,
        shadowModel.layerInsetStart,
        shadowModel.layerInsetTop,
        shadowModel.layerInsetEnd,
        shadowModel.layerInsetBottom
    )
    background = drawable
}

@BindingAdapter("isPopBackStackNavigation")
fun View.setPopBackStack(isNavigate: Boolean) {
    if (isNavigate) setOnClickListener { findNavController().popBackStack() }
}

@BindingAdapter("isActive", "activeColor", "inactiveColor")
fun View.backgroundColor(
    isActive: Boolean,
    activeColor: Int,
    inactiveColor: Int
) = backgroundColor(if (isActive) activeColor else inactiveColor)

@BindingAdapter("marginStart", "marginEnd")
fun View.setStartEndMargins(@DimenRes marginStart: Int, @DimenRes marginEnd: Int) {
    with(resources) {
        val lp = layoutParams as ViewGroup.MarginLayoutParams
        lp.marginStart = getDimensionPixelSize(marginStart)
        lp.marginEnd = getDimensionPixelSize(marginEnd)
        layoutParams = lp
    }
}

@BindingAdapter("android:background")
fun View.backgroundColor(@ColorRes color: Int) =
    setBackgroundColor(context.getResourceColor(color))

@BindingAdapter("android:background")
fun View.setBackgroundDrawable(@DrawableRes drawable: Int) = setBackgroundResource(drawable)

@BindingAdapter("android:backgroundTint")
fun View.setBackgroundTint(@ColorRes color: Int) {
    backgroundTintList = ContextCompat.getColorStateList(context, color)
}