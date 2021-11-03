package com.example.basehiltdi.ui.presentation.data.models

import androidx.databinding.ObservableBoolean

data class GeneralButtonModel(
        override val id: String = "GENERAL_BUTTON",
        val text: String = "",
        val isRequestInProgress: ObservableBoolean = ObservableBoolean(false)
): Model
