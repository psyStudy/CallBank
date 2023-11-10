package com.minseo.callbank.model

class User {
    var id: String = ""
    var password: String = ""
    var name: String = ""
    var tel: String = ""
    var birth: String = ""
    var pro_name: String = ""
    var pro_tel: String = ""

    constructor(_id: String, _password: String, _name: String, _tel: String, _birth: String, _pro_name: String, _pro_tel: String) {
        this.id = _id
        this.password = _password
        this.name = _name
        this.tel = _tel
        this.birth = _birth
        this.pro_name = _pro_name
        this.pro_tel = _pro_tel
    }
}