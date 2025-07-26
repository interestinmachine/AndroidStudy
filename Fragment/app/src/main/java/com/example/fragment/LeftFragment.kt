package com.example.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class LeftFragment:Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var activity = activity
        if (null != activity) {
            var mainActivity = activity as MainActivity
        }
        return inflater.inflate(R.layout.left_fragment, container, false)
    }
}