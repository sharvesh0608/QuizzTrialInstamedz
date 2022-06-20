package com.example.quizztrialinstamedz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.quizztrialinstamedz.databinding.FragmentWelcomeBinding


class Welcome : Fragment() {
    lateinit var binding: FragmentWelcomeBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_welcome, container, false)
        binding.button3.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_welcome_to_questionFragment)
        }
        return binding.root


    }
}
