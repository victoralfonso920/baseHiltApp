package com.example.basehiltdi.ui.presentation.utils.overscroll.interfaces


// Source code extracted from https://github.com/EverythingMe/overscroll-decor/tree/master

/**
 * A callback-listener enabling over-scroll effect clients to be notified of effect state transitions.
 * <br></br>Invoked whenever state is transitioned onto one of [OverScrollState.STATE_IDLE],
 * [OverScrollState.STATE_DRAG_START_SIDE], [OverScrollState.STATE_DRAG_END_SIDE]
 * or [OverScrollState.STATE_BOUNCE_BACK].
 *
 * @see OverScrollUpdateListener
 */
interface OverScrollStateListener {
    /**
     * The invoked callback.
     *
     * @param decor The associated over-scroll 'decorator'.
     * @param oldState The old over-scroll state; ID's specified by [OverScrollState], e.g.
     * [OverScrollState.STATE_IDLE].
     * @param newState The **new** over-scroll state; ID's specified by [OverScrollState],
     * e.g. [OverScrollState.STATE_IDLE].
     */
    fun onOverScrollStateChange(decor: OverScrollDecor?, oldState: Int, newState: Int)
}
