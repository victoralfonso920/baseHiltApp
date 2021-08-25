package com.example.basehiltdi.features.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.basehiltdi.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeHostActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_host)
    }
}