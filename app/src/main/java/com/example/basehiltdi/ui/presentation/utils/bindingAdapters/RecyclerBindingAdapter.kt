package com.example.basehiltdi.ui.presentation.utils.bindingAdapters

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.MotionEvent
import android.view.View
import android.widget.EdgeEffect
import androidx.databinding.BindingAdapter
import androidx.dynamicanimation.animation.SpringAnimation
import androidx.dynamicanimation.animation.SpringForce
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.epoxy.EpoxyController
import com.example.basehiltdi.ui.presentation.utils.GridSpacingItemDecoration
import com.example.basehiltdi.ui.presentation.utils.K
import com.example.basehiltdi.ui.presentation.utils.epoxy.ShimmerEpoxyRecyclerView
import com.example.basehiltdi.ui.presentation.utils.extensions.getResourceDrawable
import com.example.basehiltdi.ui.presentation.utils.overscroll.HorizontalOverScrollBounceEffectDecorator
import com.example.basehiltdi.ui.presentation.utils.overscroll.RecyclerViewOverScrollDecorAdapter
import com.example.basehiltdi.ui.presentation.utils.overscroll.VerticalOverScrollBounceEffectDecorator
import com.google.android.flexbox.*
import com.example.basehiltdi.R




@BindingAdapter("startPadding", "endPadding", "topPadding", "bottomPadding", requireAll = false)
fun ShimmerEpoxyRecyclerView.setPaddingRecycler(
    paddingStart: Float = 0f,
    paddingEnd: Float = 0f,
    paddingTop: Float = 0f,
    paddingBottom: Float = 0f
) {
    recyclerView.setPadding(
        paddingStart.toInt(),
        paddingTop.toInt(),
        paddingEnd.toInt(),
        paddingBottom.toInt()
    )
}

@BindingAdapter("verticalDirection")
fun ShimmerEpoxyRecyclerView.verticalDirection(controller: EpoxyController) {
    setController(controller).apply {
        setRecyclerConfiguration(RecyclerView.VERTICAL)
    }
}

@BindingAdapter("horizontalDirection")
fun ShimmerEpoxyRecyclerView.horizontalDirection(controller: EpoxyController) {
    val recycler = setController(controller)
    recycler.setRecyclerConfiguration(RecyclerView.HORIZONTAL)
}

@BindingAdapter("gridDirection", "spanCount", "spacing")
fun ShimmerEpoxyRecyclerView.gridDirection(controller: EpoxyController, spanCount: Int, spacing: Float = 0f) {
    setController(controller).apply {
        setConfigGridLayout(controller, spanCount, spacing)
    }
}

fun RecyclerView.setConfigGridLayout(controller: EpoxyController, spanCount: Int, spacing: Float = 0f) {
    val gridLayoutManager = GridLayoutManager(context, spanCount)
    controller.spanCount = spanCount
    gridLayoutManager.spanSizeLookup = controller.spanSizeLookup
    addItemDecoration(GridSpacingItemDecoration(spanCount, spacing.toInt(), true))
    overScrollMode = View.OVER_SCROLL_NEVER
    layoutManager = gridLayoutManager
}

private fun RecyclerView.setRecyclerConfiguration(type: Int) {
    itemAnimator = DefaultItemAnimator()
    overScrollMode = View.OVER_SCROLL_NEVER
    layoutManager = LinearLayoutManager(context, type, false)
    setBouncyDecorator(type)
}

@BindingAdapter("flexboxLayout")
fun ShimmerEpoxyRecyclerView.setFlexboxLayout(controller: EpoxyController) {
    setController(controller).apply {
        val layoutManagerFlexbox = FlexboxLayoutManager(context)
        layoutManagerFlexbox.flexDirection = FlexDirection.ROW
        layoutManagerFlexbox.justifyContent = JustifyContent.FLEX_START
        layoutManagerFlexbox.flexWrap = FlexWrap.WRAP

        val decorator = FlexboxItemDecoration(context)
        decorator.setDrawable(context.getResourceDrawable(R.drawable.shape_divider_flexbox))
        decorator.setOrientation(FlexboxItemDecoration.BOTH)
        addItemDecoration(decorator)

        itemAnimator = DefaultItemAnimator()
        overScrollMode = View.OVER_SCROLL_NEVER
        layoutManager = layoutManagerFlexbox
    }
}


fun RecyclerView.setBouncyDecorator(type: Int) {
    if (type == RecyclerView.HORIZONTAL) {
        HorizontalOverScrollBounceEffectDecorator(RecyclerViewOverScrollDecorAdapter(this))
        return
    }
    VerticalOverScrollBounceEffectDecorator(RecyclerViewOverScrollDecorAdapter(this))
}

@SuppressLint("ClickableViewAccessibility")
fun RecyclerView.setBouncyEffect(type: Int) {
    val translate = if (type == RecyclerView.HORIZONTAL) SpringAnimation.TRANSLATION_X else SpringAnimation.TRANSLATION_Y
    val orientation = if (type == RecyclerView.VERTICAL) RecyclerView.EdgeEffectFactory.DIRECTION_BOTTOM else RecyclerView.EdgeEffectFactory.DIRECTION_RIGHT
    val translation = SpringAnimation(this, translate)
        .setSpring(
            SpringForce()
                .setFinalPosition(0f)
                .setDampingRatio(SpringForce.DAMPING_RATIO_LOW_BOUNCY)
                .setStiffness(SpringForce.STIFFNESS_VERY_LOW)
        )
    var isTouchActive = true
    setOnTouchListener { _, event ->
        isTouchActive = event.action == MotionEvent.ACTION_DOWN
        if(event.action == MotionEvent.ACTION_UP) translation.start()
        return@setOnTouchListener false
    }

    edgeEffectFactory = object : RecyclerView.EdgeEffectFactory() {

        override fun createEdgeEffect(recyclerView: RecyclerView, direction: Int): EdgeEffect {

            val edgeEffect = object : EdgeEffect(recyclerView.context) {

                override fun onPull(deltaDistance: Float) {
                    super.onPull(deltaDistance)
                    handlePull(deltaDistance)
                }

                override fun onPull(deltaDistance: Float, displacement: Float) {
                    super.onPull(deltaDistance, displacement)
                    handlePull(deltaDistance)
                }

                override fun onRelease() {
                    super.onRelease()
                    translation.start()
                }

                private fun handlePull(deltaDistance: Float) {
                    // This is called on every touch event while the list is scrolled with a finger.
                    // We simply update the view properties without animation.
                    val sign = if (direction == orientation) -1 else 1
                    val translationDelta = sign * recyclerView.width *
                            deltaDistance * K.OVERSCROLL_TRANSLATION_MAGNITUDE
                    if (isTouchActive) translation.cancel()
                    if (type == RecyclerView.VERTICAL) {
                        recyclerView.translationY += translationDelta
                    } else {
                        recyclerView.translationX += translationDelta
                    }
                }

                override fun onAbsorb(velocity: Int) {
                    super.onAbsorb(velocity)
                    val sign = if (direction == orientation) -1 else 1
                    // The list has reached the edge on fling.
                    val translationVelocity = sign * velocity * K.FLING_TRANSLATION_MAGNITUDE
                    translation.setStartVelocity(translationVelocity).start()
                }
            }
            edgeEffect.color = Color.WHITE
            return edgeEffect
        }
    }
}