package com.minseo.callbank.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SendViewModel : ViewModel() {

    private val _sender_account_num = MutableLiveData<String>("")
    val sender_account_num: LiveData<String> = _sender_account_num

    private val _sender_bank_name = MutableLiveData<String>("")
    val sender_bank_name: LiveData<String> = _sender_bank_name

    private val _recipient_account_num = MutableLiveData<String>("")
    val recipient_account_num: LiveData<String> = _recipient_account_num

    private val _recipient_bank_name = MutableLiveData<String>("")
    val recipient_bank_name: LiveData<String> = _recipient_bank_name

    private val _tran_amt = MutableLiveData<Int>(0)
    val tran_amt: LiveData<Int> = _tran_amt


    fun setSender(accountNum: String, bankName: String) {
        _sender_account_num.value = accountNum
        _sender_bank_name.value = bankName
    }

    fun setBankName(bankName: String) {
        _recipient_bank_name.value = bankName
    }

    fun hasNoBankNameSet(): Boolean {
        return _recipient_bank_name.value.isNullOrEmpty()
    }

    fun setAccountNum(accountNum: String) {
        _recipient_account_num.value = accountNum
    }

    fun setAmount(amount: Int) {
        _tran_amt.value = amount
    }
}