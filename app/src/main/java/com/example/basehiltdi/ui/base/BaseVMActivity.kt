package com.example.basehiltdi.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding

// Created by Victor Hernandez on 2/6/21.
// Proyect android_cliente
//contact victoralfonso920@gmail.com

abstract class BaseVMActivity<VM : ViewModel, B : ViewBinding>(val bindingFactory: (LayoutInflater) -> B) : AppCompatActivity() {

    lateinit var binding: B


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = bindingFactory(layoutInflater)
        setContentView(binding.root)
    }

}