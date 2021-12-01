package com.example.intellias_test.logic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.intellias_test.R
import com.example.intellias_test.databinding.LogicFragmentBinding

class LogicFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: LogicFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.logic_fragment, container, false
        )
        
        return  binding.root
    }
}