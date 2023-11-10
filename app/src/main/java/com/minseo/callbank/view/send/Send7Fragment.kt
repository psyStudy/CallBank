package com.minseo.callbank.view.send

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.minseo.callbank.R
import com.minseo.callbank.databinding.FragmentSend7Binding
import com.minseo.callbank.view_model.SendViewModel

class Send7Fragment : Fragment() {
    private lateinit var binding: FragmentSend7Binding
    private val sharedViewModel: SendViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentSend7Binding.inflate(inflater, container, false)
        binding = fragmentBinding

        binding.tvBankName.setText(sharedViewModel.recipient_bank_name.value)
        binding.tvAccountNum.setText(sharedViewModel.recipient_account_num.value)
        binding.tvAmount.setText(sharedViewModel.tran_amt.value.toString() + "원")

        // 계속 버튼 클릭
        binding.btNext.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_send7Fragment_to_send8Fragment)
        }
        // 뒤로 버튼 클릭
        binding.btBack.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_send7Fragment_to_send6Fragment)
        }

        return fragmentBinding.root
    }
}