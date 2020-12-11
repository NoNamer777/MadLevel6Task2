package com.nonamer777.madlevel6task2.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nonamer777.madlevel6task2.R

/**
 * A [Fragment] subclass that shows the selected movie's details.
 */
class DetailsFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_details, container, false)
}
