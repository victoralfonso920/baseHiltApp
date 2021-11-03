package com.example.basehiltdi.ui.presentation.utils.overscroll.interfaces

// Source code extracted from https://github.com/EverythingMe/overscroll-decor/tree/master

interface OverScrollState {
    companion object {
        /** No over-scroll is in-effect.  */
        const val STATE_IDLE = 0

        /** User is actively touch-dragging, thus enabling over-scroll at the view's *start* side.  */
        const val STATE_DRAG_START_SIDE = 1

        /** User is actively touch-dragging, thus enabling over-scroll at the view's *end* side.  */
        const val STATE_DRAG_END_SIDE = 2

        /** User has released their touch, thus throwing the view back into place via bounce-back animation.  */
        const val STATE_BOUNCE_BACK = 3
    }
}
