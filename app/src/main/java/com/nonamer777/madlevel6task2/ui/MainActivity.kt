package com.nonamer777.madlevel6task2.ui

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.nonamer777.madlevel6task2.R
import com.nonamer777.madlevel6task2.databinding.ActivityMainBinding

class MainActivity: AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        findNavController(R.id.nav_host_fragment).addOnDestinationChangedListener { _, destination, _ ->
            when (destination.label == getString(R.string.details_fragment_label)) {
                true -> {

                    supportActionBar?.setHomeButtonEnabled(true)
                    supportActionBar?.setDisplayHomeAsUpEnabled(true)
                } else -> {

                supportActionBar?.setHomeButtonEnabled(false)
                supportActionBar?.setDisplayHomeAsUpEnabled(false)
                }
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        (android.R.id.home) -> {

            findNavController(R.id.nav_host_fragment)
                .navigate(R.id.action_detailsFragment_to_overviewFragment)

            true
        }
        else -> super.onOptionsItemSelected(item)
    }
}
