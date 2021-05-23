package com.example.mobilelibrs

class Reservation {
    var libName:String=""
    var date:String=""
    var fromtime:String=""
    var totime:String=""
    var tableNo:Int=0


    constructor(libName:String, date:String, fromtime:String, totime:String, tableNo:Int){
       this.libName=libName
        this.date=date
        this.fromtime=fromtime
        this.totime=totime
        this.tableNo=tableNo
    }

    // make reservation page 1: list library page for constructor
    constructor(libName:String){
        this.libName=libName
    }

