package com.minseo.callbank.view.send

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.minseo.callbank.R
import com.minseo.callbank.databinding.FragmentSend9Binding

class Send9Fragment : Fragment() {
    private lateinit var binding: FragmentSend9Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentSend9Binding.inflate(inflater, container, false)
        binding = fragmentBinding

        binding.btPass.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_send9Fragment_to_mainFragment)
        }

        return fragmentBinding.root
    }
}