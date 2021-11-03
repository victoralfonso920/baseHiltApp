package com.example.basehiltdi.ui.presentation.utils.overscroll.interfaces


// Source code extracted from https://github.com/EverythingMe/overscroll-decor/tree/master

/**
 * A callback-listener enabling over-scroll effect clients to subscribe to **real-time** updates
 * of over-scrolling intensity, provided as the view-translation offset from pre-scroll position.
 *
 * @see OverScrollStateListener
 */
interface OverScrollUpdateListener {
    /**
     * The invoked callback.
     *
     * @param decor The associated over-scroll 'decorator'.
     * @param state One of: [OverScrollState.STATE_IDLE], [OverScrollState.STATE_DRAG_START_SIDE],
     * [OverScrollState.STATE_DRAG_START_SIDE] or [OverScrollState.STATE_BOUNCE_BACK].
     * @param offset The currently visible offset created due to over-scroll.
     */
    fun onOverScrollUpdate(decor: OverScrollDecor?, state: Int, offset: Float)
}
