package com.minseo.callbank.model

class Bank {
    var id: String = ""
    var name: String = ""
    var place: String = ""
    var address: String = ""
    var tel: String = ""
    var distance: Double = 0.0
    var latitude: Double = 0.0
    var longitude: Double = 0.0
    var isExpanded: Boolean = false

    constructor(_id: String, _name: String, _place: String, _address: String, _tel: String,
        _latitude: Double, _longitude: Double, _isExpanded: Boolean) {

        this.id = _id
        this.name = _name
        this.place = _place
        this.address = _address
        this.tel = _tel
        this.latitude = _latitude
        this.longitude = _longitude
        this.isExpanded = _isExpanded
    }
}