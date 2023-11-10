package com.minseo.callbank

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.minseo.callbank.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentMainBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        initView()
        return fragmentBinding.root
    }

    private fun initView() = with(binding) {
        binding.icMic.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_mainFragment_to_speechRecognition)
        }
        binding.btSend.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_mainFragment_to_send1Fragment)
        }
        binding.btMap.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_mainFragment_to_mapActivity)
        }
    }
}