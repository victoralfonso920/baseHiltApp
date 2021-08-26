package com.example.basehiltdi.ui.base.utils

import android.content.Context
import android.view.Gravity
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.example.basehiltdi.BuildConfig
import com.example.basehiltdi.R
import com.google.android.material.snackbar.Snackbar
import timber.log.Timber

// Created by Victor Hernandez on 25/8/21.
// Proyect BaseHiltDi
//contact victoralfonso920@gmail.com

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

fun View.hideKeyboard() {
    val inputMethodManager =
        context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(rootView.windowToken, 0)
}

