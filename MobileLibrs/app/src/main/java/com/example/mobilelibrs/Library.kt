package com.example.mobilelibrs

import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.*
import java.util.Calendar.YEAR

class Library {

    var LibraryName: String = ""
    var LibraryAddress: String = ""
    var LibraryCapacity: Int = 0

    var libraryList = ArrayList<String>()
    var TimeSlotList = ArrayList<String>()
    var TableList = ArrayList<String>()
    var DateList = ArrayList<String>()
    // var LibraryList = ArrayList<Library>()

    constructor(libName: String, libAddress: String, libCapacity: Int) {
        this.LibraryName = libName
        this.LibraryAddress = libAddress
        this.LibraryCapacity = libCapacity

        var dates = arrayOf("09.08.2021", "09.09.2021")
        var tslots = arrayOf("9:00-10:00", "10:00-11:00")
        var tbls = arrayOf("T1", "T2", "T3")

        for(date in dates) {
            DateList.add(date)
        }
        for(ts in tslots) {
            TimeSlotList.add(ts)
        }
        for(tb in tbls) {
            TableList.add(tb)
        }

        //libraryList.add(LibraryName)
        //     LibraryList.add(Library(LibraryName, LibraryAddress, LibraryCapacity, libraryNo))
    }



}