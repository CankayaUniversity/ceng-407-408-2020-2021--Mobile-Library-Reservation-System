package com.example.mobilelibrs

class Reservation {
    var libName:String=""
    var date:String=""
    var timeSlot:String=""
    var tableNo:Int=0


    constructor(libName:String, date:String, timeSlot:String, tableNo:Int){
       this.libName=libName
        this.date=date
        this.timeSlot=timeSlot
        this.tableNo=tableNo
    }

    // make reservation page 1: list library page for constructor
    constructor(libName:String) {
        this.libName = libName
    }
}

