package com.example.basehiltdi.ui.features.simple_list.data

import com.example.basehiltdi.ui.presentation.data.models.Model

data class TitleModel(
    override val id: String,
    val title: String = ""
): Model
