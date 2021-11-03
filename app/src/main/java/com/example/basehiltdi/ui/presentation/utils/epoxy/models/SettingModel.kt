package com.example.basehiltdi.ui.presentation.utils.epoxy.models

import android.os.Parcelable
import com.example.basehiltdi.R
import kotlinx.parcelize.Parcelize


@Parcelize
data class SettingModel(
    val color: Int = R.color.white,
    val isColor: Boolean = false,
    val isFlexbox: Boolean = false,
    val isFlexWrap: Boolean = false,
    val isJustifyCenter: Boolean = false,
    val isjustify: String = "",
    val isBouncy: Boolean = true
) : Parcelable
