package com.nonamer777.madlevel6task2.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.nonamer777.madlevel6task2.R

/**
 * A [Fragment] subclass where Users can input a year and see the most
 * popular English spoken movies of that year.
 */
class OverviewFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_overview, container, false)
}
