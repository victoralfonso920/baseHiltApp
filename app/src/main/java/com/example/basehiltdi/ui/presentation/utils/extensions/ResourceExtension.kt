package com.example.basehiltdi.ui.presentation.utils.extensions

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory

fun Context?.getResourceDrawable(id: Int): Drawable? {
    return if (this != null) {
        ContextCompat.getDrawable(this, id)
    } else null
}

fun Context?.getResourceColor(id: Int): Int {
    return if (this != null) {
        ContextCompat.getColor(this, id)
    } else 0
}

fun Context?.getResourceBitmap(resource: Int): Bitmap? {
    return if (this != null) {
        (getResourceDrawable(resource) as BitmapDrawable).bitmap
    } else null
}

fun Context?.generateBitmapDescriptorFromRes(resId: Int): BitmapDescriptor? {
    val drawable = getResourceDrawable(resId) ?: return null
    drawable.apply {
        setBounds(
            0,
            0,
            intrinsicWidth,
            intrinsicHeight
        )
    }
    val bitmap = Bitmap
        .createBitmap(drawable.intrinsicWidth, drawable.intrinsicHeight, Bitmap.Config.ARGB_8888)
    val canvas = Canvas(bitmap)
    drawable.draw(canvas)
    return BitmapDescriptorFactory.fromBitmap(bitmap)
}

