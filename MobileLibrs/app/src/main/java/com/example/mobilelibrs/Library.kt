package com.example.mobilelibrs

class Library {

    var LibraryName: String = ""
    var LibraryAddress: String = ""
    var LibraryCapacity: Int = 0
    //  var LibraryList = ArrayList<Library>()

    constructor(libName: String, libAddress: String, libCapacity: Int) {
        this.LibraryName = libName
        this.LibraryAddress = libAddress
        this.LibraryCapacity = libCapacity
        //     LibraryList.add(Library(LibraryName, LibraryAddress, LibraryCapacity, libraryNo))

    }
}