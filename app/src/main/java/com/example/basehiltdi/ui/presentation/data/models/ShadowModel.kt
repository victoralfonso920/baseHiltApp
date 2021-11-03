package com.example.basehiltdi.ui.presentation.data.models

data class ShadowModel(
    val shadowColor: Int,
    val blur: Float,
    val Dx: Float,
    val Dy: Float,
    val cornerRadius: CornerRadius,
    val backgroundColor: Int,
    val layerInsetStart: Int,
    val layerInsetEnd: Int,
    val layerInsetTop: Int,
    val layerInsetBottom: Int
)

data class CornerRadius(
    val topLeft: Float = 0f,
    val topRight: Float = 0f,
    val bottomLeft: Float = 0f,
    val bottomRight: Float = 0f
)
