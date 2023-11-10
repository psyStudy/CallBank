package com.minseo.callbank.view_model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.minseo.callbank.model.Bank

class BankViewModel : ViewModel() {
    var _bankData = MutableLiveData<List<Bank>>()
    val bankData: LiveData<List<Bank>>
        get() = _bankData

    fun fetchFirebaseData() {
        val database = Firebase.database
        val myRef = database.getReference("bank")

        myRef.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val newBankData = mutableListOf<Bank>()

                for (ds in snapshot.children) {
                    val id : String = ds.key.toString()
                    val name : String = ds.child("name").value as String
                    val place : String = ds.child("place").value as String
                    val address : String = ds.child("address").value as String
                    val tel : String = ds.child("tel").value as String
                    val latitude : Double = ds.child("latitude").value as Double
                    val longitude : Double = ds.child("longitude").value as Double

                    val dsm = Bank(id, name, place, address, tel, latitude, longitude, false)
                    newBankData.add(dsm)
                }
                Log.d("newBankData", newBankData.size.toString())
                _bankData.value = newBankData
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }
}