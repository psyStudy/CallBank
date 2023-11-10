package com.minseo.callbank.view.login

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.minseo.callbank.R
import com.minseo.callbank.databinding.FragmentJoin1Binding
import com.minseo.callbank.view_model.UserViewModel

class Join1Fragment : Fragment() {
    private lateinit var binding: FragmentJoin1Binding
    private val sharedViewModel: UserViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentJoin1Binding.inflate(inflater, container, false)
        binding = fragmentBinding
        initView()
        return fragmentBinding.root
    }

    private fun initView() = with(binding) {
        var pass = false
        binding.btNext.setOnClickListener {
            sharedViewModel.setIdPwd(binding.etEmail.editText?.text.toString(),
                        binding.etPwd.editText?.text.toString(), binding.chPwd.editText?.text.toString())

            sharedViewModel.flag.observe(viewLifecycleOwner) {
                if (it)
                    pass = true
                else {
                    sharedViewModel.idError.observe(viewLifecycleOwner) {
                        binding.etEmail.error = it
                    }
                    sharedViewModel.pwdError.observe(viewLifecycleOwner) {
                        binding.etPwd.error = it
                    }
                }
            }

            if (pass)
                Navigation.findNavController(binding.root).navigate(R.id.action_join1Fragment_to_join2Fragment)
        }

        binding.btBack.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_join1Fragment_to_loginFragment)
        }
    }
}