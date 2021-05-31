package com.example.mobilelibrs

class Library {

    var LibraryName: String = ""
    var LibraryAddress: String = ""
    var LibraryCapacity: Int = 0

    var libNameSpinner: String = ""
    var LibraryList = ArrayList<Library>()

    // var LibraryList = ArrayList<Library>()
    constructor() {}

    constructor(libName: String, libAddress: String, libCapacity: Int) {
        this.LibraryName = libName
        this.LibraryAddress = libAddress
        this.LibraryCapacity = libCapacity
        LibraryList.add(Library(LibraryName,LibraryAddress,LibraryCapacity))
        //     LibraryList.add(Library(LibraryName, LibraryAddress, LibraryCapacity, libraryNo))
    }

    fun setLibName(ln:String)
    {
        libNameSpinner = ln
    }
    fun getLibName(): String
    {
        return libNameSpinner
    }


}