package com.opliska.chili_labs_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.opliska.chili_labs_test.databinding.ActivityMainBinding
import com.opliska.chili_labs_test.databinding.ActivityMainBinding.bind
import com.opliska.chili_labs_test.databinding.ActivityMainBinding.inflate

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding  // Declare the binding variable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Initialize the binding
        binding = inflate(layoutInflater)
        setContentView(binding.root)
    }
}