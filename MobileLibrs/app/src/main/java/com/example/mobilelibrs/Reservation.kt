package com.example.mobilelibrs

class Reservation {
    var libName:String=""
    var date:String=""
    var timeslot:String=""
    var tableNo:Int=0

    constructor(libName:String, date:String, timeslot:String,tableNo:Int){
        this.libName=libName
        this.date=date
        this.timeslot=timeslot
        this.tableNo=tableNo
    }
}
