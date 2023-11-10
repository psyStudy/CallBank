package com.minseo.callbank.view.send

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.minseo.callbank.R
import com.minseo.callbank.databinding.FragmentSend5Binding
import com.minseo.callbank.view_model.SendViewModel

class Send5Fragment : Fragment() {
    private lateinit var binding: FragmentSend5Binding
    private val sharedViewModel: SendViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentSend5Binding.inflate(inflater, container, false)
        binding = fragmentBinding

        // 계좌번호 입력
        var account = ""
        binding.bt1.setOnClickListener {
            account += "1"
            binding.chAccount.setText(account)
        }
        binding.bt2.setOnClickListener {
            account += "2"
            binding.chAccount.setText(account)
        }
        binding.bt3.setOnClickListener {
            account += "3"
            binding.chAccount.setText(account)
        }
        binding.bt4.setOnClickListener {
            account += "4"
            binding.chAccount.setText(account)
        }
        binding.bt5.setOnClickListener {
            account += "5"
            binding.chAccount.setText(account)
        }
        binding.bt6.setOnClickListener {
            account += "6"
            binding.chAccount.setText(account)
        }
        binding.bt7.setOnClickListener {
            account += "7"
            binding.chAccount.setText(account)
        }
        binding.bt8.setOnClickListener {
            account += "8"
            binding.chAccount.setText(account)
        }
        binding.bt9.setOnClickListener {
            account += "9"
            binding.chAccount.setText(account)
        }
        binding.bt0.setOnClickListener {
            account += "0"
            binding.chAccount.setText(account)
        }
        binding.btDelete.setOnClickListener{
            if (0 < account.length) {
                account = account.substring(0, account.length - 1)
                binding.chAccount.setText(account)
            }
        }

        // 계속 버튼 클릭
        binding.btNext.setOnClickListener {
            if (0 < account.length) {
                sharedViewModel.setAccountNum(account)
                Navigation.findNavController(binding.root).navigate(R.id.action_send5Fragment_to_send6Fragment)
            }
        }
        // 취소 버튼 클릭
        binding.btBack.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_send5Fragment_to_send4Fragment)
        }

        return fragmentBinding.root
    }
}