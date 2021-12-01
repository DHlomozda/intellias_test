package com.example.intellias_test.logic

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.intellias_test.R
import com.example.intellias_test.databinding.FragmentLogicBinding


class LogicFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentLogicBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_logic, container, false
        )
        return binding.root
    }

}