package com.minseo.callbank.view_model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.gms.common.config.GservicesValue.value
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class UserViewModel : ViewModel() {

    private lateinit var auth: FirebaseAuth

    val _id = MutableLiveData<String>()
    val id: LiveData<String> = _id

    val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    val _name = MutableLiveData<String>("")
    val name: LiveData<String> = _name

    val _tel = MutableLiveData<String>("")
    val tel: LiveData<String> = _tel

    val _birth = MutableLiveData<String>("")
    val birth: LiveData<String> = _birth

    val _pro_name = MutableLiveData<String>("")
    val pro_name: LiveData<String> = _pro_name

    val _pro_tel = MutableLiveData<String>("")
    val pro_tel: LiveData<String> = _pro_tel

    val idError = MutableLiveData<String?>()
    val pwdError = MutableLiveData<String?>()

    val nameError = MutableLiveData<String?>()
    val telError = MutableLiveData<String?>()
    val birthError = MutableLiveData<String?>()

    val proNameError = MutableLiveData<String?>()
    val proTelError = MutableLiveData<String?>()

    val flag = MutableLiveData<Boolean>(false)


    fun setIdPwd(userId: String, userPwd: String, userPwdCheck: String) {
        if (userId == "") {
            idError.value = "이메일을 적어주세요"
            flag.value = false
        }
        else if (!userId.contains("@")) {
            idError.value = "이메일 형식이 잘못 되었습니다"
            flag.value = false
        }
        else if (userPwd == "") {
            pwdError.value = "비밀번호를 적어주세요"
            flag.value = false
        }
        else if (userPwdCheck == "") {
            pwdError.value = "비밀번호 확인을 적어주세요"
            flag.value = false
        }
        else if (!userPwd.equals(userPwdCheck)) {
            pwdError.value = "비밀번호가 같지 않아요"
            flag.value = false
        }
        else {
            _id.value = userId
            _password.value = userPwd
            flag.value = true
        }
    }

    fun setNameTelBirth(userName: String, userTel: String, userBirth: String) {
        if (userName == "") {
            nameError.value = "이름을 적어주세요"
            flag.value = false
        }
        else if (userTel == "") {
            telError.value = "전화번호를 적어주세요"
            flag.value = false
        }
        else if (userBirth == "") {
            birthError.value = "생년월일을 적어주세요"
            flag.value = false
        }
        else if (userBirth.length != 8) {
            birthError.value = "8자리로 입력해주세요 예) 19700308"
            flag.value = false
        }
        else {
            _name.value = userName
            _tel.value = userTel
            _birth.value = userBirth
            flag.value = true
        }
    }

    fun setProNameTel(userProName: String, userProTel: String) {
        if (userProName == "") {
            proNameError.value = "수신인의 이름을 적어주세요"
            flag.value = false
        }
        else if (userProTel == "") {
            proTelError.value = "수신인의 전화번호를 적어주세요"
            flag.value = false
        }
        else {
            _pro_name.value = userProName
            _pro_tel.value = userProTel
            flag.value = true
        }
    }


    fun createUser() : Boolean {
        var result = true
        auth = FirebaseAuth.getInstance()

        auth.createUserWithEmailAndPassword(id.value.toString(), password.value.toString())
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val database = Firebase.database
                    val myRef = database.getReference("user")
                    val newId = id.value.toString().replace('.', ',')

                    myRef.child(newId).child("name").setValue(name.value)
                    myRef.child(newId).child("tel").setValue(tel.value)
                    myRef.child(newId).child("birth").setValue(birth.value)
                    myRef.child(newId).child("pro_name").setValue(pro_name.value)
                    myRef.child(newId).child("pro_tel").setValue(pro_tel.value)
                }
                else {
                    result = false
                }
            }
            .addOnFailureListener {
                result = false
            }

        return result
    }

    fun loginUser() : Boolean {
        var result = true
        auth = FirebaseAuth.getInstance()

        auth.signInWithEmailAndPassword(id.value.toString(), password.value.toString())
            .addOnCompleteListener { task ->
                if (task.isSuccessful)
                    result = true
                else
                    result = false
            }

        return result
    }
}