package com.example.e_commercetask.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.e_commercetask.R
import com.example.e_commercetask.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var binding:ActivityMainBinding ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

}