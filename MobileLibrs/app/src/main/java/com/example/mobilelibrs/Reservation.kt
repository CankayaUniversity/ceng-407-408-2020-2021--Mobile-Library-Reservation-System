package com.example.mobilelibrs

class Reservation {
    var libName:String=""
    var date:String=""
    var timeslot:String=""
    var tableNo:Int=0

    constructor(){
        this.libName=libName
        this.date=date
        this.timeslot=timeslot
        this.tableNo=tableNo

    }
    constructor(libName:String, date:String, timeslot:String,tableNo:Int){
        this.libName=libName
        this.date=date
        this.timeslot=timeslot
        this.tableNo=tableNo
    }

    constructor(libName:String){
        this.libName=libName

    }
    constructor( date:String, timeslot:String){

        this.date=date
        this.timeslot=timeslot
    }
    constructor(tableNo:Int){
        this.tableNo=tableNo
    }



}
