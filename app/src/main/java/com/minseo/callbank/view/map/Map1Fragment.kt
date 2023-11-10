package com.minseo.callbank.view.map

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.fragment.app.viewModels
import com.minseo.callbank.R
import com.minseo.callbank.databinding.FragmentMap1Binding
import com.minseo.callbank.view_model.BankViewModel
import com.skt.Tmap.TMapMarkerItem
import com.skt.Tmap.TMapView

class Map1Fragment : Fragment() {
    private lateinit var binding: FragmentMap1Binding
    private lateinit var mapActivity: MapActivity

    private val bankViewModel: BankViewModel by viewModels()

//    override fun onAttach(context: Context) {
//        super.onAttach(context)
//        mapActivity = context as MapActivity
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentMap1Binding.inflate(inflater, container, false)
        binding = fragmentBinding

        bankViewModel.fetchFirebaseData()

//        val tMapView = TMapView(mapActivity)
//        tMapView.setSKTMapApiKey(getString(R.string.tmap_api_key))
//
//        val markerItem = TMapMarkerItem()

        return fragmentBinding.root
    }
}