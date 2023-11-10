package com.minseo.callbank.view.speech

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.minseo.callbank.R
import com.minseo.callbank.databinding.FragmentMainBinding
import com.minseo.callbank.databinding.SpeechRecognitionBinding

class SpeechRecognition : Fragment() {
    private lateinit var binding: SpeechRecognitionBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = SpeechRecognitionBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        initView()
        return fragmentBinding.root
    }

    private fun initView() = with(binding) {
        binding.btSpeech.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_speechRecognition_to_speechRecognition2)
        }
    }
}