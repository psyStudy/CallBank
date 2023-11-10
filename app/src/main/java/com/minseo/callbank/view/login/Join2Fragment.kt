package com.minseo.callbank.view.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isEmpty
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.minseo.callbank.R
import com.minseo.callbank.databinding.FragmentJoin1Binding
import com.minseo.callbank.databinding.FragmentJoin2Binding
import com.minseo.callbank.view_model.UserViewModel

class Join2Fragment : Fragment() {
    private lateinit var binding: FragmentJoin2Binding
    private val sharedViewModel: UserViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentJoin2Binding.inflate(inflater, container, false)
        binding = fragmentBinding
        initView()
        return fragmentBinding.root
    }

    private fun initView() = with(binding) {
        binding.btBack.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_join2Fragment_to_join1Fragment)
        }

        binding.btNext.setOnClickListener {
            var pass = false
            sharedViewModel.setNameTelBirth(binding.etName.editText?.text.toString(),
                        binding.etTel.editText?.text.toString(), binding.etBirth.editText?.text.toString())

            sharedViewModel.flag.observe(viewLifecycleOwner) {
                if (it)
                    pass = true
                else {
                    sharedViewModel.nameError.observe(viewLifecycleOwner) {
                        binding.etName.error = it
                    }
                    sharedViewModel.telError.observe(viewLifecycleOwner) {
                        binding.etTel.error = it
                    }
                    sharedViewModel.birthError.observe(viewLifecycleOwner) {
                        binding.etBirth.error = it
                    }
                }
            }

            if (pass)
                Navigation.findNavController(binding.root).navigate(R.id.action_join2Fragment_to_join3Fragment)
        }
    }
}