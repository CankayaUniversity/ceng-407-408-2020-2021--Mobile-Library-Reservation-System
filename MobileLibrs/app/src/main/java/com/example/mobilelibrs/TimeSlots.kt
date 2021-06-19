package com.example.mobilelibrs

class TimeSlots {

    var TimeSlot_1:String? = null
    var TimeSlot_2:String? = null
    var TimeSlot_3:String? = null

    constructor() {
        this.TimeSlot_1 = "9:00-10:00"
        this.TimeSlot_2 = "10:00-11:00"
        this.TimeSlot_3 = "11:00-12:00"
    }

    constructor( timeslot1:String , timeslot2:String, timeslot3:String )
    {
        this.TimeSlot_1 = timeslot1
        this.TimeSlot_2 = timeslot2
        this.TimeSlot_3 = timeslot3
    }
}