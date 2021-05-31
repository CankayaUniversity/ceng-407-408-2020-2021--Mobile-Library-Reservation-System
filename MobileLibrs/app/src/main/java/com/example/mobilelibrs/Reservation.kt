package com.example.mobilelibrs

class Reservation {
    var userId: String=""
    var libName:String=""
    var date:String=""
    var timeSlot:String=""
    var tableNo:Int=0


    constructor(userId:String,libName:String, date:String, timeSlot:String, tableNo:Int){
        this.libName=libName
        this.date=date
        this.timeSlot=timeSlot
        this.tableNo=tableNo
        this.userId = userId
    }

}

