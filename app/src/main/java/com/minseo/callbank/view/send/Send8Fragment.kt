package com.minseo.callbank.view.send

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.minseo.callbank.R
import com.minseo.callbank.databinding.FragmentSend8Binding

class Send8Fragment : Fragment() {
    private lateinit var binding: FragmentSend8Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentSend8Binding.inflate(inflater, container, false)
        binding = fragmentBinding

        binding.btNext.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_send8Fragment_to_send9Fragment)
        }

        return fragmentBinding.root
    }
}