package com.minseo.callbank.view.send

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.navigation.Navigation
import com.minseo.callbank.R
import com.minseo.callbank.databinding.FragmentSend1Binding
import com.minseo.callbank.databinding.FragmentSend2Binding

class Send2Fragment : Fragment() {
    private lateinit var binding: FragmentSend2Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentSend2Binding.inflate(inflater, container, false)
        binding = fragmentBinding

        // 비밀번호 입력
        var password = ""
        binding.bt1.setOnClickListener {
            if(password.length < 4) {
                password += "1"
                binding.squareField.setText(password)
            }
        }
        binding.bt2.setOnClickListener {
            if(password.length < 4) {
                password += "2"
                binding.squareField.setText(password)
            }
        }
        binding.bt3.setOnClickListener {
            if(password.length < 4) {
                password += "3"
                binding.squareField.setText(password)
            }
        }
        binding.bt4.setOnClickListener {
            if(password.length < 4) {
                password += "4"
                binding.squareField.setText(password)
            }
        }
        binding.bt5.setOnClickListener {
            if(password.length < 4) {
                password += "5"
                binding.squareField.setText(password)
            }
        }
        binding.bt6.setOnClickListener {
            if(password.length < 4) {
                password += "6"
                binding.squareField.setText(password)
            }
        }
        binding.bt7.setOnClickListener {
            if(password.length < 4) {
                password += "7"
                binding.squareField.setText(password)
            }
        }
        binding.bt8.setOnClickListener {
            if(password.length < 4) {
                password += "8"
                binding.squareField.setText(password)
            }
        }
        binding.bt9.setOnClickListener {
            if(password.length < 4) {
                password += "9"
                binding.squareField.setText(password)
            }
        }
        binding.bt0.setOnClickListener {
            if(password.length < 4) {
                password += "0"
                binding.squareField.setText(password)
            }
        }
        binding.btDelete.setOnClickListener{
            if(0 < password.length) {
                password = password.substring(0, password.length - 1)
                binding.squareField.setText(password)
            }
        }


        // 계속 버튼 클릭
        binding.btNext.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_send2Fragment_to_send3Fragment)
        }
        // 뒤로 버튼 클릭
        binding.btBack.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_send2Fragment_to_send1Fragment)
        }

        return fragmentBinding.root
    }
}