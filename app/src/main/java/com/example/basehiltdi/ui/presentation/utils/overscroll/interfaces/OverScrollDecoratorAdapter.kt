package com.example.basehiltdi.ui.presentation.utils.overscroll.interfaces

import android.view.View

// Source code extracted from https://github.com/EverythingMe/overscroll-decor/tree/master

/**
 * @see com.hugoapp.client.architecture.presentation.utils.overscroll.HorizontalOverScrollBounceEffectDecorator
 */
interface OverScrollDecoratorAdapter {
    val view: View

    /**
     * Is view in it's absolute start position - such that a negative over-scroll can potentially
     * be initiated. For example, in list-views, this is synonymous with the first item being
     * fully visible.
     *
     * @return Whether in absolute start position.
     */
    val isInAbsoluteStart: Boolean

    /**
     * Is view in it's absolute end position - such that an over-scroll can potentially
     * be initiated. For example, in list-views, this is synonymous with the last item being
     * fully visible.
     *
     * @return Whether in absolute end position.
     */
    val isInAbsoluteEnd: Boolean
}
