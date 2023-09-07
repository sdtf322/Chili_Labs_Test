package com.opliska.chili_labs_test.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.opliska.chili_labs_test.databinding.ActivityMainBinding
import com.opliska.chili_labs_test.databinding.ActivityMainBinding.inflate
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = inflate(layoutInflater)
        setContentView(binding.root)
    }
}