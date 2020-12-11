package com.nonamer777.madlevel6task2.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nonamer777.madlevel6task2.databinding.ActivityMainBinding

class MainActivity: AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
    }
}
