package com.minseo.callbank.view.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.minseo.callbank.R
import com.minseo.callbank.databinding.FragmentLoginBinding
import com.minseo.callbank.databinding.FragmentMainBinding
import com.minseo.callbank.view_model.UserViewModel

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private val sharedViewModel: UserViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentLoginBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        initView()
        return fragmentBinding.root
    }

    private fun initView() = with(binding) {
        binding.btSuccess.setOnClickListener {
            val result = sharedViewModel.createUser()
            if (result)
                Navigation.findNavController(binding.root).navigate(R.id.action_loginFragment_to_mainFragment)
        }
        binding.btSignin.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_loginFragment_to_join1Fragment)
        }
        binding.btCall.setOnClickListener {
//            Navigation.findNavController(binding.root).navigate(R.id.action_loginFragment_to_mapFragment)
        }
    }
}