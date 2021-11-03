package com.example.basehiltdi.ui.presentation.utils.overscroll.interfaces


// Source code extracted from https://github.com/EverythingMe/overscroll-decor/tree/master

interface ListenerStubs {
    class OverScrollStateListenerStub : OverScrollStateListener {
        override fun onOverScrollStateChange(decor: OverScrollDecor?, oldState: Int, newState: Int) {}
    }

    class OverScrollUpdateListenerStub : OverScrollUpdateListener {
        override fun onOverScrollUpdate(decor: OverScrollDecor?, state: Int, offset: Float) {}
    }
}
