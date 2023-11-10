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
import com.minseo.callbank.databinding.FragmentSend4Binding
import com.minseo.callbank.view_model.SendViewModel

class Send4Fragment : Fragment() {
    private lateinit var binding: FragmentSend4Binding
    private val sharedViewModel: SendViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentSend4Binding.inflate(inflater, container, false)
        binding = fragmentBinding

        // 계속 버튼 클릭
        binding.btNext.setOnClickListener {
            if (!sharedViewModel.hasNoBankNameSet()) {
                Navigation.findNavController(binding.root).navigate(R.id.action_send4Fragment_to_send5Fragment)
            }
        }
        // 뒤로 버튼 클릭
        binding.btBack.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_send4Fragment_to_send3Fragment)
        }

        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.send4 = this
    }

    // 은행 버튼 클릭
    fun pickSinhan() {
        binding.tvBefore.visibility = View.GONE
        binding.tvAfter.visibility = View.VISIBLE
        sharedViewModel.setBankName("신한")

        binding.btSinhan.isSelected = true
        binding.btHana.isSelected = false
        binding.btSuhyup.isSelected = false
        binding.btIbk.isSelected = false
        binding.btKakao.isSelected = false
        binding.btKb.isSelected = false
        binding.btNh.isSelected = false
        binding.btEpost.isSelected = false
        binding.btKfcc.isSelected = false
        binding.btUri.isSelected = false
    }

    fun pickHana() {
        binding.tvBefore.visibility = View.GONE
        binding.tvAfter.visibility = View.VISIBLE
        sharedViewModel.setBankName("하나")

        binding.btSinhan.isSelected = false
        binding.btHana.isSelected = true
        binding.btSuhyup.isSelected = false
        binding.btIbk.isSelected = false
        binding.btKakao.isSelected = false
        binding.btKb.isSelected = false
        binding.btNh.isSelected = false
        binding.btEpost.isSelected = false
        binding.btKfcc.isSelected = false
        binding.btUri.isSelected = false
    }

    fun pickSuhyup() {
        binding.tvBefore.visibility = View.GONE
        binding.tvAfter.visibility = View.VISIBLE
        sharedViewModel.setBankName("수협")

        binding.btSinhan.isSelected = false
        binding.btHana.isSelected = false
        binding.btSuhyup.isSelected = true
        binding.btIbk.isSelected = false
        binding.btKakao.isSelected = false
        binding.btKb.isSelected = false
        binding.btNh.isSelected = false
        binding.btEpost.isSelected = false
        binding.btKfcc.isSelected = false
        binding.btUri.isSelected = false
    }

    fun pickIbk() {
        binding.tvBefore.visibility = View.GONE
        binding.tvAfter.visibility = View.VISIBLE
        sharedViewModel.setBankName("IBK기업")

        binding.btSinhan.isSelected = false
        binding.btHana.isSelected = false
        binding.btSuhyup.isSelected = false
        binding.btIbk.isSelected = true
        binding.btKakao.isSelected = false
        binding.btKb.isSelected = false
        binding.btNh.isSelected = false
        binding.btEpost.isSelected = false
        binding.btKfcc.isSelected = false
        binding.btUri.isSelected = false
    }

    fun pickKakao() {
        binding.tvBefore.visibility = View.GONE
        binding.tvAfter.visibility = View.VISIBLE
        sharedViewModel.setBankName("카카오뱅크")

        binding.btSinhan.isSelected = false
        binding.btHana.isSelected = false
        binding.btSuhyup.isSelected = false
        binding.btIbk.isSelected = false
        binding.btKakao.isSelected = true
        binding.btKb.isSelected = false
        binding.btNh.isSelected = false
        binding.btEpost.isSelected = false
        binding.btKfcc.isSelected = false
        binding.btUri.isSelected = false
    }

    fun pickKb() {
        binding.tvBefore.visibility = View.GONE
        binding.tvAfter.visibility = View.VISIBLE
        sharedViewModel.setBankName("KB국민")

        binding.btSinhan.isSelected = false
        binding.btHana.isSelected = false
        binding.btSuhyup.isSelected = false
        binding.btIbk.isSelected = false
        binding.btKakao.isSelected = false
        binding.btKb.isSelected = true
        binding.btNh.isSelected = false
        binding.btEpost.isSelected = false
        binding.btKfcc.isSelected = false
        binding.btUri.isSelected = false
    }

    fun pickNh() {
        binding.tvBefore.visibility = View.GONE
        binding.tvAfter.visibility = View.VISIBLE
        sharedViewModel.setBankName("NH농협")

        binding.btSinhan.isSelected = false
        binding.btHana.isSelected = false
        binding.btSuhyup.isSelected = false
        binding.btIbk.isSelected = false
        binding.btKakao.isSelected = false
        binding.btKb.isSelected = false
        binding.btNh.isSelected = true
        binding.btEpost.isSelected = false
        binding.btKfcc.isSelected = false
        binding.btUri.isSelected = false
    }

    fun pickEpost() {
        binding.tvBefore.visibility = View.GONE
        binding.tvAfter.visibility = View.VISIBLE
        sharedViewModel.setBankName("우체국")

        binding.btSinhan.isSelected = false
        binding.btHana.isSelected = false
        binding.btSuhyup.isSelected = false
        binding.btIbk.isSelected = false
        binding.btKakao.isSelected = false
        binding.btKb.isSelected = false
        binding.btNh.isSelected = false
        binding.btEpost.isSelected = true
        binding.btKfcc.isSelected = false
        binding.btUri.isSelected = false
    }

    fun pickKfcc() {
        binding.tvBefore.visibility = View.GONE
        binding.tvAfter.visibility = View.VISIBLE
        sharedViewModel.setBankName("새마을")

        binding.btSinhan.isSelected = false
        binding.btHana.isSelected = false
        binding.btSuhyup.isSelected = false
        binding.btIbk.isSelected = false
        binding.btKakao.isSelected = false
        binding.btKb.isSelected = false
        binding.btNh.isSelected = false
        binding.btEpost.isSelected = false
        binding.btKfcc.isSelected = true
        binding.btUri.isSelected = false
    }

    fun pickUri() {
        binding.tvBefore.visibility = View.GONE
        binding.tvAfter.visibility = View.VISIBLE
        sharedViewModel.setBankName("우리")

        binding.btSinhan.isSelected = false
        binding.btHana.isSelected = false
        binding.btSuhyup.isSelected = false
        binding.btIbk.isSelected = false
        binding.btKakao.isSelected = false
        binding.btKb.isSelected = false
        binding.btNh.isSelected = false
        binding.btEpost.isSelected = false
        binding.btKfcc.isSelected = false
        binding.btUri.isSelected = true
    }
}