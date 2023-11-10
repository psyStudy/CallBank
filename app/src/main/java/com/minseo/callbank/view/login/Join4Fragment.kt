package com.minseo.callbank.view.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.minseo.callbank.R
import com.minseo.callbank.databinding.FragmentJoin4Binding

class Join4Fragment : Fragment() {
    private lateinit var binding: FragmentJoin4Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentJoin4Binding.inflate(inflater, container, false)
        binding = fragmentBinding
        initView()
        return fragmentBinding.root
    }

    private fun initView() = with(binding) {
        binding.btFinish.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_join4Fragment_to_loginFragment)
        }
    }
}