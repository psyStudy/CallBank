package com.minseo.callbank.view.send

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.minseo.callbank.R
import com.minseo.callbank.databinding.FragmentSend6Binding
import com.minseo.callbank.view_model.SendViewModel

class Send6Fragment : Fragment() {
    private lateinit var binding: FragmentSend6Binding
    private val sharedViewModel: SendViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentSend6Binding.inflate(inflater, container, false)
        binding = fragmentBinding

        // 금액 입력
        var amount = ""
        binding.bt1.setOnClickListener {
            amount += "1"
            binding.chAmount.setText(amount+"원")
        }
        binding.bt2.setOnClickListener {
            amount += "2"
            binding.chAmount.setText(amount+"원")
        }
        binding.bt3.setOnClickListener {
            amount += "3"
            binding.chAmount.setText(amount+"원")
        }
        binding.bt4.setOnClickListener {
            amount += "4"
            binding.chAmount.setText(amount+"원")
        }
        binding.bt5.setOnClickListener {
            amount += "5"
            binding.chAmount.setText(amount+"원")
        }
        binding.bt6.setOnClickListener {
            amount += "6"
            binding.chAmount.setText(amount+"원")
        }
        binding.bt7.setOnClickListener {
            amount += "7"
            binding.chAmount.setText(amount+"원")
        }
        binding.bt8.setOnClickListener {
            amount += "8"
            binding.chAmount.setText(amount+"원")
        }
        binding.bt9.setOnClickListener {
            amount += "9"
            binding.chAmount.setText(amount+"원")
        }
        binding.bt0.setOnClickListener {
            amount += "0"
            binding.chAmount.setText(amount+"원")
        }
        binding.bt00.setOnClickListener {
            amount += "00"
            binding.chAmount.setText(amount+"원")
        }
        binding.btDelete.setOnClickListener{
            if(0 < amount.length) {
                amount = amount.substring(0, amount.length - 1)
                binding.chAmount.setText(amount+"원")
            }
        }

        // 계속 버튼 클릭
        binding.btNext.setOnClickListener {
            if (0 < amount.length) {
                sharedViewModel.setAmount(amount.toInt())
                Navigation.findNavController(binding.root).navigate(R.id.action_send6Fragment_to_send7Fragment)
            }
        }
        // 취소 버튼 클릭
        binding.btBack.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_send6Fragment_to_send5Fragment)
        }

        return fragmentBinding.root
    }
}