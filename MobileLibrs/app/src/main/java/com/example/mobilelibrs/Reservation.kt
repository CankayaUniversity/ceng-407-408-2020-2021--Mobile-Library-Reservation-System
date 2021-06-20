package com.example.mobilelibrs

class Reservation {
    var userId: String=""
    var libName:String=""
    var date:String=""
    var timeSlot:String=""
    var tableNo:String=""
    var resId:String=""


    constructor(userId:String, resId:String, libName:String, date:String, timeSlot:String, tableNo: String){
        this.libName=libName
        this.date=date
        this.timeSlot=timeSlot
        this.tableNo=tableNo
        this.userId = userId
        this.resId=resId
    }
}

