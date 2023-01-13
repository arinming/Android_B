package com.example.logintest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.logintest.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}