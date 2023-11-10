package com.minseo.callbank.view.map

import android.location.Location
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.asFlow
import androidx.lifecycle.asLiveData
import com.minseo.callbank.databinding.BankItemBinding
import com.minseo.callbank.databinding.FragmentMap2Binding
import com.minseo.callbank.view_model.BankViewModel
import com.minseo.callbank.view_model.LocationModel
import com.minseo.callbank.view_model.LocationViewModel
import kotlinx.coroutines.flow.combine
import java.util.*

class Map2Fragment : Fragment() {
    private lateinit var binding: FragmentMap2Binding
    private lateinit var viewPagerAdapter: ViewPagerAdapter

    private val bankViewModel: BankViewModel by viewModels()
    private val locationViewModel: LocationViewModel by viewModels()

    lateinit var adapter: BankListAdapter

//    private val bankItems by lazy {
//        combine(
//            listOf(
//                bankViewModel.bankData.asFlow(),
//                locationViewModel.getLocationData().asFlow()
//            )
//        ) {
//            val items = it[0] as? List<Bank>
//            val location = it[1] as? LocationModel
//
//            if (items == null || items.isEmpty() || location == null) {
//                return@combine items ?: Collections.emptyList<Bank>()
//            } else {
//                items.forEach {
//                    it.distance = run {
//                        val l1 = Location("l1").apply {
//                            latitude = it.latitude
//                            longitude = it.longitude
//                        }
//                        val l2 = Location("l2").apply {
//                            latitude = location.latitude
//                            longitude = location.longitude
//                        }
//                        l1.distanceTo(l2).toDouble()
//                    }
//                }
//
//                return@combine items
//            }
//        }.asLiveData()
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentMap2Binding.inflate(inflater, container, false)
        binding = fragmentBinding

        bankViewModel.fetchFirebaseData()

        binding.bankRecycler.setHasFixedSize(true)
        adapter = BankListAdapter()
        binding.bankRecycler.adapter = adapter

        bankViewModel.bankData.observe(this, Observer {
            adapter.submitList(it)
        })

        return fragmentBinding.root
    }
}