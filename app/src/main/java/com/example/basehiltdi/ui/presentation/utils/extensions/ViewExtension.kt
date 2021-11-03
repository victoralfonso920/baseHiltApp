package com.example.basehiltdi.ui.presentation.utils.extensions

import android.animation.ValueAnimator
import android.content.Context
import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.inputmethod.InputMethodManager
import androidx.core.view.isGone
import androidx.core.view.isInvisible
import androidx.core.view.isVisible

fun View.makeVisible() {
    visibility = View.VISIBLE
}

fun View.makeInvisible() {
    visibility = View.INVISIBLE
}

fun View.makeGone() {
    visibility = View.GONE
}

fun View.makeVisibleWithEffect() {
    if (!isVisible) {
        fadeInOutEffect(fromAlpha = 0.0f, toAlpha = 1.0f)
        makeVisible()
    }
}

fun View.makeInvisibleWithEffect() {
    if (!isInvisible) {
        this.fadeInOutEffect(fromAlpha = 1.0f, toAlpha = 0.0f)
        this.makeInvisible()
    }
}

fun View.makeGoneWithEffect() {
    if (!isGone) {
        fadeInOutEffect(fromAlpha = 1.0f, toAlpha = 0.0f)
        makeGone()
    }
}

fun View.increaseHeightEffect(startHeight: Int, endHeight: Int) {
    val anim = ValueAnimator.ofInt(startHeight, endHeight)
    anim.addUpdateListener { valueAnimator ->
        val `val` = valueAnimator.animatedValue as Int
        val layoutParams = layoutParams
        layoutParams.height = `val`
        setLayoutParams(layoutParams)
    }
    anim.duration = 500
    anim.start()
}

fun View.fadeInOutEffect(fromAlpha: Float, toAlpha: Float) {
    val anim = AlphaAnimation(fromAlpha, toAlpha)
    anim.duration = 500
    anim.repeatCount = 0
    anim.repeatMode = Animation.REVERSE
    this.startAnimation(anim)
}

fun View.hideKeyboard() {
    val inputMethodManager =
        context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(rootView.windowToken, 0)
}
