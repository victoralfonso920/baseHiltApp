package com.example.basehiltdi.ui.presentation.utils.epoxy

import android.content.ComponentCallbacks
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.epoxy.*
import com.example.basehiltdi.R
import com.example.basehiltdi.ui.presentation.base.viewModel.EventListener
import com.example.basehiltdi.ui.presentation.data.models.CarouselModel
import com.example.basehiltdi.ui.presentation.data.models.CarouselSkeletonModel
import com.example.basehiltdi.ui.presentation.data.models.SkeletonModel
import com.example.basehiltdi.ui.presentation.utils.K
import com.example.basehiltdi.ui.presentation.utils.bindingAdapters.setBouncyEffect
import com.example.basehiltdi.ui.presentation.utils.epoxy.models.SettingModel
import com.example.basehiltdi.ui.presentation.utils.epoxy.models.SkeletonModel_
import com.example.basehiltdi.ui.presentation.utils.epoxy.models.skeleton
import com.example.basehiltdi.ui.presentation.utils.extensions.getResourceDrawable
import com.example.basehiltdi.ui.presentation.utils.epoxy.models.SkeletonModel as Skeleton

import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexWrap
import com.google.android.flexbox.JustifyContent



fun EpoxyController.addSkeletonModels(models: List<SkeletonModel>?) {
    models?.mapIndexed { index, model ->
        if (model.isVerticalOrientation) {
            for (i in 1..model.itemRepeat) {
                skeleton {
                    id("vertical_skeleton_${index + i}")
                    viewLayout(model.viewLayout)
                    if(model.isNeedSpanSizeOverride) {
                        spanSizeOverride { totalSpanCount, _, _ ->
                            return@spanSizeOverride totalSpanCount
                        }
                    }
                }
            }
        } else {
            val horizontalSkeletons = mutableListOf<Skeleton>()
            for (i in 1..model.itemRepeat) {
                horizontalSkeletons.add(
                    SkeletonModel_()
                        .id("horizontal_skeleton_${index + i}")
                        .viewLayout(model.viewLayout)
                )
            }
            val carouselModel = CarouselSkeletonModel(
                id = "carousel_skeleton",
                startEndPadding = model.startEndPadding,
                itemSpacing = model.itemSpacing
            )
            getCarousel(carouselModel, horizontalSkeletons)
        }
    }
}

fun EpoxyController.getCarousel(
    model: CarouselModel,
    models: List<EpoxyModel<*>>,
    setting: SettingModel = SettingModel()
) {
    carousel {
        id(model.id)
        padding(
            Carousel
                .Padding(model.startEndPadding, model.topBottomPadding, model.startEndPadding, model.topBottomPadding, model.itemSpacing)
        )
        Carousel.setDefaultGlobalSnapHelperFactory(null)
        models(models)
        onBind { _, view, _ ->
            view.apply {
                if (setting.isColor) setBackgroundColor(ContextCompat.getColor(view.context, setting.color))
                if (setting.isBouncy) setBouncyEffect(RecyclerView.HORIZONTAL)
                if (setting.isFlexbox) {
                    val layoutManagerFlexbox = SafeFlexboxLayoutManager(context).apply {
                        flexDirection = FlexDirection.ROW
                        justifyContent =  when(setting.isjustify){
                            K.SPACE_AROUND -> JustifyContent.SPACE_AROUND
                            K.CENTER -> JustifyContent.CENTER
                            K.FLEX_START -> JustifyContent.FLEX_START
                            K.SPACE_BETWEEN -> JustifyContent.SPACE_BETWEEN
                            else -> JustifyContent.SPACE_BETWEEN
                        }
                        if (setting.isFlexWrap) flexWrap = FlexWrap.NOWRAP
                    }
                    layoutManager = layoutManagerFlexbox
                } else {
                    layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
                }
            }
        }
    }
}

fun getPagingCarousel(
    model: CarouselModel,
    models: List<EpoxyModel<*>>,
    @ColorRes backgroundColor: Int = R.color.transparent
): CarouselModel_ {
    return CarouselModel_().apply {
        id(model.id)
        padding(
            Carousel
                .Padding(model.startEndPadding, 0, model.startEndPadding, 0, model.itemSpacing)
        )
        Carousel.setDefaultGlobalSnapHelperFactory(null)
        models(models)
        onBind { _, view, _ ->
            view.apply {
                setBouncyEffect(RecyclerView.HORIZONTAL)
                background = context.getResourceDrawable(backgroundColor)
            }
        }
    }
}

