package com.example.basehiltdi.ui.presentation.utils.extensions

import android.app.Activity
import android.os.Build
import android.util.DisplayMetrics
import android.view.Gravity
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import com.example.basehiltdi.BuildConfig
import com.example.basehiltdi.R
import com.google.android.material.snackbar.Snackbar
import timber.log.Timber
import kotlin.math.ceil
import kotlin.math.roundToInt

fun Activity.getUsableHeight(): Int {
    val displayMetrics = DisplayMetrics()
    windowManager.defaultDisplay.getMetrics(displayMetrics)

    var statusBarHeight = resources.getDimensionPixelSize(
        resources.getIdentifier("status_bar_height", "dimen", "android")
    )
    if (statusBarHeight <= 0) {
        statusBarHeight = ceil(
            (if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                24
            } else {
                25
            }) * resources.displayMetrics.density
        ).roundToInt()
    }

    return displayMetrics.heightPixels - statusBarHeight
}

fun Fragment.getUsableHeight(): Int {
    return requireActivity().getUsableHeight()
}

fun String.logv() {
    if (BuildConfig.DEBUG)
        Timber.tag("AppTAG").v(this)
}

fun String.loge() {
    if (BuildConfig.DEBUG)
        Timber.tag("AppTAG").e(this)
}

fun View.snackbar(message: String, isError: Boolean = false) {
    val snack = Snackbar.make(this, message, Snackbar.LENGTH_LONG)
    (snack.view.findViewById(com.google.android.material.R.id.snackbar_text) as TextView).also {
        it.setTextColor(ContextCompat.getColor(this.context, R.color.white))
        it.typeface = ResourcesCompat.getFont(context, R.font.roboto_bold)
        it.gravity = Gravity.CENTER
    }

    if (isError) {
        snack.view.setBackgroundColor(ContextCompat.getColor(this.context, R.color.persian_red))
    } else {
        snack.view.setBackgroundColor(ContextCompat.getColor(this.context, R.color.mountain_meadow))
    }
    snack.show()
}




