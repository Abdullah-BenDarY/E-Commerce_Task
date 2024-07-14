package com.example.e_commercetask.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.e_commercetask.R
import com.example.e_commercetask.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        }
}