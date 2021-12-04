package com.example.intellias_test.logic

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.intellias_test.R
import com.example.intellias_test.databinding.FragmentLogicBinding
import kotlinx.android.synthetic.main.fragment_logic.view.*


class LogicFragment : Fragment() {

    private lateinit var binding: FragmentLogicBinding
    private val viewModel by viewModels<LogicViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_logic, container, false
        )

        //data binding
        binding.logicViewModel = viewModel
        binding.setLifecycleOwner(this)

       binding.wordText.setOnClickListener {
           viewModel.setWord(it.word_text.text.toString())
        }

        /*viewModel.word.observe(this, Observer { newWord ->
            viewModel.wordInput(newWord)
        })*/
        return binding.root
    }

}