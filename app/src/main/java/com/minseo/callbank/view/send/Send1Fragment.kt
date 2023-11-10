package com.minseo.callbank.view.send

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.minseo.callbank.R
import com.minseo.callbank.databinding.FragmentSend1Binding

class Send1Fragment : Fragment() {
    private lateinit var binding: FragmentSend1Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentSend1Binding.inflate(inflater, container, false)
        binding = fragmentBinding


        binding.btNext.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_send1Fragment_to_send2Fragment)
        }

        return fragmentBinding.root
    }
}