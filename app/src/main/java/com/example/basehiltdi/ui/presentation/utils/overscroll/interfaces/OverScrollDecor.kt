package com.example.basehiltdi.ui.presentation.utils.overscroll.interfaces

import android.view.View


// Source code extracted from https://github.com/EverythingMe/overscroll-decor/tree/master

interface OverScrollDecor {
    val view: View
    fun setOverScrollStateListener(listener: OverScrollStateListener?)
    fun setOverScrollUpdateListener(listener: OverScrollUpdateListener?)

    /**
     * Get the current decorator's runtime state, i.e. one of the values specified by [OverScrollState].
     * @return The state.
     */
    val currentState: Int

    /**
     * Detach the decorator from its associated view, thus disabling it entirely.
     *
     *
     * It is best to call this only when over-scroll isn't currently in-effect - i.e. verify that
     * `getCurrentState()==IOverScrollState.STATE_IDLE` as a precondition, or otherwise
     * use a state listener previously installed using
     * [.setOverScrollStateListener].
     *
     *
     * Note: Upon detachment completion, the view in question will return to the default
     * Android over-scroll configuration (i.e. [View.OVER_SCROLL_ALWAYS] mode). This can be
     * overridden by calling `View.setOverScrollMode(mode)` immediately thereafter.
     */
    fun detach()
}
