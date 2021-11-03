package com.example.basehiltdi.ui.presentation.data.vo

// Created by Victor Hernandez on 25/8/21.
// Proyect BaseHiltDi
//contact victoralfonso920@gmail.com

sealed class Resource<out T> {
    data class Success<out T>(val data: T) : Resource<T>()
    data class Error(val message: String) : Resource<Nothing>()
}
